package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Communicate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunicateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Communicate record);

    int insertSelective(Communicate record);

    Communicate selectByPrimaryKey(Long id);

    List<Communicate> list(Long orderId);

    int updateByPrimaryKeySelective(Communicate record);

    int updateByPrimaryKey(Communicate record);
}