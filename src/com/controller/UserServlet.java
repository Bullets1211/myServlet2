package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Users;
import com.service.UserService;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserService userService = new UserService();
		String type = request.getParameter("type");
		if ("del".equals(type)) {
			String id = request.getParameter("id");
			if (userService.delUser(id)) {
				request.getRequestDispatcher("/Ok").forward(request, response);
			} else {
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		} else if ("gotoupdview".equals(type)) {
			String id = request.getParameter("id");
			Users users = userService.getUserById(id);
			request.setAttribute("users", users);
			request.getRequestDispatcher("/updateUserView").forward(request,
					response);
		} else if ("update".equals(type)) {
			updateUser(request, response, userService);
		} else if ("gotoAdd".equals(type)) {
			request.getRequestDispatcher("/AddUserView").forward(request,
					response);
		} else if ("add".equals(type)) {
			addUser(request, response, userService);
		} else if ("selectUser".equals(type)) {
			request.getRequestDispatcher("/selectUserView").forward(request,
					response);
		} else if ("select".equals(type)) {
			String username = request.getParameter("Username");
			Users users = userService.getUserByName(username);
			request.setAttribute("users", users);
			// request.getRequestDispatcher("/selectUserView").forward(request,
			// response);
		}

	}

	// 更新用户
	private void updateUser(HttpServletRequest request,
			HttpServletResponse response, UserService userService)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		Users users = new Users(Integer.parseInt(id), username, email,
				Integer.parseInt(grade));
		if (userService.UpdateUser(users)) {
			request.getRequestDispatcher("/Ok").forward(request, response);
		} else {
			request.getRequestDispatcher("/Err").forward(request, response);
		}
	}

	// 添加用户(用refactor里的extract method方法)
	private void addUser(HttpServletRequest request,
			HttpServletResponse response, UserService userService)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		String passwd = request.getParameter("passwd");
		Users users = new Users();
		users.setId(Integer.parseInt(id));
		users.setUsername(username);
		users.setEmail(email);
		users.setGrade(Integer.parseInt(grade));
		users.setPassword(passwd);
		if (userService.addUser(users)) {
			request.getRequestDispatcher("/Ok").forward(request, response);
		} else {
			request.getRequestDispatcher("/Err").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
