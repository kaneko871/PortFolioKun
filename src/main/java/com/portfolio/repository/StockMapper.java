package com.portfolio.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Stock;

/*利用していないクラス。JPAからMybatisに切り替えときのために残す。*/
@Mapper
public interface StockMapper {
    @Select("SELECT * FROM stock")
    public List<Stock> findAll();

    @Select("SELECT * FROM stock WHERE stock_id = #{stockId}")
    public Stock findById(@Param("stockId") String stockId);

}
