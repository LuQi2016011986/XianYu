package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import entity.Goods;
import entity.Message;
import entity.Order;
import entity.Page;

/**
 * 调用ProductDao的方法
 *
 * @author Administrator
 *
 */
public class ProductService {
	private ProductDao pDao = new ProductDao();

	public void addMessage(Message m) {
		try {
			pDao.insertComment(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Page queryMessage(int pageCode, String initiatorId, String recipientId, String initiatorId1,
			String recipientId1) {
		try {
			int totalRecord = pDao.queryTotalRecord1(initiatorId, recipientId, initiatorId1, recipientId1);
			// 创建Page
			Page pb1 = new Page(pageCode, totalRecord);
			List<Message> datas = pDao.queryByPageM((pageCode - 1) * pb1.getPageSize(), pb1.getPageSize(), initiatorId,
					recipientId, initiatorId1, recipientId1);
			pb1.setDatas2(datas);
			return pb1;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	
	/** 
     * 查询所有商品
     */  
	public List<Goods> findAll() {
		try {
			return pDao.findAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Goods> Fuzzyquery(String conf) {
		try {
			return pDao.Fuzzyquery(conf);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
     * 查找类型
     */  
	public List<Goods> findType() {
		try {
			return pDao.findType();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
     * 查询商品
     */  
	public List<Goods> findGoods() {
		try {
			return pDao.findGoods();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	/** 
     * 查看某一商品
     */   
	public List<Goods> findById(String id) {
		try {
			return pDao.findProductById(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
     * 通过id查询订单
     */   
	public List<Order> findOrById(String id) {
		try {
			return pDao.findOrderById(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 分页查询
	 *
	 * @param
	 * @return
	 */
	public Page queryByPage(int pageCode) {
		try {
			// 获取总记录数
			int totalRecord = pDao.queryTotalRecord();
			// 创建Page
			Page pb = new Page(pageCode, totalRecord);
			// 查询当前页的记录
			List<Goods> datas = pDao.queryByPage((pageCode - 1) * pb.getPageSize(), pb.getPageSize());
			// 将datas封装到pb
			pb.setDatas(datas);
			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
     * 评论分页
     */   
	public Page queryByPage1(int pageCode, int id) {
		try {
			// 获取总记录数
			int totalRecord = pDao.queryTotalRecord();
			// 创建Page
			Page pb1 = new Page(pageCode, totalRecord);
			// 查询当前页的记录
			List<Goods> datas = pDao.queryByPage1((pageCode - 1) * pb1.getPageSize(), pb1.getPageSize(), id);
			// 将datas封装到pb
			pb1.setDatas(datas);
			return pb1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
     *  商品种类分页
     */   
	public Page queryByPage2(int pageCode, String type) {
		try {
			// 获取总记录数
			int totalRecord = pDao.queryTotalRecord();
			// 创建Page
			Page pb2 = new Page(pageCode, totalRecord);
			// 查询当前页的记录
			List<Goods> datas = pDao.queryByPage2((pageCode - 1) * pb2.getPageSize(), pb2.getPageSize(), type);
			// 将datas封装到pb
			pb2.setDatas(datas);
			return pb2;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
     *  商品是否打折分页
     */   
	public Page queryByPage3(int pageCode, String barterType) {
		try {
			// 获取总记录数
			int totalRecord = pDao.queryTotalRecord();
			// 创建Page
			Page pb3 = new Page(pageCode, totalRecord);
			// 查询当前页的记录
			List<Goods> datas = pDao.queryByPage3((pageCode - 1) * pb3.getPageSize(), pb3.getPageSize(), barterType);
			// 将datas封装到pb
			pb3.setDatas(datas);
			return pb3;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
     *  所有商品分页查询
     */   
	public Page queryProByPage(int pageCode) {
		try {
			// 获取总记录数
			int totalRecord = pDao.queryTotalRecord();
			// 创建Page
			Page pb4 = new Page(pageCode, totalRecord);
			// 查询当前页的记录
			List<Goods> datas = pDao.queryByPage4((pageCode - 1) * pb4.getPageSize(), pb4.getPageSize());
			// 将datas封装到pb
			pb4.setDatas(datas);
			return pb4;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
