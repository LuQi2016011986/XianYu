package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Goods;

public class GoodsDao {
	public void addgood(Goods n) throws SQLException {// 发布一件商品
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "insert into goods (goodsId,userName,itemName,ifNew,barterType,barter,ifBargain,cateogory,itemDescription,pictureAddress,state,date) values(?,?,?,?,?,?,?,?,?,?,?,now())";
		try {
			Object[] params = { UUIDUtils.getUUID(), n.getUserName(), n.getItemName(), n.getIfNew(), n.getBarterType(),
					n.getBarter(), n.getIfBargain(), n.getCateogory(), n.getItemDescription(), n.getPictureAddress(),
					n.getState() };
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
	}

	public Goods query(String id) throws SQLException {// 查询某件物品
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM goods where goodsId= ?";
		try {
			Object[] params = { id };
			Goods n = (Goods) qr.query(conn, sql, new BeanHandler<Goods>(Goods.class), params);
			return n;
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
		return null;
	}

	public void setstate1(String goodsId) throws SQLException {// 设置物品状态为已完成
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE goods SET state=? WHERE goodsId=?";
		try {
			Object[] params = { 2, goodsId };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public void setstate2(String goodsId) throws SQLException {// 设置物品状态为买卖
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE goods SET state=? WHERE goodsId=?";
		try {
			Object[] params = { 0, goodsId };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public void setstate3(String goodsId) throws SQLException {// 设置物品状态为正在交易
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE goods SET state=? WHERE goodsId=?";
		try {
			Object[] params = { 1, goodsId };
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public List<Goods> selectf(String userName) {// 查询某人发布的物品
		try {
			QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "select * from goods where userName=?";

			Object[] params = { userName };
			List<Goods> c = qr.query(sql, new BeanListHandler<Goods>(Goods.class), params);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
