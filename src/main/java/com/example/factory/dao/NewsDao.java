package com.example.factory.dao;


import com.example.factory.dao.entry.News;

import java.util.List;

public interface NewsDao {
    public List<News> queryNewsList();
    public News queryNewsById(Long id);

    public void insert(News news);

    public void delete(Long id);
    public void update(News news);
}
