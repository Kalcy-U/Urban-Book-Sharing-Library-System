package com.example.project.dao;

import com.example.project.bean.ResponsibleFor;
import com.example.project.bean.ResponsibleForExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResponsibleForMapper {
    int countByExample(ResponsibleForExample example);

    int deleteByExample(ResponsibleForExample example);

    int deleteByPrimaryKey(Integer dutyid);

    int insert(ResponsibleFor record);

    int insertSelective(ResponsibleFor record);

    List<ResponsibleFor> selectByExample(ResponsibleForExample example);

    ResponsibleFor selectByPrimaryKey(Integer dutyid);

    int updateByExampleSelective(@Param("record") ResponsibleFor record, @Param("example") ResponsibleForExample example);

    int updateByExample(@Param("record") ResponsibleFor record, @Param("example") ResponsibleForExample example);

    int updateByPrimaryKeySelective(ResponsibleFor record);

    int updateByPrimaryKey(ResponsibleFor record);
}