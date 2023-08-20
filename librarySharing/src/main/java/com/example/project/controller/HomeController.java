package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.project.service.*;
import com.example.project.bean.*;
import com.example.project.bean.BookExample.Criteria;
import com.example.project.dao.*;

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    /* DEBUG :没有autowire导致实例为null */

    @RequestMapping("/")
    public String home() {
        // Import the necessary logger class

        // Create a logger instance for the HomeController class

        logger.info("hello");
        return "home";// 返回视图名
    }

}
