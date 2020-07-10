package com.dao.user;
//用户管理
import java.util.List;

public interface userAdministration {
	//分页查询用户
	public void setEVERYPAGENUM(int EVERYPAGENUM);//分页查询所有个人会员
	public int getMessageCount();//得到信息总数
	public int getPageCount();//得到共多少页（根据每页要显示几条信息）
	public List getMessage(int page);//得到每页要显示的信息
	//所有在用用户
//	public int getMessageCountUS();//得到信息总数
//	public List getMessageUS(int page);//得到每页要显示的信息
	//所有冻结用户
//	public int getMessageCountCL();//得到信息总数
//	public List getMessageCL(int page);//得到每页要显示的信息
//	//今日注册用户
//	 public int getMessageCountTODAY();//得到信息总数
//	 public List getMessageTODAY(int page);//得到每页要显示的信息
	 //冻结删除用户
	 public int delMember(int id);//删除用户
	 public int closeMember(int id);//冻结用户
	 //后台查询单条个人  查询用户类型
//	 public String getType(int id); //以id为条件查询用户类型
	 public List getMemberLogin(int id); //以id为条件 单条会员登陆信息
	 public List getPerSonMember(int id);//以id为条件 单条个人会员信息
	 public String getType(String name);//	以用户名为条件查询会员类型
	 public int getID(String name); //以用户名为条件查询用户id
	 public String getType(int id,String name);//以用户名 id为条件查询
	 public List getMemberByTime(String stime,String etime);//按注册时间查询
	 
	 
}
