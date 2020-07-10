package com.dao.user;
//管理员
import java.util.List;

public interface manager {
	 public int getMessageCount();//得到信息总数
	 public int getPageCount();//得到共多少页（根据每页要显示几条信息）
	 public List getMessage(int page);//得到每页要显示的信息
	 public int adminLogin(String username,String md5password,String password,String loginip,String useros);//管理员登录 更新登录次数 写登录日志
	 public List getAdminInfo(String username);//查询管理员信息
	 public int editPassword(String username,String oldpwd,String newpwd);//修改管理员密码
	 public int addManager(String username,String password,String type,String isuse);//增加管理员
	 public int updateManager(String username,String password,String type,String isuse);//修改管理员信息
	 public List getAllManager();//获取所有管理员信息
	 public int delManager(int id);//删除管理员
//	 public int delLog(int id[]);//delete login note
	 
}
