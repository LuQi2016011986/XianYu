package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UsersService;

/**
 * 东师身份验证 Servlet implementation class VerifyServlet
 */
@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyServlet() {
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
		doPost(request, response);
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
		String flag = request.getParameter("flag");
		switch (flag) {
		case "verify":// 验证
			verify(request, response);
			break;
		case "ifBlack":// 是否位于黑名单
			ifBlack(request, response);
			break;
		}

	}

	public static void verify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nenuName = request.getParameter("nenuName");
		String nenuPwd = request.getParameter("nenuPwd");
		String surl = "https://ids.nenu.edu.cn/amserver/UI/Login?goto=http://urp.nenu.edu.cn";
		URL url = new URL(surl);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter output = new OutputStreamWriter(conn.getOutputStream());
		String str = "IDToken1=" + nenuName + "&IDToken2=" + nenuPwd;
		output.write(str);
		output.flush();
		output.close();
		String scontent = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		while (in.readLine() != null)
			scontent += in + "\r\n";
		if (scontent == null || scontent.equals("")) {
			request.getSession().setAttribute("nenuName", nenuName);// 存入东师号作为用户id
			try {
				response.getWriter().print("<script language='javascript'>alert('验证成功！');</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setHeader("refresh", "0,URL=register.jsp");
		} else {
			try {
				response.getWriter().print("<script language='javascript'>alert('验证失败！');</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setHeader("refresh", "0,URL=verify.jsp");
		}
	}

	@SuppressWarnings("null")
	public static void ifBlack(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String nenuName = null;
		if (request.getParameter("nenuName") != null && !request.getParameter("nenuName").equals("")) {
			nenuName = request.getParameter("nenuName");
			// System.out.println(nenuName);
		}
		UsersService s = new UsersService();
		try {
			PrintWriter result = response.getWriter();
			String temp = s.queryBlack(nenuName);
			// System.out.println(temp);
			result.print(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
