package com.sunshine.dao;

import com.sunshine.bean.Product;
import com.sunshine.mapper.ProductMapper;
import com.sunshine.util.GetSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductDao {
    public static List<Product> GetInfo() {
        SqlSessionFactory factory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
        List<Product> Products = mapper.GetInfo();
        session.close();
        return Products;
    }
    public static boolean DeleteById(String id){
        SqlSessionFactory factory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ProductMapper db = session.getMapper(ProductMapper.class);
        int rows = db.DeleteById(id);
        session.commit();
        session.close();
        return rows>0;
    }
}
