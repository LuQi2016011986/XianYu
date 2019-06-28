package xianyu;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.junit.Test;

import entity.Users;
import service.UsersService;

public class UsersServiceTest {

	@Test
	public void testAddUsers() {
		UsersService s=new UsersService();
		Users u=new Users();
		u.setUserId("luq215");
		u.setUserName("多多4");
		u.setPassword("1");
		u.setMail("1191235915@qq.com");
		u.setTelephone("12111111111");
		u.setActive("1");
		try {
			s.addUsers(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testUpdateUsers() {
		UsersService s=new UsersService();
		Users u=new Users();
		u.setUserName("多多4");
		u.setPassword("1");
		u.setMail("1191235915@qq.com");
		u.setTelephone("12111111111");
		u.setActive("1");
		try {
			s.updateUsers(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testActive() {
		UsersService s=new UsersService();
		try {
			s.active("luq215", "1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateCredit() {
		UsersService s=new UsersService();
		Users u=new Users();
		u.setCredit(4);
		u.setNum(1);
		u.setUserId("luq215");
		try {
			s.updateCredit(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testIfExits() {
		UsersService s=new UsersService();
		try {
			s.ifExits("琪变态");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryBlack() {
		UsersService s = new UsersService();
		try {
			s.queryBlack("luq275");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testDeleteUsers() {
		UsersService s = new UsersService();
		try {
			s.deleteUsers("luq215");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testDeleteU() {
		UsersService s = new UsersService();
		try {
			s.deleteU("luq215");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	public void testDeleteU1() {
		UsersService s = new UsersService();
		try {
			s.deleteU1("luq215");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testQueryUsers() {
		UsersService s = new UsersService();
		try {
			s.queryUsers("琪变态");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

	@Test
	public void testCheck2() {
		UsersService s = new UsersService();
		try {
			s.check2("琪变态", "123456");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testLoginAdministrator() {
		UsersService s = new UsersService();
		try {
			s.loginAdministrator("迷糊猫", "66666666");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSelect() {
		UsersService s = new UsersService();
		try {
			s.select(1, 1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testGetCount() {
		UsersService s = new UsersService();
		try {
			s.getCount(3);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	


}
