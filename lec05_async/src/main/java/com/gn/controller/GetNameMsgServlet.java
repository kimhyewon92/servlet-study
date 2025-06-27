package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		List<Visitor> list = new ArrayList<Visitor>();
		String name = request.getParameter("");
		list.add(new Visitor())
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
