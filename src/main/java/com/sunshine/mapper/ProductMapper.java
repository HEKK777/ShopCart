package com.sunshine.mapper;

import com.sunshine.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    List<Product> GetInfo();
    int DeleteById(@Param("id") String id);
}