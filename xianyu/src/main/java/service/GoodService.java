package service;

import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import dao.GoodsDao;
import dao.MessageDao;
import dao.OrderDao;
import entity.Goods;
import entity.Order;

public class GoodService {
	
	/** 
     * 通过id查询商品
     */ 
	public void addgood(Goods n) throws SQLException {// 发布一件商品
		GoodsDao dao = new GoodsDao();
		dao.addgood(n);
	}

	/** 
     * 查询某人发布的物品
     */ 
	public List<Goods> selectf(String userName) {// 查询某人发布的物品
		GoodsDao dao = new GoodsDao();
		return dao.selectf(userName);
	}

	/** 
     * 查询某件物品
     */ 
	public Goods query(String id) throws SQLException {// 查询某件物品
		GoodsDao dao = new GoodsDao();
		return dao.query(id);
	}

	/** 
     *查询某个订单
     */ 
	public Order query1(String id) throws SQLException {// 查询某个订单
		OrderDao dao = new OrderDao();
		return dao.query(id);
	}

	/** 
     * 生成订单
     */ 
	public void addorder(Order n) throws SQLException {// 生成订单
		OrderDao dao = new OrderDao();
		GoodsDao dao1 = new GoodsDao();
		dao.addorder(n);
		dao1.setstate3(n.getGoodId());
	}

	/** 
     *完成订单
     */ 
	public void compelet(Order n) throws SQLException {// 完成订单
		OrderDao dao = new OrderDao();
		GoodsDao dao1 = new GoodsDao();
		Order m = dao.query(n.getOrderId());
		dao.compelet(n);
		dao1.setstate1(m.getGoodId());
	}

	/** 
     * 取消订单
     */ 
	public void cancel(Order n) throws SQLException {// 取消订单
		OrderDao dao = new OrderDao();
		GoodsDao dao1 = new GoodsDao();
		Order m = dao.query(n.getOrderId());
		dao.cancel(n);
		dao1.setstate2(m.getGoodId());
	}

	/** 
     * 查询正在进行的订单
     */ 
	public List<Order> selectnow(String userName) {// 查询正在进行的订单
		OrderDao dao = new OrderDao();
		return dao.selectnow(userName);
	}

	/** 
     * 查询已完成的订单
     */ 
	public List<Order> selectcom(String userName) {// 查询已完成的订单
		OrderDao dao = new OrderDao();
		return dao.selectcom(userName);
	}

	/** 
     * 查询联系人
     */ 
	public List<String> querypeople(String name) throws SQLException {// 查询联系人
		MessageDao dao = new MessageDao();
		return dao.querypeople(name);
	}

	/** 
     * 发送邮件
     */ 
	@SuppressWarnings("resource")
	public void semail(String email, String text1, String subject1) throws MessagingException {

		String receiveMailAccount = "1191235915@qq.com";
		String subject = "JAVAmail测试";
		String text = "这是一封由JavaMail发送的邮件！lalaal好开心呀";

		receiveMailAccount = email;
		subject = subject1;
		text = text1;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mail.xml");

		JavaMailSender sender = (JavaMailSender) ctx.getBean("mailSender");// 获取JavaMailSender
		MimeMessage mm = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mm, true, "utf-8");
		try {
			helper.setTo(receiveMailAccount);// 接受者
			helper.setFrom("1191235915@qq.com");// 发送者
			helper.setSubject(subject);// 主题
			helper.setText(text, true);// 第二个参数代表发送的是正文是html
			sender.send(mm);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
