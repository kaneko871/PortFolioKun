package com.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Stock;


@Mapper
public interface StockMapper {
    @Select("SELECT * FROM stock")
    public List<Stock> findAll();



}
