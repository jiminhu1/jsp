package com.sds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Start ...");
		PrintWriter out = response.getWriter(); 
		out.println("<h1>LOGIN</h1>"); 
		out.println("<form action='login' method='post'>");
		out.println("ID<input type='text' name='id'><br>");
		out.println("PWD<input type='password' name='pwd'><br>");
		out.println("<input type='submit' value='LOGIN'>");
		out.println("</form>");
		out.close();
		System.out.println("End ...");
	}

}




