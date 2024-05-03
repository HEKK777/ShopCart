package com.sunshine.servlet;

import com.sunshine.bean.Users;
import com.sunshine.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WH on 2016/12/3.
 */
@WebServlet(name = "GetUsersServlet", value = "/getUsersById")
public class GetUsersServlet extends javax.servlet.http.HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetUsersServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = null;
        try {
            SqlSession sqlSession = GetSqlSession.getSqlSession();
            users = sqlSession.selectOne("users.sql.getUsersById", 3);
        } catch (Exception e) {
            LOGGER.error("select error", e);
            GetSqlSession.rollback();
        } finally {
            GetSqlSession.commit();
        }
        System.out.println(users.toString());
    }
}