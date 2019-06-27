package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Goods;
import entity.Message;
import entity.Order;
import entity.Page;
import entity.Users;
import service.GoodService;
import service.ProductService;
import service.UsersService;

@WebServlet("/ProductServlet")

/**
 * 调用ProductService的方法
 *
 * @author Administrator
 *
 */
public class ProductServlet extends HttpServlet {
	public ProductService ps = new ProductService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理中文乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取隐藏字段method的值，并把它转换为int型
		int method = Integer.parseInt(request.getParameter("method"));

		switch (method) {
		case 3:
			this.findById(request, response);
			break;
		case 5:
			this.queryComment(request, response);
			break;
		case 8:
			this.queryProduct(request, response);
			break;
		case 9:
			addMessage(request, response);
			break;
		case 10:
			queryMessage(request, response);
			break;
		}

	}

	public void queryComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageCode = 1;
		String s = request.getParameter("pageCode");
		int id = Integer.parseInt(request.getParameter("id"));
		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		}
		Page pb1 = ps.queryByPage1(pageCode, id);
		request.setAttribute("pb1", pb1);
		// response.setHeader("refresh", "1,URL=f/comment.jsp");
		request.getRequestDispatcher("f/comment.jsp").forward(request, response);
	}

	public void findById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("goodsId");
		List<Order> list4 = ps.findOrById(id);
		List<Goods> list3 = ps.findById(id);

		String pic = list3.get(0).pictureAddress;
		String[] strs = pic.split(",");
		for (int a = 0; a < strs.length; a++) {
			list3.get(0).pictureAddress = strs[a];
		}
		request.setAttribute("strs", strs);
		request.setAttribute("list4", list4);
		request.setAttribute("list3", list3);
		// response.setHeader("refresh", "0,URL=f/detail.jsp");
		request.getRequestDispatcher("f/detail.jsp").forward(request, response);
	}

	public void queryProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageCode = 1;
		String s = request.getParameter("pageCode");
		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		}
		Page pb4 = ps.queryProByPage(pageCode);
		request.setAttribute("pb4", pb4);
		// response.setHeader("refresh", "0,URL=admin/manage.jsp");
		request.getRequestDispatcher("admin/manage.jsp").forward(request, response);
	}

	public void addMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String initiatorName = request.getParameter("initiatorName");
		String recipientName = request.getParameter("recipientName");
		System.out.println(initiatorName + "xx");
		System.out.println(recipientName + "1xx");
		String content = request.getParameter("content");
		System.out.println(content);
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String newsdate = formatter.format(currentTime);
		try {
			date = formatter.parse(newsdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		UsersService a = new UsersService();
		Message m = new Message();
		m.setId(id);
		m.setInitiatorName(initiatorName);
		m.setRecipientName(recipientName);
		m.setContent(content);
		m.setDate(date);
		ps.addMessage(m);
		try {
			Users u = a.queryUsers(recipientName);
			if (u.getActive() == "1" || u.getActive().equals("1")) {
				String email = u.getMail();
				String subject1 = "校内闲鱼接收私信提醒~";
				String text1 = "来自校内闲鱼~有人给你发私信了，快登录网站去查询把~";
				GoodService g = new GoodService();
				try {
					g.semail(email, text1, subject1);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pageCode = 1;
		String s = request.getParameter("pageCode");
		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		}
		Page pb1 = ps.queryMessage(pageCode, initiatorName, recipientName, initiatorName, recipientName);
		request.setAttribute("pb1", pb1);
		request.getRequestDispatcher("ProductServlet?method=10&recipientName="+recipientName+"&initiatorName"+initiatorName).forward(request, response);

	}

	public void queryMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String initiatorName = request.getParameter("initiatorName");
		String recipientName = request.getParameter("recipientName");
//		System.out.println(initiatorName + "xxx");
//		System.out.println(recipientName + "1xxx");
		int pageCode = 1;
		String s = request.getParameter("pageCode");
		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		}
		Page pb = ps.queryMessage(pageCode, initiatorName, recipientName, initiatorName, recipientName);
		request.setAttribute("pb", pb);
		request.setAttribute("recipientName", recipientName);
		request.getRequestDispatcher("/f/message.jsp").forward(request, response);
	}

}
