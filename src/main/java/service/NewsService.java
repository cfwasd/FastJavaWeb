package service;

import com.example.factory.dao.NewsDaoImpl;

import java.util.List;


public class NewsService {

    public List query(){

        NewsDaoImpl newsDao = new NewsDaoImpl();
        return newsDao.queryNewsList();


    }
    public void  delete(Long newsId){

        NewsDaoImpl newsDao = new NewsDaoImpl();
        newsDao.delete(newsId);


    }
}
