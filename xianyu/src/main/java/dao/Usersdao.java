package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Administrator;
import entity.Black;
import entity.Users;

public class Usersdao {
	public void addUsers(Users g) throws SQLException {// 增加一条用户信息
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "insert into user (userId,userName,password,mail,telephone,credit,num,loginDate,active) values(?,?,?,?,?,?,?,?,?)";
		try {
			Object[] params = { g.getUserId(), g.getUserName(), g.getPassword(), g.getMail(), g.getTelephone(), 5, 0,
					g.getLoginDate(), g.getActive() };
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
	}

	public void updateUsers(Users g) throws SQLException {// 更改一条用户信息
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE user SET password=?,photoAddress=?,telephone=?,userIntroduction=? WHERE userName=?";
		try {
			Object[] params = { g.getPassword(), g.getPhotoAddress(), g.getTelephone(), g.getUserIntroduction(),
					g.getUserName() };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public Users active(String userId, String active) throws SQLException {// 激活邮箱
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		Users user = null;
		String sql = "SELECT * FROM  user where userId= ? and active=?";
		try {
			Object[] params = { userId, active };
			user = (Users) qr.query(conn, sql, new BeanHandler<Users>(Users.class), params);
			if (user != null) {
				sql = "UPDATE user SET active=? WHERE userId=?";
				try {
					Object[] param = { 1, userId };
					qr.update(conn, sql, param);
				} catch (SQLException e) {
					e.printStackTrace();// TODO: handle exception
				}
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
		return user;
	}

	public void updateCredit(Users g) throws SQLException {// 更改用户信用度
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE user SET credit=?,num=? WHERE userId=?";
		try {
			Object[] params = { g.getCredit(), g.getNum(), g.getUserId() };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public Users queryUsers(String userName) throws SQLException {// 查询个人信息
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM  user where userName= '" + userName + " '";
		try {
			Users user = (Users) qr.query(conn, sql, new BeanHandler<Users>(Users.class));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
		return null;
	}

	public boolean ifExits(String userName) throws SQLException {// 用户名是否存在
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM  user where userName= '" + userName + " '";
		try {
			Users user = (Users) qr.query(conn, sql, new BeanHandler<Users>(Users.class));
			if (user != null) {
				return false;// 存在返回false
			} else {
				return true;// 不存在返回true
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
	}

	public String queryBlack(String userId) throws SQLException {// 查询黑名单
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT userId FROM  black where userId= '" + userId + " '";
		try {
			Black user = (Black) qr.query(conn, sql, new BeanHandler<Black>(Black.class));
			if (user != null) {
				return "0";// 位于黑名单返回0
			} else {
				return "1";// 不在黑名单返回1
			}
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
		return null;
	}

	public void deleteUsers(String userId) throws SQLException {// 封号
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "insert into black (userId) values(?)";
		try {
			Object params = userId;
			qr.update(conn, sql, params);// 加入黑名单
			sql = "DELETE FROM user WHERE userId=?";
			qr.update(conn, sql, params);// 删除用户信息阻止登录
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
	}

	public Users login(String userName, Date date) throws SQLException {
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		Users user = null;
		String sql = "UPDATE user SET loginDate=? WHERE userName=?";
		try {
			Timestamp date0 = new Timestamp(date.getTime());
			Object[] param = { date0, userName };
			qr.update(conn, sql, param);// 登录修改登录时间
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return user;

	}

	// public Users check(String mail, String telephone) throws SQLException {
	// Connection conn = JDBCUtil.getDataSource().getConnection();
	// QueryRunner qr = new QueryRunner();
	// Users user = null;
	// String sql = "SELECT * FROM user WHERE mail=? and telephone=?";
	// try {
	// Object[] params = { mail, telephone };
	// user = (Users) qr.query(conn, sql, new BeanHandler<Users>(Users.class),
	// params);
	// return user;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// conn.close();
	// }
	// return user;
	// }

	public Users check2(String userName, String password) throws SQLException {// 检验用户信息是否正确
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		Users user = null;
		String sql = "SELECT * FROM user WHERE userName=? and password=?";
		try {
			Object[] params = { userName, password };
			user = (Users) qr.query(conn, sql, new BeanHandler<Users>(Users.class), params);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return user;
	}

	public Administrator loginAdministrator(String name, String password) throws SQLException {// 管理员登录
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		Administrator administrator = null;
		String sql = "SELECT * FROM administrator WHERE name=? and password=?";
		try {
			Object[] params = { name, password };
			administrator = (Administrator) qr.query(conn, sql, new BeanHandler<Administrator>(Administrator.class),
					params);
			return administrator;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return administrator;
	}

	public List<Users> select(int page, int record) {// 查询出所有用户并分页
		try {
			QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "select * from user limit ?,? ";
			Object[] params = { (page - 1) * record, record };
			List<Users> c = qr.query(sql, new BeanListHandler<Users>(Users.class), params);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getCount(int record) { // 获得分页总页数
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int n = -1;
		try {
			con = JDBCUtil.getConnection();// 第一步连接数据库
			// 第二步书写sql语句
			String sql = "select count(*) from user";

			ps = con.prepareStatement(sql);// 第三步：预编译
			// 第几页需要设置好是页数减一乘以每页的记录数即是第多少页

			// 第四步执行sql
			rs = ps.executeQuery();

			if (rs.next()) {
				n = rs.getInt(1);
				n = (int) Math.ceil(1.0 * n / record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源，避免出现异常
			try {
				rs.close();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return n;
	}

}
