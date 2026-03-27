package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.user.model.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        req.getRequestDispatcher("pages/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try{
            UserDAO dao = new UserDAO();
            User userObj = dao.loginuser(email,password);
            if(userObj != null){
                HttpSession session = req.getSession();
                session.setAttribute("user",userObj);
                res.sendRedirect("/dashboard");
            }else{
                req.setAttribute("error","Invalid Username or Password");
                req.getRequestDispatcher("pages/login.jsp").forward(req,res);
            }

        }catch (Exception e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("pages/login.jsp").forward(req, res);
        }
    }
}
