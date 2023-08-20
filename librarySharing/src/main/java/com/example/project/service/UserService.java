package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.bean.User;
import com.example.project.bean.UserExample;
import com.example.project.dao.UserMapper;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper myuserDao;

    /**
     * 查找所有用户
     */
    public List<User> selectAllUser() {
        UserExample myuserExample = new UserExample();
        return myuserDao.selectByExample(myuserExample);
    }

    /**
     * 查找一个用户
     */
    public User getUserById(int id) {
        return myuserDao.selectByPrimaryKey(id);
    }

    /**
     * 查找一个用户
     */
    public User getUserByPhone(String phone) {
        UserExample myuserExample = new UserExample();
        myuserExample.createCriteria().andPhonenumberEqualTo(phone);
        List<User> res = myuserDao.selectByExample(myuserExample);
        if (res.isEmpty())
            return null;
        else
            return res.get(0);
    }

    /* 授权用户为志愿者 */
    public void grantVolunteer(int id) {
        User u = new User();
        u.setUid(id);
        u.setIsvolunteer(true);
        myuserDao.updateByPrimaryKeySelective(u);
    }

    /* 更改用户状态 */
    public int changeStuatus(int id, String newstatus) {
        User u = new User();
        u.setUid(id);
        u.setUstatus(newstatus);

        return myuserDao.updateByPrimaryKeySelective(u);
    }

    /* 用户登录检验 */
    public User LoginLegal(String phone, String pw) {
        UserExample myuserExample = new UserExample();
        myuserExample.createCriteria().andPhonenumberEqualTo(phone).andPasswordEqualTo(pw).andUstatusNotEqualTo("禁封");
        List<User> res = myuserDao.selectByExample(myuserExample);
        if (res.isEmpty())
            return null;
        else
            return res.get(0);
    }

    /* 用户登录检验 以志愿者权限 */
    public User LoginVolunteer(String phone, String pw) {
        UserExample myuserExample = new UserExample();
        myuserExample.createCriteria().andPhonenumberEqualTo(phone).andPasswordEqualTo(pw).andIsvolunteerEqualTo(true);
        List<User> res=  myuserDao.selectByExample(myuserExample) ;
        if (res.isEmpty())
            return null;
        else
            return res.get(0);
       
    }

    /* 用户信用是否大于60 */
    public boolean CreditLegal(Integer id) {
        User u = myuserDao.selectByPrimaryKey(id);
        if (u.getUstatus().equals("正常") && u.getCredict() >= 60) {
            return true;
        } else
            return false;
    }

}