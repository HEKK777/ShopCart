package com.sunshine.servlet;

import com.sunshine.dao.ProductDao;
import com.sunshine.bean.Product;
import com.sunshine.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetInfo")
public class GetInfoServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetUsersServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = null;
        try {
            SqlSession sqlsession = GetSqlSession.getSqlSession();
            list = sqlsession.selectList("com.sunshine.mapper.ProductMapper.GetInfo");
        }catch (Exception e) {
            LOGGER.error("获取产品信息失败", e);
            GetSqlSession.rollback();
        }finally {
            GetSqlSession.commit();
        }
        System.out.println(list);
        //发送至前台
        request.setAttribute("lists",list);
        request.getRequestDispatcher("GetInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}