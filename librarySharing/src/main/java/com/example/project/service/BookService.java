package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.bean.Book;
import com.example.project.bean.BookExample;
import com.example.project.bean.BookInfo;
import com.example.project.bean.BookInfoExample;
import com.example.project.bean.Borrow;
import com.example.project.bean.BorrowExample;
import com.example.project.bean.BorrowInfo;
import com.example.project.bean.BorrowInfoExample;
import com.example.project.bean.Publication;
import com.example.project.dao.BookInfoMapper;
import com.example.project.dao.BookMapper;
import com.example.project.dao.BorrowInfoMapper;
import com.example.project.dao.BorrowMapper;
import com.example.project.dao.PublicationMapper;
import com.example.project.config.Reference;
import ch.qos.logback.classic.Logger;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper mybookMapper;
    @Autowired
    private PublicationMapper pubMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Autowired 
    private BorrowMapper borrowMapper;

    @Autowired
    private BorrowInfoMapper borrowInfoMapper;

    /* 查找一个出版物 */
    public Publication getPubByISBN(String isbn) {
        return pubMapper.selectByPrimaryKey(isbn);
    }

    /**
     * 按书号查找书
     */
    public List<BookInfo> getBooksByISNB(String isbn) {
        BookInfoExample binfoExa = new BookInfoExample();
        binfoExa.createCriteria().andIsbnEqualTo(isbn);
        return bookInfoMapper.selectByExample(binfoExa);
    }

    /**
     * 按BID查找书.view没有主键所以不能直接根据key找
     */
    public BookInfo getBooksByBID(int BID) {
        BookInfoExample binfoExa = new BookInfoExample();
        binfoExa.createCriteria().andBidEqualTo(BID);
        List<BookInfo> l = bookInfoMapper.selectByExample(binfoExa);
        if (l.isEmpty())
            return null;
        else
            return l.get(0);
    }

    /* 按站点查找书 */
    public List<BookInfo> getBooksByStation(int station) {
        BookInfoExample binfoExa = new BookInfoExample();
        binfoExa.createCriteria().andAtstationEqualTo(station);
        return bookInfoMapper.selectByExample(binfoExa);
    }

    /* 查询用户所有借阅记录 */
    public List<BorrowInfo> getUserBorrowRecords(int uid) {
        BorrowInfoExample brinfoExa = new BorrowInfoExample();
        brinfoExa.createCriteria().andUidEqualTo(uid);
        return borrowInfoMapper.selectByExample(brinfoExa);
    }

    // ! 借还书相关业务
    /* 借一本书 更改图书book.Status状态 */
    public int borrowBook(int bid, int uid) {
        Book b = mybookMapper.selectByPrimaryKey(bid);
        if (b.getStatus().equals("在馆")) {
            
            // b.setAtstation(null);// 将地点设为null
            Book bn = new Book();
            bn.setBid(bid);
            bn.setStatus("外借");
            mybookMapper.updateByPrimaryKeySelective(bn);
            // 更改borrow
            Borrow borrow = new Borrow();
            borrow.setBid(bid);
            borrow.setBorrowat(b.getAtstation());
            Date curDate = new Date();
            borrow.setBorrowtime(curDate);
            borrow.setDuetime(Reference.getDueDate(curDate));
            borrow.setRenewal(0);
            borrow.setReturntime(null); 
            borrow.setStatus("未归还");
            borrow.setUid(uid);
            return borrowMapper.insertSelective(borrow);
            
        } else
            return -1;
    }

    /* 还一本书 更改图书book.Status状态 更改borrow各项信息 */
    public int retrunBook(int borrowid, int stationid) {
        // 查borrow表
        Borrow record = borrowMapper.selectByPrimaryKey(borrowid);
        // 更新book信息
        Book b = mybookMapper.selectByPrimaryKey(record.getBid());
        b.setStatus("在馆");
        b.setAtstation(stationid);

        mybookMapper.updateByPrimaryKey(b);
        // 更改Borrow表
        // Borrow borrow = new Borrow();
        // borrow.setBid(bid);
        // borrow.setBorrowat(b.getAtstation());
        // Date curDate = new Date();
        // borrow.setBorrowtime(curDate);

        // borrow.setDuetime(Reference.getDueDate(curDate));
        // borrow.setRenewal(0);
        // borrow.setReturntime(null);
        // borrow.setStatus("未归还");
        // borrow.setUid(uid);
        // borrowMapper.insert(borrow);
        // borrowMapper.updateByPrimaryKeySelective(null);

        record.setReturntime(new Date());
        record.setStatus("已归还");
        return borrowMapper.updateByPrimaryKeySelective(record);

    }

    /* 续借书籍 */
    public int renewal(int borrowid) {
        // 查borrow表
        
        Borrow record = borrowMapper.selectByPrimaryKey(borrowid);
        if (record.getRenewal() >= 5)
            return -1;
        // Duetime=续借日期开始+30天
        record.setDuetime(Reference.getDueDate(record.getDuetime()));
        record.setRenewal(record.getRenewal() + 1);
        return borrowMapper.updateByPrimaryKey(record);
    }

    /*新增书籍 如果是新的出版物(isbn)则还要插入出版物信息 
     * 当isbn在Publication中出现过 则不会更新出版物信息
     */
    public int addbook(Publication pub,int stationid,String status )
    {
        Publication p = pubMapper.selectByPrimaryKey(pub.getIsbn());
        if (p == null)
        {
            pubMapper.insert(pub);
        }
        Book newbook = new Book();
        newbook.setAtstation(stationid);
        newbook.setIsbn(pub.getIsbn());
        newbook.setStatus(status);
        mybookMapper.insert(newbook);
        return 0;
    }

}