package com.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Stock;


@Mapper
public interface StockMapper {
    @Select("SELECT * FROM stock")
    public List<Stock> findAll();

    @Select("SELECT * FROM stock WHERE stock_id = #{stockId}")
    public Stock findById(@Param("stockId") Integer stockId);

    @Select("select max(stock_id) from stock")
    public int selectMaxStockId();
    
    @Insert("insert into stock(user_id,stock_code,stock_name) values"
    		+ " (#{userId}, #{stockCode}, #{stockName})")
    public int insertStock(Stock stock);
}
