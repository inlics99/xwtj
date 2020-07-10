package com.dao.admin.impl;
/**
 * 地址管理类
 * 为了防止上传服务器后找不到路径
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.admin.System;
import com.utils.Constant;
import com.utils.DAO;

public class SystemImpl implements System {

	private List list;
	private ResultSet rs;
	
	DAO dao =new DAO();
	//修改路径
	public int updateSystem(String sql) {
		dao.open();
		try{
			int i = dao.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//获取路径
	public List getSystem() {
		String sql = "select * from fz_system ";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			list = new ArrayList();
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			list.add(rs.getString(4));
			list.add(rs.getString(5));
			list.add(rs.getString(6));
			list.add(rs.getString(7));
			list.add(rs.getString(8));
			list.add(rs.getString(9));
			list.add(rs.getString(10));
			list.add(rs.getString(11));
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}
	//获取网站信息
	public List getSiteInfo() {
		String sql = "select * from fz_system ";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			list = new ArrayList();
			list.add(rs.getString("sitename")); //0
			list.add(rs.getString("url")); //1
			list.add(rs.getString("keyword")); //2
			list.add(rs.getString("description")); //3
			list.add(rs.getString("email")); //4
			list.add(rs.getString("state")); //5
			list.add(rs.getString("reasons")); //6
			list.add(rs.getString("record")); //7
			list.add(rs.getString("copyright")); //8
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}
	//获取地址信息
	public String getDir() {
		String sql = "select dir from fz_system ";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			String dir = rs.getString(1);
			return dir;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.close();
		}
	}

}
