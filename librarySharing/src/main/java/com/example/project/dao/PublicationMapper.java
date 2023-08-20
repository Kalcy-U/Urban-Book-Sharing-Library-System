package com.example.project.dao;

import com.example.project.bean.Publication;
import com.example.project.bean.PublicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublicationMapper {
    int countByExample(PublicationExample example);

    int deleteByExample(PublicationExample example);

    int deleteByPrimaryKey(String isbn);

    int insert(Publication record);

    int insertSelective(Publication record);

    List<Publication> selectByExampleWithBLOBs(PublicationExample example);

    List<Publication> selectByExample(PublicationExample example);

    Publication selectByPrimaryKey(String isbn);

    int updateByExampleSelective(@Param("record") Publication record, @Param("example") PublicationExample example);

    int updateByExampleWithBLOBs(@Param("record") Publication record, @Param("example") PublicationExample example);

    int updateByExample(@Param("record") Publication record, @Param("example") PublicationExample example);

    int updateByPrimaryKeySelective(Publication record);

    int updateByPrimaryKeyWithBLOBs(Publication record);

    int updateByPrimaryKey(Publication record);
}