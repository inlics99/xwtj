package com.service.admin;

import java.util.List;

import com.entity.affiche;

public interface afficheService {
	public int addAffiche(affiche affiche);//增加公告\
	public int updateAffiche(affiche affiche);//修改公告
	public int delAffiche(int id[]);//删除公告
	public int hideAffiche(int id);//显示隐藏公告
	public List getOneAffiche(int id);//通过id获取公告
	public List getAllAffiche();//首页显示所有公告
	public List getAllAfficheManage();//后台显示所有公告
}
