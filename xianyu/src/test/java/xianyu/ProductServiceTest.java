package xianyu;

//import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.Goods;
import entity.Message;
import entity.Order;
import entity.Page;
import service.ProductService;

public class ProductServiceTest {
	ProductService ps = new ProductService();

	@Test
	public void testAddMessage() {
		Message m = new Message();
		Date date = new Date();
	    m.setId("100002");
	    m.setInitiatorName("迷糊猫");
	    m.setRecipientName("大琪");
	    m.setContent("try message");
	    m.setDate(date);
	    ps.addMessage(m);
	    System.out.println("AddMessage正确");
	}

	@Test
	public void testQueryMessage() {
		Page p =null;
	    p = ps.queryMessage(1,"lxz","lxz","lxz","lxz");

	    if(p != null)
	        System.out.println("QueryMessage正确");
	    else
	        System.out.println("QueryMessage错误");

	}

	@Test
	public void testFindAll() {
		List<Goods> l = null;
	    l = ps.findAll();

	    if(l != null)
	        System.out.println("FindAll正确");
	    else
	        System.out.println("FindAll错误");

	}

	@Test
	public void testFuzzyquery() {
		List<Goods> l = null;
	    l = ps.Fuzzyquery("书");

	    if(l != null)
	        System.out.println("Fuzzyquery正确");
	    else
	        System.out.println("Fuzzyquery错误");

	}

	@Test
	public void testFindType() {
		List<Goods> l = null;
	    l = ps.findType();

	    if(l != null)
	        System.out.println("FindType正确");
	    else
	        System.out.println("FindType错误");

	}

	@Test
	public void testFindGoods() {
		List<Goods> l = null;
	    l = ps.findGoods();

	    if(l != null)
	        System.out.println("FindGoods正确");
	    else
	        System.out.println("FindGoods错误");

	}

	@Test
	public void testFindById() {
		List<Goods> l = null;
	    l = ps.findById("");

	    if(l != null)
	        System.out.println("FindById正确");
	    else
	        System.out.println("FindById错误");

	}

	@Test
	public void testFindOrById() {
		List<Order> l = null;
	    l = ps.findOrById("");

	    if(l != null)
	        System.out.println("FindById正确");
	    else
	        System.out.println("FindById错误");
	}

	@Test
	public void testQueryByPage() {
		Page p = null;
	    p = ps.queryByPage(1);
	    if(p != null)
	        System.out.println("QueryByPage正确");
	    else
	        System.out.println("QueryByPage错误");

	}

	@Test
	public void testQueryByPage2() {
		Page p = null;
	    p = ps.queryByPage2(1,"书籍");
	    if(p != null)
	        System.out.println("QueryByPage2正确");
	    else
	        System.out.println("QueryByPage2错误");

	}

	@Test
	public void testQueryByPage3() {
		Page p = null;
	    p = ps.queryByPage3(1,"书籍");
	    if(p != null)
	        System.out.println("QueryByPage3正确");
	    else
	        System.out.println("QueryByPage3错误");
	}

	@Test
	public void testQueryProByPage() {
		Page p = null;
	    p = ps.queryProByPage(1);
	    if(p != null)
	        System.out.println("QueryProByPage正确");
	    else
	        System.out.println("QueryProByPage错误");

	}

}
