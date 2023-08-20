package com.example.project.dao;

import com.example.project.bean.Sharing;
import com.example.project.bean.SharingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SharingMapper {
    int countByExample(SharingExample example);

    int deleteByExample(SharingExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Sharing record);

    int insertSelective(Sharing record);

    List<Sharing> selectByExample(SharingExample example);

    Sharing selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Sharing record, @Param("example") SharingExample example);

    int updateByExample(@Param("record") Sharing record, @Param("example") SharingExample example);

    int updateByPrimaryKeySelective(Sharing record);

    int updateByPrimaryKey(Sharing record);
}