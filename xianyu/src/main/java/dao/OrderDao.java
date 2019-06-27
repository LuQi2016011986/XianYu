package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Order;

public class OrderDao {
	public void addorder(Order n) throws SQLException {// 生成订单
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orders(orderId,state,goodId,purchaser,seller,date) values(?,?,?,?,?,now())";
		try {
			Object[] params = { UUIDUtils.getUUID(), 1, n.getGoodId(), n.getPurchaser(), n.getSeller() };
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
	}

	public Order query(String id) throws SQLException {// 查询某个订单
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM orders where orderId= ?";
		try {
			Object params = id;
			Order n = (Order) qr.query(conn, sql, new BeanHandler<Order>(Order.class), params);
			return n;
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
		return null;
	}

	public void compelet(Order n) throws SQLException {// 完成订单
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE orders SET state=?,level=?,comment=? ,date= now() WHERE orderId=?";
		try {
			Object[] params = { 2, n.getLevel(), n.getComment(), n.getOrderId() };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public void cancel(Order n) throws SQLException {// 取消订单
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE orders SET state=? ,date= now() WHERE orderId=?";
		try {
			Object[] params = { 0, n.getOrderId() };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public List<Order> selectnow(String userName) {// 查询正在进行的订单
		try {
			QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "select * from orders where state=? and (purchaser=? or seller=?)";

			Object[] params = { 1, userName, userName };
			List<Order> c = qr.query(sql, new BeanListHandler<Order>(Order.class), params);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Order> selectcom(String userName) {// 查询已完成的订单
		try {
			QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "select * from orders where state=? and (purchaser=? or seller=?)";

			Object[] params = { 2, userName, userName };
			List<Order> c = qr.query(sql, new BeanListHandler<Order>(Order.class), params);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
