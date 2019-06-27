package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Notification;
import service.NotificationService;

/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/NotificationServlet")
public class NotificationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NotificationServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		switch (flag) {
		case "addNotification":// 发布公告
			addNotification(request, response);
			break;
		case "delNotification":// 删除公共
			delNotification(request, response);
			break;
		case "readNotification":// 阅读公共
			readNotification(request, response);
			break;
		case "updateNotification":// 更新公告
			updateNotification(request, response);
			break;
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */

	public static void addNotification(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		String notification = request.getParameter("notification");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String newsdate = formatter.format(currentTime);
		try {
			date = formatter.parse(newsdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notification n1 = new Notification();
		n1.setId(id);
		n1.setNotification(notification);// 公告内容
		n1.setDate(date);// 公告发布时间
		NotificationService s = new NotificationService();
		try {
			s.addNotification(n1);
			response.setHeader("refresh", "1,URL=NotificationServlet?flag=readNotification&id=" + id + "&m=1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delNotification(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String id = null;
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			id = request.getParameter("id");
		}
		NotificationService s = new NotificationService();
		try {
			s.deleteNotification(id);
			response.setHeader("refresh", "1,URL=");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readNotification(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = null;
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			id = request.getParameter("id");
		}
		NotificationService s = new NotificationService();
		Notification n = new Notification();
		// try {
		try {
			n = s.queryNotification(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("oneNotification", n);
		if (request.getParameter("m").equals("0")) {
			response.setHeader("refresh", "1,URL=");
			// request.getRequestDispatcher("a/update.jsp").forward(request,
			// response);
		} else {
			request.getRequestDispatcher("f/readN.jsp").forward(request, response);
		}

	}

	public static void updateNotification(HttpServletRequest request, HttpServletResponse response) {
		String id = null;
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			id = request.getParameter("id");
		}
		String notification = request.getParameter("notification");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String newsdate = formatter.format(currentTime);
		try {
			date = formatter.parse(newsdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notification n1 = new Notification();
		n1.setId(id);
		n1.setDate(date);
		n1.setNotification(notification);
		NotificationService s = new NotificationService();
		try {
			s.updateNotification(n1);
			response.sendRedirect("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
