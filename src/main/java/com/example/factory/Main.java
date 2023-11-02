package com.example.factory;

import com.example.factory.bin.TomcatStartUp;
import org.apache.catalina.LifecycleException;

import javax.servlet.http.HttpServlet;



public class Main extends HttpServlet {

    public static void main(String[] args) throws LifecycleException {
        TomcatStartUp.start("填入项目启动后希望打开的url地址，如果出现报错，请手动打开（地址从"/"开始）",8080);
    }

}


