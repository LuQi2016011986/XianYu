package service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dao.Usersdao;
import entity.Administrator;
import entity.Users;

public class UsersService {
	/** 
     *  增加一条用户信息
     */   
	public void addUsers(Users g) throws SQLException {// 增加一条用户信息
		Usersdao dao = new Usersdao();
		dao.addUsers(g);
	}

	/** 
     *  修改一条用户信息
     */   
	public void updateUsers(Users g) throws SQLException {// 修改一条用户信息
		Usersdao dao = new Usersdao();
		dao.updateUsers(g);
	}

	/** 
     *  激活邮箱
     */   
	public Users active(String userId, String active) throws SQLException {// 激活邮箱
		Usersdao dao = new Usersdao();
		return dao.active(userId, active);
	}

	/** 
     *  修改一条用户信用度
     */   
	public void updateCredit(Users g) throws SQLException {// 修改一条用户信用度
		Usersdao dao = new Usersdao();
		dao.updateCredit(g);
	}

	/** 
     *  查询用户名是否存在
     */   
	public boolean ifExits(String userName) throws SQLException {// 查询用户名是否存在
		Usersdao dao = new Usersdao();
		return dao.ifExits(userName);
	}

	/** 
     *  查询是否在黑名单
     */   
	public String queryBlack(String userId) throws SQLException {// 查询是否在黑名单
		Usersdao dao = new Usersdao();
		return dao.queryBlack(userId);
	}

	/** 
     *  封号
     */   
	public void deleteUsers(String userId) throws SQLException {// 封号
		Usersdao dao = new Usersdao();
		dao.deleteUsers(userId);
	}
	
	/** 
     *  删除用户信息
     */   
	public void deleteU(String userId) throws SQLException {
		Usersdao dao = new Usersdao();
		dao.deleteU(userId);
	}
	
	/** 
     *  通过id删除用户信息
     */   
	public void deleteU1(String userId) throws SQLException {
		Usersdao dao = new Usersdao();
		dao.deleteU1(userId);
	}

	/** 
     *  查询用户
     */   
	public Users queryUsers(String name) throws SQLException {// 查询用户
		Usersdao dao = new Usersdao();
		return dao.queryUsers(name);
	}

	/** 
     *  修改登录时间
     */   
	public Users login(String username, Date date) throws SQLException {// 修改登录时间
		Usersdao dao = new Usersdao();
		return dao.login(username, date);
	}

	// public Users check(String QQ, String telephone) throws SQLException {//
	// 判断是否能成功登录
	// Usersdao dao = new Usersdao();
	// return dao.check(QQ, telephone);
	// }

	/** 
     *  判断是否能成功登录
     */   
	public Users check2(String userName, String password) throws SQLException {// 判断是否能成功登录
		Usersdao dao = new Usersdao();
		return dao.check2(userName, password);
	}

	/** 
     *  判断管理员是否能成功登录
     */   
	public Administrator loginAdministrator(String name, String password) throws SQLException {// 判断管理员是否能成功登录
		Usersdao dao = new Usersdao();
		return dao.loginAdministrator(name, password);
	}

	/** 
     *  查询出所有用户数据并分页
     */   
	public List<Users> select(int page, int record) {// 查询出所有用户数据并分页
		Usersdao dao = new Usersdao();
		return dao.select(page, record);
	}

	/** 
     *  获得分页总页数
     */   
	public int getCount(int record) { // 获得分页总页数
		Usersdao dao = new Usersdao();
		return dao.getCount(record);
	}

}
