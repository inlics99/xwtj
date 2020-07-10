package com.service.user.impl;

import java.util.List;

import com.dao.user.userDao;
import com.dao.user.impl.userDaoImpl;
import com.entity.member;
import com.entity.pmember;
import com.service.user.memberService;

public class memberServiceImpl implements memberService {
	userDao ud=new userDaoImpl();
	public int checkRegName(String username) {
		// TODO Auto-generated method stub
		return ud.checkRegName(username);
	}

	public int editPassword(String username, String oldpwd, String newpwd) {
		// TODO Auto-generated method stub
		return ud.editPassword(username, oldpwd, newpwd);
	}

	public int memberLogin(String username, String password, String type) {
		// TODO Auto-generated method stub
		return ud.memberLogin(username, password, type);
	}

	public String getLastTimeIP(String username) {
		// TODO Auto-generated method stub
		return ud.getLastTimeIP(username);
	}

	public int upmemberLogin(String username, String lastip) {
		// TODO Auto-generated method stub
		return ud.upmemberLogin(username, lastip);
	}

	public String getLogintimes(String username) {
		// TODO Auto-generated method stub
		return ud.getLogintimes(username);
	}

	public int personReg(String username,String password,String type,String realname,String sex,String bir,String sheng,String city,String telphone,String email,String question,String answer,String lastip,int off,String address) {
		// TODO Auto-generated method stub
		//String username,String password,String type,String realname,String sex,String bir,String sheng,String city,String telphone,String email,String question,String answer,String lastip,int off,String address
		//System.out.println(mem.getUsername()+ mem.getPassword()+mem.getType()+pmem.getRealname()+pmem.getSex()+"  …˙»’::"+pmem.getBir()+"  "+pmem.getSheng()+pmem.getCity()+pmem.getTelphone()+pmem.getEmail()+pmem.getQuestion()+pmem.getAnswer()+ mem.getLastIp()+off+ pmem.getAddress());
		return ud.personReg(username, password, type, realname, sex, bir, sheng, city, telphone, email, question, answer, lastip, off, address);
		//return ud.personReg(mem.getUsername(), mem.getPassword(), mem.getType(), pmem.getRealname(), pmem.getSex(), pmem.getBir(), pmem.getSheng(), pmem.getCity(), pmem.getTelphone(), pmem.getEmail(), pmem.getQuestion(), pmem.getAnswer(), mem.getLastIp(), off, pmem.getAddress());
	}

	public List getRegInfo(String username) {
		// TODO Auto-generated method stub
		return ud.getRegInfo(username);
	}

	public int uppersonReg(String username,pmember pmem) {
		// TODO Auto-generated method stub
		//System.out.println("µΩSERVICE");
		return ud.uppersonReg(username, pmem.getRealname(), pmem.getSex(), pmem.getBir(), pmem.getSheng(), pmem.getCity(), pmem.getTelphone(), pmem.getEmail(), pmem.getQuestion(), pmem.getAnswer(), pmem.getAddress());
	}

	public String returnPwd(member mem,pmember pmem) {
		// TODO Auto-generated method stub
		return ud.returnPwd(mem.getUsername(),pmem.getQuestion(),pmem.getAnswer(),mem.getType());
	}

	
}
