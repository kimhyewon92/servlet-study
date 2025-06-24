package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzaOrderEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		String sizeInt = request.getParameter("size");
		String[] topping = request.getParameterValues("topping");
		
		int priceSum = 0;
		
		for (int i = 0; i < topping.length; i++) {
			switch (topping[i]) {
			case "1" : 
				topping[i] = "새우";
				priceSum += 2000;
				break;
			case "2" : 
				topping[i] = "고구마";
				priceSum += 1000;
				break;
			case "3" : 
				topping[i] = "감자";
				priceSum += 1000;
				break;
			case "4" : 
				topping[i] = "파인애플";
				priceSum += 1000;
				break;
			}
		}
		
		String size = "";
		
		switch (sizeInt) {
		case "1" : 
			size = "Small";
			priceSum += 15900;
			break;
		case "2" : 
			size = "Medium";
			priceSum += 21000;
			break;
		case "3" : 
			size = "Large";
			priceSum += 27900;
			break;
		}
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/result.jsp");
		
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("size", size);
		request.setAttribute("priceSum", priceSum);
		request.setAttribute("topping", topping);
		
		view.forward(request, response);
	}

}
