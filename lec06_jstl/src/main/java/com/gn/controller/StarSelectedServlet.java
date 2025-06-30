package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/starSelected")
public class StarSelectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StarSelectedServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String starQty = request.getParameter("starQty");
		request.setAttribute("starQty", starQty);
		
		RequestDispatcher view = request.getRequestDispatcher("views/star.jsp");
		view.forward(request, response);
	}

}
