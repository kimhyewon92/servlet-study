package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveNick")
public class MakeNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MakeNicknameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveNick = request.getParameter("saveNick");
		Cookie c = new Cookie("saveNick", saveNick);
		c.setMaxAge(60 * 60);
		response.addCookie(c);
		response.sendRedirect("/practiceCookie");
	}

}
