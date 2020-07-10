package com.service.user.impl;

import java.util.List;

import com.dao.user.userAdministration;
import com.dao.user.impl.userAdministrationImpl;
import com.service.user.userAdministrationService;

public class userAdministrationServiceImpl implements userAdministrationService {
	userAdministration uas=new userAdministrationImpl();
	public void setEVERYPAGENUM(int EVERYPAGENUM) {
		// TODO Auto-generated method stub
		uas.setEVERYPAGENUM(EVERYPAGENUM);
	}

	public int getMessageCount() {
		// TODO Auto-generated method stub
		return uas.getMessageCount();
	}

	public int getPageCount() {
		// TODO Auto-generated method stub
		return uas.getPageCount();
	}

	public List getMessage(int page) {
		// TODO Auto-generated method stub
		return uas.getMessage(page);
	}

//	public int getMessageCountUS() {
//		// TODO Auto-generated method stub
//		return uas.getMessageCountUS();
//	}

//	public List getMessageUS(int page) {
//		// TODO Auto-generated method stub
//		return uas.getMessageUS(page);
//	}

//	public int getMessageCountCL() {
//		// TODO Auto-generated method stub
//		return uas.getMessageCountCL();
//	}
//
//	public List getMessageCL(int page) {
//		// TODO Auto-generated method stub
//		return uas.getMessageCL(page);
//	}
//
//	public int getMessageCountTODAY() {
//		// TODO Auto-generated method stub
//		return uas.getMessageCountTODAY();
//	}
//
//	public List getMessageTODAY(int page) {
//		// TODO Auto-generated method stub
//		return uas.getMessageTODAY(page);
//	}

	public int delMember(int id) {
		// TODO Auto-generated method stub
		return uas.delMember(id);
	}

	public int closeMember(int id) {
		// TODO Auto-generated method stub
		return uas.closeMember(id);
	}

//	public String getType(int id) {
//		// TODO Auto-generated method stub
//		return uas.getType(id);
//	}

	public List getMemberLogin(int id) {
		// TODO Auto-generated method stub
		return uas.getMemberLogin(id);
	}

	public List getPerSonMember(int id) {
		// TODO Auto-generated method stub
		return uas.getPerSonMember(id);
	}

	public String getType(String name) {
		// TODO Auto-generated method stub
		return uas.getType(name);
	}

	public int getID(String name) {
		// TODO Auto-generated method stub
		return uas.getID(name);
	}

	public String getType(int id, String name) {
		// TODO Auto-generated method stub
		return uas.getType(id, name);
	}

	public List getMemberByTime(String stime, String etime) {
		// TODO Auto-generated method stub
		return uas.getMemberByTime(stime, etime);
	}

}
