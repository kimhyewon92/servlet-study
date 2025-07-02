package com.gn.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Visitor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getNameMsg")
public class GetNameMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetNameMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<Visitor> list = new ArrayList<Visitor>();
		
		String visitorName = request.getParameter("visitorName");
		String visitorMsg = request.getParameter("visitorMsg");
		LocalDateTime visitDatetime = LocalDateTime.now();
		
		list.add(new Visitor(visitorName, visitorMsg, visitDatetime));
		
		JSONArray arr = new JSONArray();
		
		for (Visitor v : list) {
			JSONObject obj = new JSONObject();
			obj.put(arr, v.getName());
			obj.put(arr, v.getMessage());
			obj.put(arr, v.getDatetime());
			arr.add(obj);
		}
		JSONObject result = new JSONObject();
		result.put("arr", arr);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(result);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
