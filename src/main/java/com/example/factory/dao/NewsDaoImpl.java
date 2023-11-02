package com.example.factory.dao;


import com.example.factory.dao.entry.News;
import com.example.factory.dao.entry.NewsType;
import com.example.factory.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao{

    public List<News> queryNewsList() {
        String sql = "select * from t_news";
        List<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");// 根据字段名（列名）获取数据
                String title = rs.getString("title");
                String context = rs.getString("context");
                Integer viewCount = rs.getInt("viewCount");
                Boolean isRecommend = rs.getBoolean("isRecommend");
                Date inputDate = rs.getDate("inputDate");
                Long type_id = rs.getLong("type_id");
                Long user_id = rs.getLong("user_id");

                // 封装数据
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContext(context);
                news.setViewCount(viewCount);
                news.setIsRecommend(isRecommend);
                news.setInputDate(inputDate);
                news.setType_id(type_id);
                news.setUser_id(user_id);

                list.add(news);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public News queryNewsById(Long id) {
        // TODO
        return null;
    }

    @Override
    public void insert(News news) {

    }

    public List<NewsType> query() {
        String sql = "select * from t_newstype";
        List<NewsType> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");// 根据字段名（列名）获取数据
                String name = rs.getString("name");


                // 封装数据
                NewsType news = new NewsType();
                news.setId(id);
                news.setName(name);

                list.add(news);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return null;

    }

    public void delete(Long newsId){
        String sql = "delete from t_news where id = ?";

        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,newsId);
            int i = ps.executeUpdate();
            System.out.println("受影响的行："+i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
    }

    @Override
    public void update(News news) {
        //TODO
    }
}
