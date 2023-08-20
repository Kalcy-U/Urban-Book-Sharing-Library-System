package com.example.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.service.*;
import com.example.project.utils.Result;
import com.example.project.utils.TokenUtils;
import com.example.project.utils.utils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import io.micrometer.common.util.StringUtils;

import com.example.project.bean.*;
import com.example.project.dao.UserMapper;

// RestController: 值返回数据的API控制器。会自动将返回的对象转换为Json
// @Controller 和 @ResponseBody 组合等价于@RestController
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userServe;/* debug:变量名不能叫userServer 会与默认构造的bean冲突 */

    @Autowired
    UserMapper userMapper;

    // @RequestMapping("/{userid}")
    // public User getUser(@PathVariable("userid") int id) {
    //     return userServe.getUserById(id);
    // }

    @CrossOrigin
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        /* @RequestBody从收到的json数据中选择部分构造User结构体 */
        User res = userServe.getUserByPhone(user.getPhonenumber());
        if (res != null) {
            return Result.error("-1", "手机号重复注册");
        }
        User u = new User();
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
        u.setPhonenumber(user.getPhonenumber());
        userMapper.insertSelective(u);
        return Result.success();
    }

    @CrossOrigin
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {
        User res = userServe.LoginLegal(user.getPhonenumber(), user.getPassword());
        if (res == null) {
            return Result.error("-1", "用户名或密码错误");
        }
        String token = TokenUtils.genToken(res);
        res.setToken(token);

        return Result.success(res);
    }

    @GetMapping("/usersearch")
    public Result<?> findPage2(@RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search1,
            @RequestParam(defaultValue = "") String search2,
            @RequestParam(defaultValue = "") String search3,
            @RequestParam(defaultValue = "0") String search4,
            @RequestParam(defaultValue = "100") String search5) {
        UserExample uexa = new UserExample();
        int id = utils.getUint(search1);
        if (id >= 0) {
            uexa.or().andUidEqualTo(id); 
        }
        if (StringUtils.isNotBlank(search2)) {
            uexa.or().andUsernameLike("%" + search2 + "%");
        }
        if (StringUtils.isNotBlank(search3)) {
            uexa.or().andPhonenumberEqualTo(search3);
        }
        int min = utils.getUint(search4);
        int max = utils.getUint(search5);
        if (min >= 0 && max <= 100)
            uexa.or().andCredictBetween(min, max);

        Page<BookInfo> page = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> userMapper.selectByExample(uexa));
        Map<String, Object> map = new HashMap<>();
        map.put("records", page.getResult());
        map.put("total", page.getTotal());
        return Result.success(map);
    }

    @CrossOrigin
    @PostMapping("/update")
    public Result<?> updateUser(@RequestBody User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return Result.success();
    }
    
    @CrossOrigin
    @PostMapping("/changepassword")
    public Result<?> changepassword(@RequestBody User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return Result.success();
    }
    @CrossOrigin
    @DeleteMapping("/{uid}")
    public Result<?> delete(@PathVariable("uid") int id) {
        userMapper.deleteByPrimaryKey(id);
        return Result.success();
    }


}
