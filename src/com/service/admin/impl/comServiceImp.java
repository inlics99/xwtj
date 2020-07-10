package com.service.admin.impl;

import java.util.List;

import com.dao.admin.Com;
import com.dao.admin.impl.ComImpl;
import com.entity.COM;
import com.service.admin.comService;
import com.utils.Constant;

public class comServiceImp implements comService {
	Com com=new ComImpl();
	public int getMessageCount(String sql) {
		// TODO Auto-generated method stub
		return com.getMessageCount(sql);
	}

	public int getPageCount() {
		// TODO Auto-generated method stub
		return com.getPageCount();
	}

	public List getMessage(int page, String sql2, int rr) {
		// TODO Auto-generated method stub
		return com.getMessage(page, sql2, rr);
	}

	public int comUp(COM coms,int i) {
		// TODO Auto-generated method stub
		if(i==1) {
			String sql="insert into lj(mc,dz  ) values('"+coms.getMc()+"','"+coms.getDz()+"'  ) ";
			return com.comUp(sql);
		}else if(i==2) {
			String sql="update lj set mc='"+coms.getMc()+"',dz='"+coms.getDz()+"' where id='"+coms.getId()+"' ";
			return com.comUp(sql);
		}else if(i==3) {
			String sql="delete from lj where id='"+coms.getId()+"' ";
			return com.comUp(sql);
		}else if(i==4) {
			String sql="delete from keyword where id='"+coms.getId()+"' ";
			return com.comUp(sql);
		}else if(i==5) {
			String sql="insert into keyword(fenlei,title,member,sj) values('"+coms.getFenlei()+"','"+coms.getTitle()+"','"+coms.getMember()+"','"+coms.getSj()+"'  )";
			return com.comUp(sql);
		}
		else {
			return Constant.SYSTEM_ERROR;
		}
	}
	public int comUp2(String sql) {
		return com.comUp(sql);
	}
	public List getCom(String sql, int row) {
		// TODO Auto-generated method stub
		return com.getCom(sql, row);
	}

//	public List get1Com(String sql, int row) {
//		// TODO Auto-generated method stub
//		return com.get1Com(sql, row);
//	}

	public String getString(String sql) {
		// TODO Auto-generated method stub
		return com.getString(sql);
	}

//	public String getString2(String sql) {
//		// TODO Auto-generated method stub
//		return com.getString2(sql);
//	}

//	public int getCount(String sql) {
//		// TODO Auto-generated method stub
//		return com.getCount(sql);
//	}
//
//	public float getFloat(String sql) {
//		// TODO Auto-generated method stub
//		return com.getFloat(sql);
//	}
	public void setEVERYPAGENUM(int EVERYPAGENUM) {
		com.setEVERYPAGENUM(EVERYPAGENUM);
	}
}
