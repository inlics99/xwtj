package com.service.user.impl;

import java.util.List;

import com.dao.user.manager;
import com.dao.user.impl.managerImpl;
import com.service.user.managerService;

public class managerServiceImpl implements managerService {
	manager ma=new managerImpl();
	managerImpl mai=new managerImpl();
	public void setEVERYPAGENUM(int EVERYPAGENUM) {
		mai.setEVERYPAGENUM(EVERYPAGENUM);
	}
	public int getMessageCount() {
		// TODO Auto-generated method stub
		return ma.getMessageCount();
	}

	public int getPageCount() {
		// TODO Auto-generated method stub
		return ma.getPageCount();
	}

	public List getMessage(int page) {
		// TODO Auto-generated method stub
		return ma.getMessage(page);
	}

	public int adminLogin(String username, String md5password, String password, String loginip, String useros) {
		// TODO Auto-generated method stub
		return ma.adminLogin(username, md5password, password, loginip, useros);
	}

	public List getAdminInfo(String username) {
		// TODO Auto-generated method stub
		return ma.getAdminInfo(username);
	}

	public int editPassword(String username, String oldpwd, String newpwd) {
		// TODO Auto-generated method stub
		return ma.editPassword(username, oldpwd, newpwd);
	}

	public int addManager(String username, String password, String type, String isuse) {
		// TODO Auto-generated method stub
		return ma.addManager(username, password, type, isuse);
	}

	public int updateManager(String username, String password, String type, String isuse) {
		// TODO Auto-generated method stub
		return ma.updateManager(username, password, type, isuse);
	}

	public List getAllManager() {
		// TODO Auto-generated method stub
		return ma.getAllManager();
	}

	public int delManager(int id) {
		// TODO Auto-generated method stub
		return ma.delManager(id);
	}

//	public int delLog(int[] id) {
//		// TODO Auto-generated method stub
//		return ma.delLog(id);
//	}

}
