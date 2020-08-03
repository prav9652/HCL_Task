package com.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;


@SuppressWarnings("serial")
@WebServlet("/fundTransfer")
public class TransactionController extends HttpServlet {
	@RequestMapping("/fundTransfer")
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html");
			TransactionDAO obj = new TransactionDAO();
			
			List<Transaction> res = null;
			try {
				res = obj.doTransaction();
				request.setAttribute("TransactionDAO", res);
				RequestDispatcher rd =  
			             request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			
			} catch (Exception e) {e.printStackTrace();}			

		}
	}