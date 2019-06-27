package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class MessageDao {
	public List<String> querypeople(String name) throws SQLException {// 查询联系人
		Connection conn = JDBCUtil.getDataSource().getConnection();
		QueryRunner qr = new QueryRunner();
		List<String> list = new ArrayList<String>();
		String sql="select distinct initiatorName from Message  where recipientName=? order by date desc ";
		try {
			Object[] params = { name};
			list = (ArrayList<String>) qr.query(conn, sql, new ColumnListHandler(),params);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			conn.close();
		}
		return null;
	}
}
