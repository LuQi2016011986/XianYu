package service;

import java.util.Date;

import entity.Goods;
import entity.Message;
import entity.Order;
import entity.Page;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Date;
import java.util.List;

/** 
* ProductService Tester. 
* 
* @author <Authors name> 
* @since <pre> 2019</pre>
* @version 1.0 
*/ 
public class ProductServiceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}


    ProductService ps = new ProductService();

/** 
* 
* Method: addMessage(Message m) 
* 
*/ 
@Test
public void testAddMessage() throws Exception { 
//TODO: Test goes here...
    Message m = new Message();
    m.setId("111");
    m.setInitiatorName("lxz");
    m.setRecipientName("lxz");
    m.setContent("try message");
    m.setDate(new Date());
    ps.addMessage(m);

    System.out.println("AddMessage程序正常！");
} 

/** 
* 
* Method: queryMessage(int pageCode, String initiatorId, String recipientId, String initiatorId1, String recipientId1) 
* 
*/ 
@Test
public void testQueryMessage() throws Exception { 
//TODO: Test goes here...
    Page p =null;
    p = ps.queryMessage(1,"lxz","lxz","lxz","lxz");

    if(p != null)
        System.out.println("QueryMessage程序正常！");
    else
        System.out.println("QueryMessage程序有误！");
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    List<Goods> l = null;
    l = ps.findAll();

    if(l != null)
        System.out.println("FindAll程序正常！");
    else
        System.out.println("FindAll程序有误！");
} 

/** 
* 
* Method: Fuzzyquery(String conf) 
* 
*/ 
@Test
public void testFuzzyquery() throws Exception { 
//TODO: Test goes here...
    List<Goods> l = null;
    l = ps.Fuzzyquery("书");

    if(l != null)
        System.out.println("Fuzzyquery程序正常！");
    else
        System.out.println("Fuzzyquery程序有误！");
} 

/** 
* 
* Method: findType() 
* 
*/ 
@Test
public void testFindType() throws Exception { 
//TODO: Test goes here...
    List<Goods> l = null;
    l = ps.findType();

    if(l != null)
        System.out.println("FindType程序正常！");
    else
        System.out.println("FindType程序有误！");
} 

/** 
* 
* Method: findGoods() 
* 
*/ 
@Test
public void testFindGoods() throws Exception { 
//TODO: Test goes here...
    List<Goods> l = null;
    l = ps.findGoods();

    if(l != null)
        System.out.println("FindGoods程序正常！");
    else
        System.out.println("FindGoods程序有误！");
} 

/** 
* 
* Method: findById(String id) 
* 
*/ 
@Test
public void testFindById() throws Exception { 
//TODO: Test goes here...
    List<Goods> l = null;
    l = ps.findById("");

    if(l != null)
        System.out.println("FindById程序正常！");
    else
        System.out.println("FindById程序有误！");
} 

/** 
* 
* Method: findOrById(String id) 
* 
*/ 
@Test
public void testFindOrById() throws Exception { 
//TODO: Test goes here...
    List<Order> l = null;
    l = ps.findOrById("");

    if(l != null)
        System.out.println("FindById程序正常！");
    else
        System.out.println("FindById程序有误！");
} 

/** 
* 
* Method: queryByPage(int pageCode) 
* 
*/ 
@Test
public void testQueryByPage() throws Exception { 
//TODO: Test goes here...
    Page p = null;
    p = ps.queryByPage(1);
    if(p != null)
        System.out.println("QueryByPage程序正常！");
    else
        System.out.println("QueryByPage程序有误！");
} 

/** 
* 
* Method: queryByPage1(int pageCode, int id) 
* 
*/ 
@Test
public void testQueryByPage1() throws Exception { 
//TODO: Test goes here...
    Page p = null;
    p = ps.queryByPage1(1,1);
    if(p != null)
        System.out.println("QueryByPage1程序正常！");
    else
        System.out.println("QueryByPage1程序有误！");
} 

/** 
* 
* Method: queryByPage2(int pageCode, String type) 
* 
*/ 
@Test
public void testQueryByPage2() throws Exception { 
//TODO: Test goes here...
    Page p = null;
    p = ps.queryByPage2(1,"书籍");
    if(p != null)
        System.out.println("QueryByPage2程序正常！");
    else
        System.out.println("QueryByPage2程序有误！");
} 

/** 
* 
* Method: queryByPage3(int pageCode, String barterType) 
* 
*/ 
@Test
public void testQueryByPage3() throws Exception { 
//TODO: Test goes here...
    Page p = null;
    p = ps.queryByPage3(1,"书籍");
    if(p != null)
        System.out.println("QueryByPage3程序正常！");
    else
        System.out.println("QueryByPage3程序有误！");
} 

/** 
* 
* Method: queryProByPage(int pageCode) 
* 
*/ 
@Test
public void testQueryProByPage() throws Exception { 
//TODO: Test goes here...
    Page p = null;
    p = ps.queryProByPage(1);
    if(p != null)
        System.out.println("QueryProByPage程序正常！");
    else
        System.out.println("QueryProByPage程序有误！");
} 


} 
