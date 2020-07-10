package com.dao.admin;

import java.util.List;

public interface Affiche {
	public int addAffiche(String title,String content,String adder,String i);//增加公告\
	public int updateAffiche(int id,String title,String content,String adder,String ifhide);//修改公告
	public int delAffiche(int id[]);//删除公告
	public int hideAffiche(int id);//显示隐藏公告
	public List getOneAffiche(int id);//通过id获取公告
	public List getAllAffiche();//首页显示所有公告
	public List getAllAfficheManage();//后台显示所有公告
	
}
