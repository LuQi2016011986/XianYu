package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Goods;
import entity.Users;
import service.GoodService;
import service.UsersService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		case "manage":// 管理用户
			manage(request, response);
			break;
		case "delUser":// 封号
			delUser(request, response);
			break;
		case "readUser":// 读取用户信息
			readUser(request, response);
			break;
		case "queryUser":// 查询用户
			queryUser(request, response);
			break;
		// case "updatePassword":
		// updatePassword(request, response);
		// break;
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	/** 
     * 管理用户
     */ 
	public static void manage(HttpServletRequest request, HttpServletResponse response) {
		UsersService s = new UsersService();
		String p2 = request.getParameter("p1");
		int p = 1;
		int r = 10;
		int count = s.getCount(r);
		if (p2 != null && !p2.equals("")) {
			p = Integer.parseInt(p2);
		}
		if (p <= 0) {
			p = 1;
		}
		if (p >= count) {
			p = count;
		}
		List<Users> listusers = s.select(p, r);
		request.getSession().setAttribute("p", p);
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("list", listusers);
		response.setHeader("refresh", "1,URL=admin/manage_user.jsp");
	}

	/** 
     * 封号
     */ 
	public static void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String name = null;
		if (request.getParameter("name") != null && !request.getParameter("name").equals("")) {
			name = request.getParameter("name");
		}
		// System.out.println(name);
		UsersService s = new UsersService();
		try {
			Users n = s.queryUsers(name);
			String userId = n.getUserId();// 查询东师邮箱号
			s.deleteUsers(userId);
			response.setHeader("refresh", "1,URL=UserServlet?flag=manage");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** 
     * 读取用户信息
     */ 
	public static void readUser(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String name = (String) request.getParameter("userName");
		UsersService s = new UsersService();
		Users n = new Users();
		// try {
		try {
			n = s.queryUsers(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// request.getSession().setAttribute("credit", n.getCredit());
		request.getSession().setAttribute("oneUser", n);
		if (request.getParameter("m").equals("0")) {
			response.setHeader("refresh", "1,URL=f/person_change_information.jsp");// 修改用户信息页面
		} else {
			GoodService s1 = new GoodService();
			List<Goods> list1 = s1.selectf(name);
			request.getSession().setAttribute("listm", list1);
			response.setHeader("refresh", "1,URL=f/personal_information.jsp");// 用户信息页面
		}

	}

	/** 
     * 查询用户信息
     */ 
	public static void queryUser(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String name = null;
		if (request.getParameter("name") != null && !request.getParameter("name").equals("")) {
			name = request.getParameter("name");
		}
		// System.out.println(name);
		UsersService s = new UsersService();
		try {
			Users n = s.queryUsers(name);
			request.getSession().setAttribute("blackuser", n);
			response.setHeader("refresh", "1,URL=admin/black_user.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public static void updatePassword(HttpServletRequest request,
	// HttpServletResponse response) {
	// String password = request.getParameter("password");
	// String QQ = request.getParameter("mail");
	// String telephone = request.getParameter("telephone");
	// UsersService s = new UsersService();
	// Users n1 = new Users();
	// try {
	// n1 = s.check(QQ, telephone);
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// n1.setPassword(password);
	// try {
	// s.updatePassword(n1);
	// response.sendRedirect("register.jsp");
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
