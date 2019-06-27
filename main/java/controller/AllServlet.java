package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import entity.Goods;
import entity.Order;
import entity.Users;
import service.GoodService;
import service.UsersService;

/**
 * Servlet implementation class AllServlet
 */
@WebServlet("/AllServlet")
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String imageurl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		switch (flag) {
		case "upload":// 上传图片
			upload(request, response);
			// System.out.println(imageurl);
			break;
		case "addgood":// 发布商品
			addgood(request, response);
			break;
		case "addorder":// 生成订单
			addorder(request, response);
			break;
		case "comorder":// 完成订单
			comorder(request, response);
			break;
		case "delorder":// 取消订单
			delorder(request, response);
			break;
		case "myorder":// 我的订单列表
			myorder(request, response);
			break;
		case "mypeople":// 我的消息联系人查询
			mypeople(request, response);
			break;
		case "sendmail":// 发送邮件
			try {
				sendmail(request, response);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void upload(HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("收到图片!");
		String fileName = null;
		File tagetFile = null;
		// MultipartHttpServletRequest Murequest =
		// (MultipartHttpServletRequest)request;
		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest Murequest = resolver.resolveMultipart(request);
		Map<String, MultipartFile> files = Murequest.getFileMap();// 得到文件map对象
		String upaloadUrl = request.getSession().getServletContext().getRealPath("/") + "upload/";// 得到当前工程路径拼接上文件名
		File dir = new File(upaloadUrl);

		if (!dir.exists())// 目录不存在则创建
			dir.mkdirs();
		for (MultipartFile file : files.values()) {
			// counter++;
			fileName = file.getOriginalFilename();
			String url = upaloadUrl + fileName;
			String url1 = "upload/" + fileName;
			imageurl = imageurl + url1 + ",";
			tagetFile = new File(url);// 创建文件对象
			if (!tagetFile.exists()) {// 文件名不存在 则新建文件，并将文件复制到新建文件中
				try {
					tagetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					file.transferTo(tagetFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		// System.out.println("接收完毕");
	}

	public static void addgood(HttpServletRequest request, HttpServletResponse response) {
		Goods g = new Goods();
		g.setUserName(request.getSession().getAttribute("name").toString());

		if (request.getParameter("itemName") != null && !request.getParameter("itemName").equals("")) {
			g.setItemName(request.getParameter("itemName"));
		}
		if (request.getParameter("ifNew") != null && !request.getParameter("ifNew").equals("")) {
			g.setIfNew(Integer.parseInt(request.getParameter("ifNew")));
		}
		if (request.getParameter("barterType") != null && !request.getParameter("barterType").equals("")) {
			g.setBarterType(request.getParameter("barterType"));
		}
		if (request.getParameter("barter") != null && !request.getParameter("barter").equals("")) {
			g.setBarter(request.getParameter("barter"));
		}
		if (request.getParameter("ifBargain") != null && !request.getParameter("ifBargain").equals("")) {
			g.setIfBargain(Integer.parseInt(request.getParameter("ifBargain")));
		}
		if (request.getParameter("cateogory") != null && !request.getParameter("cateogory").equals("")) {
			g.setCateogory(request.getParameter("cateogory"));
		}
		if (request.getParameter("itemDescription") != null && !request.getParameter("itemDescription").equals("")) {
			g.setItemDescription(request.getParameter("itemDescription"));
		}
		g.setState(0);
		imageurl = imageurl.substring(4, imageurl.length() - 1);

		g.setPictureAddress(imageurl);
		imageurl = null;

		GoodService s = new GoodService();
		try {
			s.addgood(g);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			response.getWriter().print("<script language='javascript'>alert('添加成功');</script>");
			response.setHeader("refresh", "1,URL=BaseServlet?flag=findType");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void addorder(HttpServletRequest request, HttpServletResponse response) {
		Order o = new Order();
		if (request.getParameter("goodsId") != null && !request.getParameter("goodsId").equals("")) {
			o.setGoodId(request.getParameter("goodsId"));
		}
		if (request.getParameter("seller") != null && !request.getParameter("seller").equals("")) {
			o.setSeller(request.getParameter("seller"));
		}
		o.setPurchaser(request.getSession().getAttribute("name").toString());
		GoodService s = new GoodService();
		try {
			s.addorder(o);
			try {
				response.getWriter().print("<script language='javascript'>alert('预定成功');</script>");
			} catch (IOException e) {

				e.printStackTrace();
			}
			response.setHeader("refresh", "1,URL=BaseServlet?flag=findType");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void comorder(HttpServletRequest request, HttpServletResponse response) {// 完成订单操作
		Order o = new Order();
		int score = 5;
		String orderId = null;
		if (request.getParameter("orderId") != null && !request.getParameter("orderId").equals("")) {
			orderId = request.getParameter("orderId");
			o.setOrderId(orderId);
		}
		if (request.getParameter("score") != null && !request.getParameter("score").equals("")) {
			score = Integer.parseInt(request.getParameter("score"));
			o.setLevel(score);
		}
		if (request.getParameter("comment") != null && !request.getParameter("comment").equals("")) {
			o.setComment(request.getParameter("comment"));
		}

		GoodService s = new GoodService();
		try {
			s.compelet(o);
			try {
				response.getWriter().print("<script language='javascript'>alert('订单已完成');</script>");
			} catch (IOException e) {

				e.printStackTrace();
			}
			o = (Order) s.query1(orderId);
			String seller = o.getSeller();
			UsersService s1 = new UsersService();
			Users n1 = new Users();
			try {
				n1 = s1.queryUsers(seller);
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			int credit = n1.getCredit();
			int num = n1.getNum();
			credit = (credit * num + score) / (num + 1);
			num = num + 1;
			n1.setCredit(credit);
			n1.setNum(num);
			try {
				s1.updateCredit(n1);
				response.setHeader("refresh", "1,URL=AllServlet?flag=myorder");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void myorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 我的订单页面
		String userName = request.getSession().getAttribute("name").toString();
		GoodService s = new GoodService();
		List<Order> list1 = s.selectnow(userName);
		List<Order> list2 = s.selectcom(userName);
		List<Goods> list3 = new ArrayList<>();
		List<Goods> list4 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			try {
				list3.add(s.query(list1.get(i).getGoodId()));
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		for (int i = 0; i < list2.size(); i++) {
			try {
				list4.add(s.query(list2.get(i).getGoodId()));
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		request.setAttribute("listOrder1", list1);
		request.setAttribute("listOrder2", list2);
		request.setAttribute("listGoods3", list3);
		request.setAttribute("listGoods4", list4);
		// response.setHeader("refresh", "0,URL=f/myorder.jsp");
		request.getRequestDispatcher("f/myorder.jsp").forward(request, response);
		// response.setHeader("refresh", "1,URL=f/myorder.jsp");

	}

	public static void delorder(HttpServletRequest request, HttpServletResponse response) {// 取消订单
		Order o = new Order();
		if (request.getParameter("orderId") != null && !request.getParameter("orderId").equals("")) {
			o.setOrderId(request.getParameter("orderId"));
		}

		GoodService s = new GoodService();
		try {
			s.cancel(o);
			try {
				response.getWriter().print("<script language='javascript'>alert('订单已取消');</script>");
			} catch (IOException e) {

				e.printStackTrace();
			}
			response.setHeader("refresh", "1,URL=AllServlet?flag=myorder");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void sendmail(HttpServletRequest request, HttpServletResponse response) throws MessagingException {// 发送邮件
		String receiveMailAccount = "1191235915@qq.com";
		String subject = "JAVAmail测试";
		String text = "这是一封由JavaMail发送的邮件！lalaal好开心呀";

		receiveMailAccount = (String) request.getAttribute("receiveMailAccount");
		subject = (String) request.getAttribute("subject");
		text = (String) request.getAttribute("text");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mail.xml");

		JavaMailSender sender = (JavaMailSender) ctx.getBean("mailSender");// 获取JavaMailSender
		MimeMessage mm = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mm, true, "utf-8");
		try {
			helper.setTo(receiveMailAccount);// 接受者
			helper.setFrom("1191235915@qq.com");// 发送者
			helper.setSubject(subject);// 主题
			helper.setText(text, true);// 第二个参数代表发送的是正文是html
			sender.send(mm);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mypeople(HttpServletRequest request, HttpServletResponse response) {// 查询联系人
		GoodService s = new GoodService();
		String name = request.getSession().getAttribute("name").toString();
		List<String> peopleList = new ArrayList<String>();
		try {
			peopleList = s.querypeople(name);
			request.setAttribute("peopleList", peopleList);
			try {
				request.getRequestDispatcher("f/Mypeople.jsp?name=" + name).forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
