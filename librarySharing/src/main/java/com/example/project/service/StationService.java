package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.bean.*;
import com.example.project.dao.*;
import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationInfoMapper statInfoMapper;

    /**
     * 查看所有stationInfo
     */
    public List<StationInfo> getAllStation() {
        StationInfoExample exa = new StationInfoExample();
        return statInfoMapper.selectByExample(exa);
    }
    /*
     * 某站点所有书
     */

}