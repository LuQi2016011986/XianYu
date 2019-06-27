package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Notification;

public class Notificationdao {
	public void addNotification(Notification g) throws SQLException {// 增加一条公告信息
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		Timestamp date0 = new Timestamp(g.getDate().getTime());
		String sql = "insert into notification (id,notification,date) values(?,?,?)";
		try {
			Object[] params = { g.getId(), g.getNotification(), date0 };
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
	}

	public void updateNotification(Notification g) throws SQLException {// 更改一条公告信息
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		Timestamp date0 = new Timestamp(g.getDate().getTime());
		String sql = "UPDATE notification SET notification=?,date=? WHERE id=?";
		try {
			Object[] params = { g.getNotification(), date0, g.getId() };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public Notification queryNotification(String id) throws SQLException {// 查询公告信息
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM  notification where id= '" + id + " '";
		try {
			Notification notification = (Notification) qr.query(conn, sql,
					new BeanHandler<Notification>(Notification.class));
			return notification;
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
		return null;
	}

	public void deleteNotification(String id) throws SQLException {// 删除一条公告信息
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM notification WHERE id=?";
		try {
			Object params = id;
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
	}

	public String unRead(String date) {// 查询出是否存在未读公告
		try {
			QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "select * from Notification where date > ? ";
			Object params = date;
			List<Notification> c = qr.query(sql, new BeanListHandler<Notification>(Notification.class), params);
			if (c != null && !c.isEmpty() && c.size() > 0)
				return "1";// 存在返回1
			else
				return "0";// 不存在返回0
		} catch (SQLException e) {
			e.printStackTrace();
			return "0";
		}
	}

	public List<Notification> select(int page, int record) {// 查询出所有公告数据并分页
		try {
			QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "select * from Notification Order by date desc limit ?,? ";
			Object[] params = { (page - 1) * record, record };
			List<Notification> c = qr.query(sql, new BeanListHandler<Notification>(Notification.class), params);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//
	// public List<Notification> select(int state, int page, int record) {//
	// 查询出所有博客数据并分页
	// try {
	// QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
	// String sql = "select * from Notification where state = ? Order by date
	// desc limit ?,? ";
	// Object[] params = { state, (page - 1) * record, record };
	// List<Notification> c = qr.query(sql, new
	// BeanListHandler<Notification>(Notification.class), params);
	// return c;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	public int getCount(int record) { // 获得分页总页数
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int n = -1;
		try {
			con = JDBCUtil.getConnection();// 第一步连接数据库
			// 第二步书写sql语句
			String sql = "select count(*) from Notification";

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

	// public int getCount1(int state, int record) { // 获得分页总页数
	// Connection con = null;
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	// int n = -1;
	// try {
	// con = JDBCUtil.getConnection();// 第一步连接数据库
	// // 第二步书写sql语句
	// String sql = "select count(*) from Notification where state = ?";
	//
	// ps = con.prepareStatement(sql);// 第三步：预编译
	// ps.setInt(1, state);
	// // 第几页需要设置好是页数减一乘以每页的记录数即是第多少页
	//
	// // 第四步执行sql
	// rs = ps.executeQuery();
	//
	// if (rs.next()) {
	// n = rs.getInt(1);
	// n = (int) Math.ceil(1.0 * n / record);
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// // 关闭资源，避免出现异常
	// try {
	// ps.close();
	// rs.close();
	// } catch (SQLException e1) {
	//
	// e1.printStackTrace();
	// }
	// try {
	// ps.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// return n;
	// }
}
