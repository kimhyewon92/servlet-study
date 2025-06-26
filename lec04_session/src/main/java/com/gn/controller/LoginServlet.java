package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Account;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals(correctId) && pw.equals(correctPw)) {
			HttpSession session = request.getSession(true);
			Account account = new Account(id, name);
			session.setAttribute("account", account);
			session.setMaxInactiveInterval(60 * 30);
		}
		response.sendRedirect("/");
		
			
	}

}
