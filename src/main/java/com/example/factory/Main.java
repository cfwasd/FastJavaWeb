package com.example.factory;

import com.example.factory.bin.TomcatStartUp;
import org.apache.catalina.LifecycleException;

import javax.servlet.http.HttpServlet;



public class Main extends HttpServlet {

    public static void main(String[] args) throws LifecycleException {
        TomcatStartUp.start("http://127.0.0.1:8080/news?cmd=find",8080);
//        TomcatStartUp.start("http://127.0.0.1:8080/pro?cmd=find",8080);
    }

}


