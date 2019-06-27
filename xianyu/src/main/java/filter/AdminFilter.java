package filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Administrator;
import service.UsersService;

/**
 * 管理员管理页面过滤器 Servlet Filter implementation class AdminFilter
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = { "/admin/addN.jsp", "/admin/manage_user.jsp", "/admin/black_user.jsp",
		"/admin/manage.jsp" })
public class AdminFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AdminFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;

		HttpSession session = req.getSession(true);

		// 从session里取的用户名信息
		String name = (String) session.getAttribute("name");
		String password = (String) session.getAttribute("password");
		// 判断如果没有取到用户信息,就跳转到登陆页面
		if (name == null || "".equals(name)) {
			// 跳转到登陆页面
			try {
				response.getWriter().print("<script language='javascript'>alert('请先登录');</script>");
			} catch (IOException e) {

				e.printStackTrace();
			}
			((HttpServletResponse) response).setHeader("refresh", "1,URL=login.jsp");
		} else {
			UsersService n = new UsersService();
			try {
				Administrator administrator = n.loginAdministrator(name, password);
				if (administrator == null) {
					try {
						response.getWriter().print("<script language='javascript'>alert('您非管理员，请重新登陆');</script>");
						((HttpServletResponse) response).setHeader("refresh", "1,URL=login.jsp");
					} catch (IOException e) {

						e.printStackTrace();
					}
				} else {
					chain.doFilter(request, response);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
