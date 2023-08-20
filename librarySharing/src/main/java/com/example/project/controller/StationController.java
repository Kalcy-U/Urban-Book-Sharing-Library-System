package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.bean.StationInfo;
import com.example.project.bean.StationInfoExample;
import com.example.project.dao.StationInfoMapper;
import com.example.project.utils.Result;
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
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Controller
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationInfoMapper simapper;
    @GetMapping("/allinfo")
    @ResponseBody
    public Result<?>getStationInfo(@RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize)
    {
        Page<BookInfo> page = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> simapper.selectByExample(new StationInfoExample()));
        Map<String, Object> map = new HashMap<>();
        map.put("records", page.getResult());
        map.put("total", page.getTotal());
        return Result.success(map);
        //return Result.success(simapper.selectByExample(new StationInfoExample()));
    }
}
 