package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.shoppingcart.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid=(String) request.getParameter("uid");
		String pwd=(String) request.getParameter("pwd");
		LoginDAO ud=new LoginDAO();
		if(ud.IsValidUser(uid,pwd)==true)
		{
			RequestDispatcher dispatcher= request.getRequestDispatcher("Home.html");
			dispatcher.forward(request, response);
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.print("Invalid Credentials");
			//request.setAttribute("message", "Invalid Credentials");
			//response.sendRedirect("Login.jsp");
			RequestDispatcher dispatcher= request.getRequestDispatcher("Login.html");
			dispatcher.include(request, response);
			
		}

	}

}
