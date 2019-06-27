package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import entity.Users;
import service.UsersService;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
public class upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public upload() {
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
		case "updateUser"://修改用户信息
			updateUser(request, response);
			break;
		case "active"://激活邮箱
			active(request, response);
			break;
		}
	}

	public static void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String oldpassword = null, password = null, telephone = null, userIntroduction = null;
		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
		MultipartFile file = multipartRequest.getFile("file");
		oldpassword = multipartRequest.getParameter("oldpassword");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		// 从session里取的用户名信息
		String name = (String) session.getAttribute("name");
		UsersService s = new UsersService();
		Users n1 = new Users();
		try {
			n1 = s.check2(name, oldpassword);// 确认用户信息
			if (n1 != null) {// 用户信息正确
				password = multipartRequest.getParameter("password");
				telephone = multipartRequest.getParameter("telephone");
				userIntroduction = multipartRequest.getParameter("userIntroduction");
				if (password == null || password.equals("")) {
					password = oldpassword;
				}
				String sqlPath = null;// 图片上传
				if (file != null) {
					String filename = file.getOriginalFilename();
					String trueFileName = String.valueOf(System.currentTimeMillis()) + filename;
					String path = request.getSession().getServletContext().getRealPath("/") + "upload\\";
					File truepath = new File(path);
					File truefile = new File(path, trueFileName);
					sqlPath = "upload\\" + trueFileName;
					// System.out.println(path);
					// System.out.println(sqlPath);
					if (!truepath.exists()) {
						truepath.mkdirs();
					}
					try {
						file.transferTo(truefile);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				n1.setUserName(name);
				n1.setPassword(password);
				n1.setPhotoAddress(sqlPath);
				n1.setTelephone(telephone);
				n1.setUserIntroduction(userIntroduction);
				try {
					s.updateUsers(n1);
					try {
						response.getWriter().print("<script language='javascript'>alert('修改成功');</script>");
						response.setHeader("refresh", "1,URL=UserServlet?flag=readUser&m=1");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {// 用户信息错误，不允许修改
				try {
					response.getWriter().print("<script language='javascript'>alert('密码错误，修改失败');</script>");
					response.setHeader("refresh", "1,URL=f/person_change_information.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void active(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String nenuName = request.getParameter("nenuName");
		String active = request.getParameter("active");
		UsersService s = new UsersService();
		try {
			Users n1 = new Users();
			n1 = (Users) s.active(nenuName, active);
			if (n1 != null) {
				try {
					response.getWriter().print("<script language='javascript'>alert('激活成功！');</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					response.getWriter().print("<script language='javascript'>alert('激活失败，请联系客服更改邮箱！');</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
