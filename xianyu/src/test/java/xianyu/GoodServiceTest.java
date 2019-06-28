package xianyu;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import entity.Goods;
import entity.Order;
import junit.framework.TestCase;
import service.GoodService;

public class GoodServiceTest extends TestCase {
	@Test
	public void testAddgood() {
		Goods g=new Goods();
		g.userName="迷糊猫";
		g.itemName="高数书";
		g.ifNew=1;
		g.barterType="0";
		g.barter="23";
		g.ifBargain=0;
		g.cateogory="书籍";
		g.state=0;
		GoodService s=new GoodService();
		try {
			s.addgood(g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSelectf() {
		String name="迷糊猫";
		GoodService s=new GoodService();
		List<Goods> g=s.selectf(name);
		System.out.println(g);
	}
	@Test
	public void testQuery() {
		GoodService s=new GoodService();
		Goods g;
		try {
			g = s.query("9b7698f42e2d468f8ac3fee0f9b0705a");
			System.out.println(g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testQuery1() {
		GoodService s=new GoodService();
		Order o=new Order();
		try {
			o=s.query1("1");
			System.out.println(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testAddorder() {
		GoodService s=new GoodService();
		Order o=new Order();
		o.setGoodId("8f2b428b58594ac6ab7270630c9bc3b8");
		o.setLevel(5);
		o.setComment("很好");
		o.setPurchaser("琪变态");
		o.setSeller("迷糊猫");
		try {
			s.addorder(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testCompelet() {
		GoodService s=new GoodService();
		Order o;
		try {
			o = s.query1("700c4fb803de4fddb199fba42d551209");
			s.compelet(o);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Test
	public void testCancel() {
		GoodService s=new GoodService();
		Order o;
		try {
			o = s.query1("700c4fb803de4fddb199fba42d551209");
			s.cancel(o);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Test
	public void testSelectnow() {
		GoodService s=new GoodService();
		s.selectnow("琪变态");
	}
	@Test
	public void testSelectcom() {
		GoodService s=new GoodService();
		s.selectcom("琪变态");
	}
	@Test
	public void testQuerypeople() {
		GoodService s=new GoodService();
		try {
			s.querypeople("迷糊猫");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
