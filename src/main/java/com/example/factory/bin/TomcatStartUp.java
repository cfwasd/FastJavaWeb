package com.example.factory.bin;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.awt.*;
import java.io.File;
import java.net.URI;

/**
  *@ClassName TomcatStartUp
  *@Author wzh
  *@Version 1.0
  *@DATE 2023/10/25

  *@Description  Tomcat启动配置
  *@param
  *@return
*/
public class TomcatStartUp {
    public static void start(String url,int port) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", port)); //端口
        tomcat.getConnector();
        // 创建 WebApp
        Context context = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(
                new DirResourceSet(resources, "/WEB-INF/classes",
                        new File("target/classes").getAbsolutePath(), "/"));
        context.setResources(resources);

        tomcat.start();
        System.out.println("====================项目启动成功====================");
        startBrowse(url);
        tomcat.getServer().await();
    }
    public static void startBrowse(String url){
        try {
            // 创建一个URI对象，指定要打开的网页地址
            URI uri = new URI(url);

            // 获取系统默认的浏览器
            Desktop desktop = Desktop.getDesktop();

            // 判断桌面是否支持浏览器调用
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                // 调用默认浏览器打开网页
                desktop.browse(uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
