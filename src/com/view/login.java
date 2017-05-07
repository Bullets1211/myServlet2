package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String time = "";
		String id = "";
		// String user = request.getParameter("id");
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if (name.equals("id")) {
					id = cookie.getValue();
				}
				if (name.equals("lastTime")) {
					// out.println("您上次登录时间是" + cookie.getValue());
					time = cookie.getValue();
					break;
				}
			}
			times(response);
		}
		out.println("<img src='Images/1.jpg' />你上次登录时间是" + time + "<hr>");
		out.println("<h1>用户登录</h1>");
		out.println("<form action='/myServlet2/loginclient' method='post'>");
		out.println("用名id:<input type='text' name='id' value='" + id
				+ "'/><br/>");
		out.println("密&nbsp码:<input type='password' name='password'/><br/>");
		out.println("<input type='checkbox' name='keepinfo' value='keep'/>在此电脑上保存用户信息<br/>");
		out.println("<input type='submit' value='提交'/>");
		out.println("</form>");
		out.println("<hr><img src='Images/3.GIF' />");
	}

	private void times(HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new java.util.Date());
		Cookie cookie = new Cookie("lastTime", time);
		cookie.setMaxAge(7 * 24 * 3600);
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
