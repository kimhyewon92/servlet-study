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
		// 1. 요청 데이터 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 파라미터 수집
		int kor = Integer.parseInt(request.getParameter("kor")); //data 왼쪽에 적어준 값
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		// 3. 연산 처리 : 총점, 평균, 합격여부
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		String avgStr = String.format("%.2f", avg);
		
		String result = (kor>=40 && eng>=40 && math>=40 && avg>=60)? "합격" : "불합격";
		
		// 4. 응답 설정
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// response.getWriter(),write("총점: " + sum + " 평균: " + avgStr + " 합격여부: " + result);
		
		out.println("총점: " + sum + " 평균: " + avg + " 합격여부: " + result);
	}

}
