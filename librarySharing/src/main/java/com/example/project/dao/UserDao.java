package com.example.project.dao;

import org.apache.ibatis.annotations.*;

import com.example.project.bean.User;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM `User`")
    List<User> findAllUser();

    @Select("SELECT * FROM `User` WHERE UID=#{UID}")
    User getUser(@Param("UID") int UID);

    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO `User` (`UserName`, `PhoneNumber`, `Credict`, `Discription`, `Password`, `isVolunteer`, `UStatus`) VALUES(#{UserName}, #{PhoneNumber}, #{Credict}, #{Discription}, #{Password},#{isVolunteer}, #{UStatus})")
    void insertUser(@Param("UserName") String UserName, @Param("PhoneNumber") String PhoneNumber,
            @Param("Credict") int Credict, @Param("Discription") String Discription, @Param("Password") String Password,
            @Param("isVolunteer") boolean isVolunteer, @Param("UStatus") String UStatus);

    /**
     * 根据 id 更新用户信息
     */
    @Update("UPDATE `User`(`UID`,`UserName`, `PhoneNumber`, `Credict`, `Discription`, `Password`, `isVolunteer`, `UStatus`) VALUES(#{UID},#{UserName}, #{PhoneNumber}, #{Credict}, #{Discription}, #{Password},#{isVolunteer}, #{UStatus})")
    void updateUser(
            @Param("UID") int UID, @Param("UserName") String UserName, @Param("PhoneNumber") String PhoneNumber,
            @Param("Credict") int Credict, @Param("Discription") String Discription, @Param("Password") String Password,
            @Param("isVolunteer") boolean isVolunteer, @Param("UStatus") String UStatus);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from `User` WHERE UID = #{UID}")
    void deleteUser(@Param("UID") int UID);
}