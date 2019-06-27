package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Administrator;
import entity.Goods;
import entity.Notification;
import entity.Page;
import entity.Users;
import service.NotificationService;
import service.ProductService;
import service.UsersService;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	static String name1 = null;
	static String password1 = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			String flag = request.getParameter("flag");
			// 登录
			// 管理员登录
			// 退出
			// 注册
			// 用户名是否存在
			if ("login".equals(flag)) {
				login(request, response);

			} else if ("loginAdministrator".equals(flag)) {
				loginAdministrator(request, response);

			} else if ("safeOut".equals(flag)) {
				safeOut(request, response);

			} else if ("register".equals(flag)) {
				register(request, response);

			} else if ("ifExit".equals(flag)) {
				ifExit(request, response);

			} else if ("findType".equals(flag)) {
				findType(request, response);

			} else if ("1".equals(flag)) {
				findAll(request, response);

			} else if ("2".equals(flag)) {
				this.queryBarterType(request, response);

			} else if ("6".equals(flag)) {
				this.queryType(request, response);

			} else if ("7".equals(flag)) {
				this.FuzzyQuery(request, response);

			}
		} catch (Exception e) {
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	public static void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		String nenuName = (String) session.getAttribute("nenuName");// 绑定学子号
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String telephone = request.getParameter("telephone");
		String active = UUID.randomUUID().toString().replaceAll("-", "");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = formatter.parse("2018-06-10 10:10:10");
		} catch (ParseException e) {

			e.printStackTrace();
		}
		UsersService n = new UsersService();
		Users u = new Users();
		u.setUserId(nenuName);
		u.setUserName(name);
		u.setPassword(password);
		u.setMail(mail);
		u.setLoginDate(date);// 默认第一次登录前的时间用于处理公告通知
		u.setTelephone(telephone);
		u.setActive(active);
		try {
			n.addUsers(u);
			try {
				response.getWriter().print("<script language='javascript'>alert('注册成功，请登录');</script>");
			} catch (IOException e) {

				e.printStackTrace();
			}
			response.setHeader("refresh", "1,URL=login.jsp");

			StringBuffer url = new StringBuffer();
			url.append("localhost:8080");
			url.append("/xianyu/upload?");
			url.append("flag=active");
			url.append("&" + "nenuName=");
			url.append(nenuName);
			url.append("&" + "active=");
			url.append(active);
			String text = "校内闲鱼激活邮箱提醒：如果点击显示找不到网址，可将下列网址复制粘贴。若“&”后带有“amp;”字样，请将该两处“amp;”删除。使用http协议，即http://。<p><a href=\"http://"
					+ url.toString() + "\">点击激活邮箱</a></p>" + url.toString();
			request.setAttribute("receiveMailAccount", mail);
			request.setAttribute("subject", "激活邮箱");
			request.setAttribute("text", text);
			request.getRequestDispatcher("AllServlet?flag=sendmail").forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UsersService n = new UsersService();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String newsdate = formatter.format(currentTime);
		try {
			date = formatter.parse(newsdate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		try {
			Users user = n.check2(name, password);
			if (user != null) {
				String logintime = user.getLoginDate().toString();
				request.setAttribute("date", logintime);// 获取上次登录时间用于判断公告通知
				name1 = name;
				password1 = password;
				request.getSession().setAttribute("name", user.getUserName());
				request.getSession().setAttribute("password", user.getPassword());
				user = n.login(name, date);// 修改登录时间
				request.getRequestDispatcher("BaseServlet?flag=findType").forward(request, response);
				// response.setHeader("refresh",
				// "1,URL=ProductServlet?method=4");
			} else {
				try {
					response.getWriter().print("<script language='javascript'>alert('用户名或密码错误，请重新登陆');</script>");
					response.setHeader("refresh", "1,URL=login.jsp");
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void loginAdministrator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (name == null || name.equals("")) {
			name = name1;
		}
		if (password == null || password.equals("")) {
			password = password1;
		}
		UsersService n = new UsersService();
		try {
			Administrator administrator = n.loginAdministrator(name, password);
			if (administrator != null) {
				name1 = name;
				password1 = password;
				request.getSession().setAttribute("name", administrator.getName());
				request.getSession().setAttribute("password", administrator.getPassword());
				response.setHeader("refresh", "0,URL=UserServlet?flag=manage");
			} else {
				try {
					response.getWriter().print("<script language='javascript'>alert('用户名或密码错误，请重新登陆');</script>");
					response.setHeader("refresh", "0,URL=admin/login.jsp");
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void safeOut(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		response.setHeader("refresh", "0,URL=login.jsp");
	}

	public static void ifExit(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String name = null;
		if (request.getParameter("name") != null && !request.getParameter("name").equals("")) {
			name = request.getParameter("name");
			// System.out.println(name);
		}
		UsersService s = new UsersService();
		try {
			PrintWriter result = response.getWriter();
			boolean temp = s.ifExits(name);
			// System.out.println(temp);
			result.print(temp);// 将结果输送给ajax
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void findType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String date = (String) request.getAttribute("date");
		NotificationService s = new NotificationService();
		String ifNotification = s.unRead(date);
		request.setAttribute("ifNotification", ifNotification);
		// System.out.println(ifNotification);
		s = new NotificationService();
		String p2 = request.getParameter("p1");
		int p = 1;
		int r = 3;
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
		List<Notification> listNotificatios = s.select(p, r);
		request.getSession().setAttribute("p1", p);
		request.getSession().setAttribute("count1", count);
		request.getSession().setAttribute("listNotificatios", listNotificatios);
		ProductService ps = new ProductService();
		List<Goods> list1 = ps.findType();
		List<Goods> list2 = ps.findGoods();
		for (int a = 0; a < list2.size(); a++) {
			String pic = list2.get(a).pictureAddress;
			String[] strs = pic.split(",");
			list2.get(a).pictureAddress = strs[0];
		}
		request.getSession().setAttribute("list2", list2);
		request.getSession().setAttribute("list1", list1);
		response.setHeader("refresh", "0,URL=index.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	// 处理查询所有商品的请求
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ps = new ProductService();
		List<Goods> list = ps.findAll();
		for (int a = 0; a < list.size(); a++) {
			String pic = list.get(a).pictureAddress;
			String[] strs = pic.split(",");
			list.get(a).pictureAddress = strs[0];
		}
		request.setAttribute("listProduct", list);
		// 通过请求转发将商品信息显示在product.jsp页面上
		// response.setHeader("refresh", "1,URL=product.jsp");
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	public void queryType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageCode = 1;
		String s = request.getParameter("pageCode");
		String type = request.getParameter("type");
		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		}
		ProductService ps = new ProductService();
		Page pb2 = ps.queryByPage2(pageCode, type);
		for (int a = 0; a < pb2.getDatas().size(); a++) {
			String pic = pb2.getDatas().get(a).pictureAddress;
			String[] strs = pic.split(",");
			pb2.getDatas().get(a).pictureAddress = strs[0];
		}
		request.setAttribute("pb2", pb2);
		// response.setHeader("refresh", "0,URL=product.jsp");
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	public void queryBarterType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageCode = 1;
		String s = request.getParameter("pageCode");
		String barterType = request.getParameter("barterType");
		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		}
		ProductService ps = new ProductService();
		Page pb3 = ps.queryByPage3(pageCode, barterType);
		for (int a = 0; a < pb3.getDatas().size(); a++) {
			String pic = pb3.getDatas().get(a).pictureAddress;
			String[] strs = pic.split(",");
			pb3.getDatas().get(a).pictureAddress = strs[0];
		}
		request.setAttribute("pb3", pb3);
		// response.setHeader("refresh", "0,URL=product.jsp");
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	public void FuzzyQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String conf = request.getParameter("search");
		ProductService ps = new ProductService();
		List<Goods> list5 = ps.Fuzzyquery(conf);
		for (int a = 0; a < list5.size(); a++) {
			String pic = list5.get(a).pictureAddress;
			String[] strs = pic.split(",");
			list5.get(a).pictureAddress = strs[0];
		}
		request.setAttribute("list5", list5);
		// response.setHeader("refresh", "0,URL=product.jsp");
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

}