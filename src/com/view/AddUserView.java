package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Users;

public class AddUserView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<img src='Images/1.jpg' /><a href='/myServlet2/login'>��ȫ�˳�</a><hr>");
		out.println("<h3>�����û�</h3>");
		Users users = new Users();
		out.println("<form action='/myServlet2/UserServlet?type=add' method='post'>");
		out.println("<table border='1' style='border-collapse:collapse' width='250px'>");
		out.println("<tr><td>�û�id</td><td><input type='text' name='id' value=''/></td></tr>");
		out.println("<tr><td>�û���</td><td><input type='text' name='username' value=''/></td></tr>");
		out.println("<tr><td>Email</td><td><input type='text' name='email' value=''/></td></tr>");
		out.println("<tr><td>����</td><td><input type='text' name='grade' value=''/></td></tr>");
		out.println("<tr><td>password</td><td><input type='password' name='passwd' value=''/></td></tr>");
		out.println("<tr><td><input type='submit'value='����û�'/></td><td><input type='reset' value='������д'/></td></tr>");
		out.println("</table>");
		out.println("</from>");
		out.println("<hr><img src='Images/3.GIF' />");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
