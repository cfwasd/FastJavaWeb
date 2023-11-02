package com.example.factory.control;


import service.NewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsService newsService = new NewsService();
        String cmd = request.getParameter("cmd");
        if (cmd.equals("delete")) {
            String id = request.getParameter("id");

            newsService.delete(Long.valueOf(id));
            response.sendRedirect("/news?cmd=find");
        } else{
            List list = newsService.query();
            request.setAttribute("newslist", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/newsList.jsp");//设置跳转的路径
            dispatcher.forward(request, response);//跳转动作
        }
    }
}
