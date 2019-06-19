package com.example.demo.ueditor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.ueditor.ActionEnter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * UEditor读取配置文件
 */
@Controller
public class UEditorController {

    @Value(value="classpath:config.json")
    private Resource resource;
    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        char[] a={'\u914d','\u7f6e','\u6587','\u4ef6','\u521d','\u59cb','\u5316','\u5931','\u8d25'};
        String msg=new String(a);
        System.out.println(msg);
    }
}
