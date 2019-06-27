package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import entity.Goods;
import entity.Message;
import entity.Order;

/**
 * 对product表进行增删改查
 *
 * @author Administrator
 *
 */
public class ProductDao {
	QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

	/**
	 * 添加商品
	 *
	 * @param
	 * @throws SQLException
	 */
	public void insertComment(Message m) throws Exception {
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into message(id,content,initiatorName,recipientName,date) values(?,?,?,?,?)";
		qr.update(connection, sql, m.getId(), m.getContent(), m.getInitiatorName(), m.getRecipientName(), m.getDate());
	}

	// 查询所有商品
	public List<Goods> findAll() throws SQLException {
		String sql = "select * from goods where state=0";
		List<Goods> list = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		return list;
	}

	public List<Goods> findGoods() throws SQLException {
		String sql = "select * from goods where state=0";
		List<Goods> list2 = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		return list2;
	}

	public List<Goods> findType() throws SQLException {
		String sql = "select DISTINCT cateogory from goods where state=0";
		List<Goods> list1 = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		return list1;
	}

	// 根据id查找商品
	public List<Goods> findProductById(String id) throws SQLException {
		String sql = "select * from goods where goodsId=?";
		List<Goods> list3 = qr.query(sql, new BeanListHandler<Goods>(Goods.class), id);
		return list3;
	}

	public List<Goods> Fuzzyquery(String conf) throws SQLException {
		String sql = "select * from goods where itemName like \"%\"?\"%\" AND state=0";
		List<Goods> list5 = qr.query(sql, new BeanListHandler<Goods>(Goods.class), conf);
		return list5;
	}

	public List<Order> findOrderById(String id) throws SQLException {
		String sql = "select * from orders where goodId=?";
		List<Order> list4 = qr.query(sql, new BeanListHandler<Order>(Order.class), id);
		return list4;
	}

	/**
	 * 查询总记录数
	 *
	 * @throws SQLException
	 *
	 */
	public int queryTotalRecord() throws SQLException {
		String sql = "select count(*) from goods";
		Long num = qr.query(sql, new ScalarHandler<Long>());
		return num.intValue();
	}

	public int queryTotalRecord1(String initiatorName, String recipientName, String initiatorName1,
			String recipientName1) throws SQLException {
		String sql = "select count(*) from message where (initiatorName=? AND recipientName=?) OR (recipientName=? AND initiatorName=?)";
		Long num = qr.query(sql, new ScalarHandler<Long>(), initiatorName, recipientName, initiatorName1,
				recipientName1);
		return num.intValue();
	}

	/**
	 * 分页查询
	 *
	 * @throws SQLException
	 *
	 */
	public List<Goods> queryByPage(int recordStartIndex, int pageSize) throws SQLException {
		String sql = "select * from goods where state=0 limit ?,?";
		List<Goods> datas = qr.query(sql, new BeanListHandler<Goods>(Goods.class), recordStartIndex, pageSize);
		return datas;
	}

	public List<Message> queryByPageM(int recordStartIndex, int pageSize, String initiatorName, String recipientName,
			String initiatorName1, String recipientName1) throws SQLException {
		String sql = "select * from message where (initiatorName=? AND recipientName=?) OR (recipientName=? AND initiatorName=?) order by date ASC limit ?,?";
		List<Message> datas = qr.query(sql, new BeanListHandler<Message>(Message.class), initiatorName, recipientName,
				initiatorName1, recipientName1, recordStartIndex, pageSize);
		return datas;
	}

	public List<Goods> queryByPage1(int recordStartIndex, int pageSize, int id) throws SQLException {
		String sql = "select * from comment where id = ? AND state=0 limit ?,?";
		List<Goods> datas = qr.query(sql, new BeanListHandler<Goods>(Goods.class), id, recordStartIndex, pageSize);
		return datas;
	}

	public List<Goods> queryByPage2(int recordStartIndex, int pageSize, String type) throws SQLException {
		String sql = "select * from goods where cateogory = ? AND state=0 limit ?,?";
		List<Goods> datas = qr.query(sql, new BeanListHandler<Goods>(Goods.class), type, recordStartIndex, pageSize);
		return datas;
	}

	public List<Goods> queryByPage3(int recordStartIndex, int pageSize, String barterType) throws SQLException {
		String sql = "select * from goods where barterType = ? AND state=0 limit ?,?";
		List<Goods> datas = qr.query(sql, new BeanListHandler<Goods>(Goods.class), barterType, recordStartIndex,
				pageSize);
		return datas;
	}

	public List<Goods> queryByPage4(int recordStartIndex, int pageSize) throws SQLException {
		String sql = "select * from goods limit ?,?";
		List<Goods> datas = qr.query(sql, new BeanListHandler<Goods>(Goods.class), recordStartIndex, pageSize);
		return datas;
	}
}
