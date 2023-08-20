package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper; 
import cn.hutool.json.JSONObject;

import java.nio.charset.StandardCharsets;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.project.bean.*;
import com.example.project.dao.*;
import com.example.project.service.BookService;
import com.example.project.service.StationService;
import com.example.project.utils.Result;
import com.example.project.utils.utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/book")
public class BookController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    /* DEBUG :没有autowire导致实例为null */
    @Autowired
    private PublicationMapper pubmapper;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookMapper bookMappper;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private StationService stationService;

    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BorrowInfoMapper borrInfoMapper;

    @PostMapping("/delete/{bid}")
    @ResponseBody
    public Result<?> deletebook(@PathVariable("bid") int bid) {
        int ret = borrowMapper.deleteByPrimaryKey(bid);

        
        ret = bookMappper.deleteByPrimaryKey(bid);
        if (ret > 0)
            return Result.success();
        else
            return Result.error("111", "delete failed");
    }

    @PostMapping("/insert")
    @ResponseBody
    public Result<?> save(@RequestBody JSONObject body) {
        // Console.error(body);
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] publicationBytes = body.get("publication").toString().getBytes(StandardCharsets.UTF_8);

        Publication publication;
        
        try {
            publication = objectMapper.readValue(publicationBytes, Publication.class);
            
            publication.setBnwid(utils.getUint(publication.getIsbn()));
        } catch (Exception e) {
            logger.error("Error parsing publication JSON", e);
            return Result.error("400", "Invalid publication JSON");
        }
        
        int atstation = utils.getUint(body.get("atstation").toString());
        String status =body.get("status").toString();
        
        bookService.addbook(publication, atstation, status);
        /*不管了直接都successs */
        return Result.success();
    }

    @PostMapping("/update")
    @ResponseBody

    public Result<?> update(@RequestBody JSONObject body) {
        // Console.error(body);
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] publicationBytes = body.get("publication").toString().getBytes(StandardCharsets.UTF_8);
        Publication publication;
        String isbn;
        try {
            publication = objectMapper.readValue(publicationBytes, Publication.class);
            isbn = publication.getIsbn();
            publication.setIsbn(null);
           
        } catch (Exception e) {
            logger.error("Error parsing publication JSON", e);
            return Result.error("400", "Invalid publication JSON");
        }
        int bid = utils.getUint(body.get("bid").toString());
        int atstation = utils.getUint(body.get("atstation").toString());
        String status = body.get("status").toString();
        PublicationExample exa=new PublicationExample();
        exa.or().andIsbnEqualTo(isbn);
        int ret1 = pubmapper.updateByExampleSelective(publication,exa);
        if(ret1<=0)
            return Result.error("225", "更新失败");
        Book b = new Book();
        b.setBid(bid);
        b.setAtstation(atstation);
        b.setStatus(status);
        int ret2 = bookMappper.updateByPrimaryKeySelective(b);
        if (ret2>0)
            return Result.success();
        else
            return Result.error("225", "更新失败");
    }
    
    @GetMapping("/userborrow")
    @ResponseBody
    public Result<?> userborrowPage(@RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search1,
            @RequestParam(defaultValue = "-1") String search3) {
        BorrowInfoExample bookiexa = new BorrowInfoExample();
        
        if (StringUtils.isNotBlank(search1)) {

            bookiexa.or().andAuthorLike("%" + search1 + "%");
            bookiexa.or().andNameLike("%" + search1 + "%");
        }
       
        int uid = utils.getUint(search3);
        if (uid >= 0){
            bookiexa.or().andUidEqualTo(uid);
        }
        Page<BookInfo> page = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> borrInfoMapper.selectByExample(bookiexa));
        Map<String, Object> map = new HashMap<>();
        map.put("records", page.getResult());
        map.put("total", page.getTotal());
        return Result.success(map);
    }

    @RequestMapping(value = "/borrowbook/{bid}/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> borrowbook(@PathVariable("bid") Integer bid,
            @PathVariable("uid") Integer uid) {
        int ret = bookService.borrowBook(bid, uid);
        if (ret >= 0)
            return Result.success();
        else
            return Result.error("111", "borrow failed");
    }

    @RequestMapping(value = "/return/{borrowid}/{atstation}", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> returnbook(
            @PathVariable("borrowid") Integer borrowid,
            @PathVariable("atstation") Integer atstation) {
        if (borrowid < 0)
            return Result.error("332", "no borrowid");
        int ret = bookService.retrunBook(borrowid, atstation);
        if (ret < 0)
            return Result.error("333", "renwal failed");
        else
            return Result.success();
    }
    @RequestMapping(value="/renewal/{borrowid}")
    @ResponseBody
    public Result<?>renewal(@PathVariable("borrowid") String sborrowid)
    {
        int borrowid = utils.getUint(sborrowid);
        if(borrowid<0)return Result.error("332", "no borrowid");
        int ret = bookService.renewal(borrowid);
        if(ret<0)return Result.error("333", "renwal failed");
        else return Result.success();
    }

    @RequestMapping(value = "searchforbook/{title}", method = RequestMethod.GET)
    @ResponseBody
    public List<Publication> searchForBook(@PathVariable("title") String title) {

        if (title.equals("1")) {
            List<Publication> test = new ArrayList<>();
            test.add(pubmapper.selectByPrimaryKey("9787530216835"));
            logger.info(test.toString());
            return test;
        }
        /*
         * debug : pubexample.or()意思是条件的集合并。
         * 串联.andXX()表示and一个新条件
         * https://www.cnblogs.com/kaixinyufeng/p/8329954.html
         * 这个东西的好处在于不用修改xml和mapper，很大程度上可以依赖自动生成的xml和mapper，
         * 当开发过程中需要修改数据模型时，可以直接修改数据库然后逆向生成，不用担心覆盖自定义的sql
         */
        /* 条件查询 selectByExample */
        PublicationExample pubexample = new PublicationExample();

        pubexample.or().andAuthorLike("%" + title + "%");
        pubexample.or().andNameLike("%" + title + "%");
        /* DEBUG 假设wtihBlob才能读到text字段 */
        return pubmapper.selectByExampleWithBLOBs(pubexample);
    }

    @GetMapping("/search")
    @ResponseBody
    public Result<?>findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "-1") String search1,
                              @RequestParam(defaultValue = "") String search2)
    {
        BookInfoExample bookexa = new BookInfoExample();
        if(StringUtils.isNotBlank(search2))
        {

            bookexa.or().andAuthorLike("%" + search2 + "%");
            bookexa.or().andNameLike("%" + search2 + "%");
            /* DEBUG 假设wtihBlob才能读到text字段 */

        }
        int sta = utils.getUint(search1);
        if(sta>=0)
        {
            bookexa.or().andAtstationEqualTo(sta);
        }
        // PageHelper.offsetPage(pageNum, pageSize);
        Page<BookInfo> page = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> bookInfoMapper.selectByExample(bookexa));
        Map<String, Object> map = new HashMap<>();
        map.put("records", page.getResult());
        map.put("total", page.getTotal());
        return Result.success(map);

    }

    @RequestMapping(value = "bookinfo/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public List<BookInfo> getBookInfo(@PathVariable("isbn") String isbn) {
        return bookService.getBooksByISNB(isbn);
    }

    @RequestMapping(value = "bookinfoByBid/{bid}", method = RequestMethod.GET)
    @ResponseBody
    public BookInfo getBookInfoByBid(@PathVariable("bid") int id) {
        return bookService.getBooksByBID(id);
    }

}
