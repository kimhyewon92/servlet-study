package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchAccount")
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchAccountServlet() {
        super();
    }

    // 자바 메소드아니어서 노란줄 뜰때
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. Servlet에 Account List 목록에서
		// 해당 이름 존재하는지 확인
		// 이름이 포함된 사람 목록 응답
		List<Account> list = new ArrayList<Account>();
		list.add(new Account(1, "김철수"));
		list.add(new Account(2, "이영희"));
		list.add(new Account(3, "홍길동"));
		list.add(new Account(4, "김가남"));
		
		String name = request.getParameter("name");
		
//		JSONObject obj = new JSONObject(); // 배열아닐때 사용했던..
		
		JSONArray arr = new JSONArray();
		
		for(Account a : list) {
			if(a.getName().contains(name)) {
				JSONObject obj = new JSONObject(); //배열로 보낼때..
				obj.put("no", a.getNo());
				obj.put("name", a.getName());
				arr.add(obj);
			}
//			if(a.getName().equals(name)) {
//				obj.put("no", a.getNo());
//				obj.put("name", a.getName());
//			}
		}
		
		JSONObject result = new JSONObject();
		result.put("arr", arr);
		
		response.setContentType("application/json; charset=utf-8");
//		response.getWriter().print(obj);
		response.getWriter().print(result); // array를 바로 넘기면 출력이 안된다..
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
