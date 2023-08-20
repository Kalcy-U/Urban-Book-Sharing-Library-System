package com.example.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.project.bean.BookExample;
import com.example.project.bean.BorrowExample;
import com.example.project.bean.StationExample;
import com.example.project.bean.UserExample;
import com.example.project.dao.BookMapper;
import com.example.project.dao.BorrowMapper;
import com.example.project.dao.StationMapper;
import com.example.project.dao.UserMapper;

import com.example.project.utils.Result;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private StationMapper stationMapper;
    static public Integer LoginCount = 0;
    
    
    @GetMapping
    public Result<?> dashboardrecords() {
        // int visitCount = LoginUser.getVisitCount();
        // QueryWrapper<User> queryWrapper1 = new QueryWrapper();
        int userCount = userMapper.countByExample(new UserExample());
        
        int lendRecordCount = borrowMapper.countByExample(new BorrowExample());

        int bookCount = bookMapper.countByExample(new BookExample());
        int stationCount = stationMapper.countByExample((new StationExample()));
        Map<String, Object> map = new HashMap<>();// 键值对形式
        map.put("stationCount", stationCount);// 放置visitCount到map中
        map.put("userCount", userCount);
        map.put("lendRecordCount", lendRecordCount);
        map.put("bookCount", bookCount);
        return Result.success(map);
    }

}
