package com.learninglog.learninglogproject.topic.controller;

import com.learninglog.learninglogproject.topic.model.dao.TopicDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editTopic")
public class EditTopicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String updatedName = req.getParameter("name");
        try{
            boolean result = TopicDAO.updateTopic(id, updatedName);
            if(result){
                resp.sendRedirect("/topic?page=list");
                return;
            }else{
                req.setAttribute("error", "Unable to upadate the topic");
            }
        }catch(Exception e){
            req.setAttribute("error", "Something went wrong" + e.getMessage());
        }
        req.getRequestDispatcher("pages/editTopic.jsp").forward(req,resp);
    }
}
