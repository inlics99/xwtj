package com.service.admin;

import java.util.List;

public interface systemService {
	public int updateSystem(String sql);//更新系统信息
	public List getSystem();//获取网站信息
	public List getSiteInfo();//获取网站信息
	public String getDir();//获取系统地址
}
