package com.dao.admin;

import java.util.List;

public interface Com {
	public int getMessageCount(String sql);//�õ���Ϣ����                    
	public int getPageCount(); //�õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
	 public List getMessage(int page,String sql2,int rr);//�õ�ÿҳҪ��ʾ����Ϣ
	
	 public int comUp(String sql);
	 public List getCom(String sql,int row);
//	 public List get1Com(String sql,int row);
	 public String getString(String sql);
//	 public String getString2(String sql);
//	 public int getCount(String sql);
//	 public float getFloat(String sql);
	 public void setEVERYPAGENUM(int EVERYPAGENUM);
	 //public int getMessageCountSs(String sql);//�õ���Ϣ����
	 
	 
}
