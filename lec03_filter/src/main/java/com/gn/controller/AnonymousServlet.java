package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/comment/write")
public class AnonymousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnonymousServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("writer");
		System.out.println(msg);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/views/msgShow.jsp");
		request.setAttribute("msg", msg);
		view.forward(request, response);
	}

}
