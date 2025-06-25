package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/write")
public class TitlePrefixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TitlePrefixServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== 요청 확인 ====");
		String title = request.getParameter("title"); // 지역변수 / name
		System.out.println(title);
		
		RequestDispatcher view 
//		= request.getRequestDispatcher("/views/msgShow.jsp");
		= getServletContext().getRequestDispatcher("/views/titleShow.jsp");
		request.setAttribute("title", title); // 이름, value 값
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
