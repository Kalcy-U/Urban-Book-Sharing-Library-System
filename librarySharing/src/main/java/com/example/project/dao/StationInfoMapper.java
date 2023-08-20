package com.example.project.dao;

import com.example.project.bean.StationInfo;
import com.example.project.bean.StationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StationInfoMapper {
    int countByExample(StationInfoExample example);

    int deleteByExample(StationInfoExample example);

    int insert(StationInfo record);

    int insertSelective(StationInfo record);

    List<StationInfo> selectByExample(StationInfoExample example);

    int updateByExampleSelective(@Param("record") StationInfo record, @Param("example") StationInfoExample example);

    int updateByExample(@Param("record") StationInfo record, @Param("example") StationInfoExample example);
}