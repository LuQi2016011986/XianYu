package xianyu;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.Notification;
import entity.Users;
import service.NotificationService;
import service.UsersService;

public class NotificationServicetTest {

	@Test
	public void testAddNotification() {
		NotificationService s= new NotificationService();
		Notification g=new Notification();
		g.setId("2222");
		g.setNotification("天天开心！！");
		Date date = new Date();
		g.setDate(date);
		System.out.println("hhhhh");
		try {
			s.addNotification(g);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testUpdateNotification() {
		NotificationService s= new NotificationService();
		Notification g=new Notification();
		g.setId("2222");
		g.setNotification("天天开心！！");
		Date date = new Date();
		g.setDate(date);
		try {
			s.updateNotification(g);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testDeleteNotification() {
		NotificationService s= new NotificationService();
		try {
			s.deleteNotification("2222");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testQueryNotification() {
		NotificationService s= new NotificationService();
		try {
			s.queryNotification("123456");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSelect() {
		NotificationService s= new NotificationService();
		try {
			List<Notification> l=s.select(1, 3);
			System.out.println(l);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testGetCount() {
		NotificationService s= new NotificationService();
		try {
			int m=s.getCount(2);
			System.out.println(m);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
