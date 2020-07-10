package com.service.admin.impl;

import java.util.List;

import com.dao.admin.System;
import com.dao.admin.impl.SystemImpl;
import com.service.admin.systemService;

public class systemServiceImpl implements systemService {
	System sys=new SystemImpl();
	public int updateSystem(String sql) {
		return sys.updateSystem(sql);
	}

	public List getSystem() {
		// TODO Auto-generated method stub
		return sys.getSystem();
	}

	public List getSiteInfo() {
		// TODO Auto-generated method stub
		return sys.getSiteInfo();
	}

	public String getDir() {
		// TODO Auto-generated method stub
		return sys.getDir();
	}

}
