package com.dao.admin.impl;
/**
 * 管理首页公告
 */
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.utils.Constant;
import com.utils.DAO;

public class Affiche implements com.dao.admin.Affiche {

	private ResultSet rs;
	private List list;
	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	DAO dao=new DAO();
	
	//增加公告
	public int addAffiche(String title, String content, String adder, String ifhide) {
		String sql = "insert into fz_affiche (title,content,addtime,adder,ifhide) " +
				"values ('"+title+"','"+content+"','"+date+"','"+adder+"','"+ifhide+"')";
		dao.open();
		try{
			int i = dao.executeUpdate(sql);
			if(i == 1){
				return Constant.SUCCESS;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//修改公告
	public int updateAffiche(int id, String title, String content, String adder, String ifhide) {
		String sql = "update fz_affiche set title = '"+title+"',content='"+content+"',addtime='"+date+"'," +
				"adder='"+adder+"',ifhide='"+ifhide+"' where id = '"+id+"' ";
		dao.open();
		try{
			int i = dao.executeUpdate(sql);
			if(i == 1){
				return Constant.SUCCESS;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//删除公告
	public int delAffiche(int[] id) {
		dao.open();
		try{
			for(int i = 0;i<id.length;i++){
				dao.executeUpdate("delete from  fz_affiche  where  id = '"+id[i]+"'");			
			}
			return Constant.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//隐藏 显示公告
	public int hideAffiche(int id) {
		String sql = "update fz_affiche set ifhide='1' where id='"+id+"'";
		String sql2 = "update fz_affiche set ifhide='0' where id='"+id+"'";
		String sql3 = "select ifhide from fz_affiche where id='"+id+"'";
		dao.open();
		try{
			rs = dao.executeQuery(sql3);
			rs.next();
			int i = rs.getInt(1);
			if(i == 1){
				int flag = dao.executeUpdate(sql2);
				if(flag == 1)
					return Constant.SUCCESS;
				else
					return Constant.SYSTEM_ERROR;
			}
			else{
				int flag = dao.executeUpdate(sql);
				if(flag == 1)
					return Constant.SUCCESS;
				else
					return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//获取一条公告的数据
	public List getOneAffiche(int id) {
		String sql = "select * from fz_affiche where id = '"+id+"'";
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}
	//获取所有未隐藏的公告
	public List getAllAffiche() {
		String sql = "select id,content,addtime from fz_affiche where ifhide='1' order by addtime desc ";
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}
	//后台管理获取公告数据
	public List getAllAfficheManage() {
		String sql = "select id,title,addtime,adder,ifhide from fz_affiche order by addtime desc ";
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString("id"));
				list2.add(rs.getString("title"));
				list2.add(rs.getString("addtime"));
				list2.add(rs.getString("adder"));
				list2.add(rs.getString("ifhide"));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}

}
