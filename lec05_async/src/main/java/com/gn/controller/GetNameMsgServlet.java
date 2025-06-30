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
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.println(visitorName);
		System.out.println(visitorMsg);
		System.out.println(dateTime);
		
		list.add(new Visitor(visitorName, visitorName, dateTime));
		
		JSONArray arr = new JSONArray();
		
		for (Visitor v : list) {
			JSONObject obj = new JSONObject();
			obj.put(arr, v);
			obj.put(arr, v);
			obj.put(arr, v);
			arr.add(obj);
		}
	}

	JSONObject result = new JSONObject();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
