package com.dao.admin;
//ϵͳ��������
import java.util.List;

public interface System {
	public int updateSystem(String sql);//����ϵͳ��Ϣ
	public List getSystem();//��ȡ��վ��Ϣ
	public List getSiteInfo();//��ȡ��վ��Ϣ
	public String getDir();//��ȡϵͳ��ַ
}
