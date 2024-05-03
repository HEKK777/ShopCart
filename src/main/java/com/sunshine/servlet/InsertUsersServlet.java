package com.sunshine.servlet;

import com.sunshine.bean.Users;
import com.sunshine.util.GetSqlSession;
import com.sunshine.util.GetSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WH on 2016/12/3.
 */
@WebServlet(name = "InsertUsersServlet", value = "/insertUsers")
public class InsertUsersServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetSqlSessionFactory.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = new Users();
        users.setUsername("liu");
        users.setPassword("123456");
        users.setPassword_salt("sssss");
        try {
            SqlSession sqlSession = GetSqlSession.getSqlSession();
            sqlSession.insert("users.sql.insertUsers", users);
            System.out.println("新增成功！新增id为：" + users.getId());
        } catch (Exception e){
            GetSqlSession.rollback();
            LOGGER.error("insert error", e);
        } finally {
            GetSqlSession.commit();
        }
    }
}