package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mainframe extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		// String passwd = request.getParameter("password");
		// System.out.println("id=" + id + "mima=" + passwd);
		out.println("<img src='Images/1.jpg' /><a href='/myServlet2/login'><h4>��ȫ�˳�</h4></a></br>");
		out.println("<h1>��ӭ" + id + "�����û�����ϵͳ��</h1>");
		out.println("<h2>��ѡ����еĲ���</h3>");
		out.println("<a href='/myServlet2/ManageUsers'>�����û�</a><br/>");
		out.println("<a href='/myServlet2/AddUserView?type=gotoAdd'>����û�</a><br/>");
		out.println("<a href='/myServlet2/selectUserView?type=selectUser'>�����û�</a><br/>");
		out.println("<a>�˳�ϵͳ</a><br/>");
		out.println("<hr><img src='Images/3.GIF' />");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
