package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Users;

public class selectUserView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Users users = (Users) request.getAttribute("users");
		out.println("<img src='Images/1.jpg' /><a href='/myServlet2/login'>��ȫ�˳�</a><hr>");
		out.println("<h3>�����û�</h3>");
		out.println("<form action='/myServlet2/UserServlet?type=select' method='post'>");
		out.println("�������û����� <input type='text' name='Username'> <input type='submit' value='����'>");
		out.println("</from>");
		out.println("<table border='1' style='border-collapse:collapse' width='250px'>");
		out.println("<tr><td>�û�id</td><td><input type='text' name='id' value='"
				+ users.getId() + "'/></td></tr>");
		out.println("<tr><td>�û���</td><td><input type='text' name='username' value='"
				+ users.getUsername() + "'/></td></tr>");
		out.println("<tr><td>Email</td><td><input type='text' name='email' value='"
				+ users.getEmail() + "'/></td></tr>");
		out.println("<tr><td>����</td><td><input type='text' name='grade' value='"
				+ users.getGrade() + "'/></td></tr>");
		out.println("<tr><td>password</td><td><input type='text' name='passwd' value='"
				+ users.getPassword() + "'/></td></tr>");
		out.println("</table>");
		out.println("<hr><img src='Images/3.GIF' />");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
