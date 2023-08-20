package com.example.project.dao;

import com.example.project.bean.BorrowInfo;
import com.example.project.bean.BorrowInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowInfoMapper {
    int countByExample(BorrowInfoExample example);

    int deleteByExample(BorrowInfoExample example);

    int insert(BorrowInfo record);

    int insertSelective(BorrowInfo record);

    List<BorrowInfo> selectByExample(BorrowInfoExample example);

    int updateByExampleSelective(@Param("record") BorrowInfo record, @Param("example") BorrowInfoExample example);

    int updateByExample(@Param("record") BorrowInfo record, @Param("example") BorrowInfoExample example);
}