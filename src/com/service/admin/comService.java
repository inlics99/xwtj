package com.service.admin;

import java.util.List;

import com.entity.COM;

public interface comService {
	public int getMessageCount(String sql);//得到信息总数                    
	public int getPageCount(); //得到共多少页（根据每页要显示几条信息）
	 public List getMessage(int page,String sql2,int rr);//得到每页要显示的信息
	
	 public int comUp(COM coms,int i);
	 public List getCom(String sql,int row);
//	 public List get1Com(String sql,int row);
	 public String getString(String sql);
//	 public String getString2(String sql);
//	 public int getCount(String sql);
//	 public float getFloat(String sql);
}
