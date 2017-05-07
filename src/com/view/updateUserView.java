package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Users;

public class updateUserView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<img src='Images/1.jpg' /><hr>");
		out.println("<h3>修改用户</h3>");
		Users users = (Users) request.getAttribute("users");
		// users.g
		out.println("<form action='/myServlet2/UserServlet?type=update' method='post'>");
		out.println("<table border='1' style='border-collapse:collapse' width='250px'>");
		out.println("<tr><td>用户id</td><td><input type='text' name='id' readonly value='"
				+ users.getId() + "'/></td></tr>");
		out.println("<tr><td>用户名</td><td><input type='text' name='username' value='"
				+ users.getUsername() + "'/></td></tr>");
		out.println("<tr><td>Email</td><td><input type='text' name='email' value='"
				+ users.getEmail() + "'/></td></tr>");
		out.println("<tr><td>级别</td><td><input type='text' name='grade' value='"
				+ users.getGrade() + "'/></td></tr>");
		out.println("<tr><td><input type='submit'value='确认修改'/></td><td><input type='reset' value='重新填写'/></td></tr>");
		out.println("</table>");
		out.println("</from>");
		out.println("<hr><img src='Images/3.GIF' />");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
