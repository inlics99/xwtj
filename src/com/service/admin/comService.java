package com.service.admin;

import java.util.List;

import com.entity.COM;

public interface comService {
	public int getMessageCount(String sql);//�õ���Ϣ����                    
	public int getPageCount(); //�õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
	 public List getMessage(int page,String sql2,int rr);//�õ�ÿҳҪ��ʾ����Ϣ
	
	 public int comUp(COM coms,int i);
	 public List getCom(String sql,int row);
//	 public List get1Com(String sql,int row);
	 public String getString(String sql);
//	 public String getString2(String sql);
//	 public int getCount(String sql);
//	 public float getFloat(String sql);
}
