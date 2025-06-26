package com.gn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/scorePostTextAjax")
public class ScorePostTextAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScorePostTextAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int sum = kor + eng + math;
		double avg = sum/3;
		String result = (kor>=40 && eng>=40 && math>=40 && avg>=60)? "합격" : "불합격";
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("총점: " + sum + " 평균: " + avg + " 합격여부: " + result);
	}

}
