package com.service.admin;

import java.util.List;

public interface systemService {
	public int updateSystem(String sql);//����ϵͳ��Ϣ
	public List getSystem();//��ȡ��վ��Ϣ
	public List getSiteInfo();//��ȡ��վ��Ϣ
	public String getDir();//��ȡϵͳ��ַ
}
