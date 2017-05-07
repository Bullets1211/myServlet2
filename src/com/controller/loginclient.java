package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Users;
import com.service.UserService;

public class loginclient extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String passwd = request.getParameter("password");
		String val = request.getParameter("keepinfo");
		Users user = new Users();
		UserService userService = new UserService();
		user.setId(Integer.parseInt(id));
		user.setPassword(passwd);
		if (val != null && val.equals("keep")) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(7 * 24 * 3600);
			response.addCookie(cookie);
			// request.getRequestDispatcher("/OK").forward(request, response);
		}
		if (userService.checkUser(user)) {
			response.sendRedirect("/myServlet2/Mainframe?id=" + id + "");
		} else {
			out.println("��¼ʧ�ܣ�");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
