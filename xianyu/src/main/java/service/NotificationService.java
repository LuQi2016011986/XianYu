package service;

import java.sql.SQLException;
import java.util.List;

import dao.Notificationdao;
import entity.Notification;

public class NotificationService {
	public void addNotification(Notification g) throws SQLException {// 增加一条公告信息
		Notificationdao dao = new Notificationdao();
		dao.addNotification(g);
	}

	public void updateNotification(Notification g) throws SQLException {// 修改一条公告信息
		Notificationdao dao = new Notificationdao();
		dao.updateNotification(g);
	}

	public void deleteNotification(String id) throws SQLException {// 删除一条公告信息
		Notificationdao dao = new Notificationdao();
		dao.deleteNotification(id);
	}

	public Notification queryNotification(String id) throws SQLException {// 查询单条公告
		Notificationdao dao = new Notificationdao();
		return dao.queryNotification(id);
	}

	public String unRead(String date) {// 查询出是否有未读
		Notificationdao dao = new Notificationdao();
		return dao.unRead(date);
	}

	public List<Notification> select(int page, int record) {// 查询出所有公告数据并分页
		Notificationdao dao = new Notificationdao();
		return dao.select(page, record);
	}


	public int getCount(int record) { // 获得分页总页数
		Notificationdao dao = new Notificationdao();
		return dao.getCount(record);
	}



}
