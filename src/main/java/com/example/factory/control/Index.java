package com.example.factory.control;



import com.example.factory.dao.entry.ProductModel;
import service.IndexService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "index", urlPatterns = "/pro")
public class Index extends HttpServlet {
    IndexService service;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
          *@ClassName Index
          *@Author wzh
          *@Version 1.0
          *@DATE 2023/10/9

          *@Description control（"/pro"）层
          *@param [request, response]
          *@return void
        */
        service = new IndexService();
        List<ProductModel> list;
        String cmd = request.getParameter("cmd");
        if ("find".equals(cmd)) {

            list = service.find();
            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/web/system/news/index.jsp");//设置跳转的路径
            dispatcher.forward(request, response);//跳转动作
        }
    }
}
