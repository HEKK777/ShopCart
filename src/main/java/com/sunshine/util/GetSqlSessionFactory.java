package com.sunshine.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by WH on 2016/12/3.
 * 使用单例模式获取SqlSessionFactory
 */
public class GetSqlSessionFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetSqlSessionFactory.class);

    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 私有构造方法，使该类不可创建新对象
     */
    private GetSqlSessionFactory(){

    }

    /**
     * 使用同步锁
     * @return sql session 工厂
     */
    synchronized public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
            //获取资源文件流
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                LOGGER.error("Get Resource Error:", e);
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }

}