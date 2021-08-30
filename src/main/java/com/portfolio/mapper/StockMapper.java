package com.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Stock;


@Mapper
public interface StockMapper {
    @Select("SELECT * FROM stock")
    public List<Stock> findAll();

    @Select("SELECT * FROM stock WHERE stock_id = #{stockId}")
    public Stock findById(@Param("stockId") String stockId);

}
