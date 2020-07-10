package com.dao.user.impl;
/**
 * 管理员登录 增删改查方法
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dao.user.manager;
import com.utils.Constant;
import com.utils.DAO;

public class managerImpl implements manager {
	private List list;
	private ResultSet rs = null;
	private int EVERYPAGENUM = 2;
	private int count = -1;
	private int qq = 0;
	private String sql="select count(*) from fz_adminlog";
	private String sql2="select * from fz_adminlog order by id desc ";
	//声明时间变量
	String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	//分页查询设置显示数
	public void setEVERYPAGENUM(int EVERYPAGENUM){
    	this.EVERYPAGENUM=EVERYPAGENUM;
    }
	
	DAO dao=new DAO();
	//获取信息总数
	public int getMessageCount() {
		 dao.open();
	        try { 
	            rs = dao.executeQuery(sql);
	            rs.next();
	            count = rs.getInt(1);
	            return count;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return -1;
	        } finally {
	            dao.close();
	        }
	}
	//获取页数总数
	public int getPageCount() {
		 if (count % EVERYPAGENUM == 0) {
	            return count / EVERYPAGENUM;
	        } else {
	            return count / EVERYPAGENUM + 1;
	        }
	}
	//获取管理员信息
	public List getMessage(int page) {
		dao.open();
        List list = new ArrayList();
        try {
            rs = dao.executeQuery(sql2);
            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
                rs.next();
            }
            for (int t = 0; t < EVERYPAGENUM; t++) {
                if (rs.next()) {
                    qq++;
                    List list2=new ArrayList();
                    list2.add(rs.getString("id"));
    				list2.add(rs.getString("username"));
    				list2.add(rs.getString("password"));
    				list2.add(rs.getString("logintime"));
    				list2.add(rs.getString("loginip"));
    				list2.add(rs.getString("useros"));
    				list2.add(rs.getString("ok"));
    				list.add(list2);
                } else {
                    break; //减少空循环的时间
                }
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            dao.close();
        }
	}
	//更新登录次数
	public int adminLogin(String username, String md5password, String password, String loginip, String useros) {
		String sql = "select * from fz_admin where username = '"+username+"' and isuse='1'";
		String sql4 = "update fz_admin set logintimes = logintimes+1 where username = '"+username+"' ";
			String pwd;
			dao.open();
			try{
				rs = dao.executeQuery(sql);
				if(rs.next()){
					pwd = rs.getString("password");
					if(pwd.trim().equals(md5password)){
						//dbo.executeUpdate(sql2);
						dao.executeUpdate(sql4);
						return Constant.SUCCESS;
					}
					else{
						//dbo.executeUpdate(sql3);
						return Constant.PASSWORD_ERROR;
					}
				}
				else{
					//dbo.executeUpdate(sql3);
					return Constant.NAME_ERROR;
				}			
			}catch(Exception e){
				e.printStackTrace();
				return Constant.SYSTEM_ERROR;
			}finally{
				dao.close();
			}	
	}
	//管理员验证登录方法
	public List getAdminInfo(String username) {
		String sql = "select * from fz_admin where username='"+username+"' ";
		dao.open();
		list = new ArrayList();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			list.add(rs.getString("username"));
			list.add(rs.getString("flag"));
			list.add(rs.getString("logintimes"));
			list.add(date);
			list.add(rs.getString("quanxian"));
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}
	//修改密码
	public int editPassword(String username, String oldpwd, String newpwd) {
		String sql="select * from fz_admin where username = '"+username+"' and password = '"+oldpwd+"'";
		String sql2="update fz_admin set password = '"+newpwd+"' where username = '"+username+"'";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next()){
				int i = dao.executeUpdate(sql2);
				if(i == 1){
					return Constant.SUCCESS;
				}
				else{
					return Constant.SYSTEM_ERROR;
				}
			}
			else{
				return Constant.PASSWORD_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//增加管理员
	public int addManager(String username, String password, String type, String isuse) {
		String sql = "insert into fz_admin(username,password,creattime,flag,isuse,logintimes,quanxian) values('"+username+"','"+password+"','"+date+"','"+type+"','"+isuse+"','0','111')";
		String sql2 = "select * from fz_admin where username = '"+username+"'";
		dao.open();
		try{
			rs = dao.executeQuery(sql2);
			if(rs.next()){
				return Constant.SAME_NAME;
			}
			else{
				int i = dao.executeUpdate(sql);
				if(i == 1)return Constant.SUCCESS;
				else return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//修改管理员信息
	public int updateManager(String username, String password, String type, String isuse) {
		String sql;
		if(password.equals("")){
			sql = "update fz_admin set flag = '"+type+"' ,isuse = '"+isuse+"' where username = '"+username+"'";
		}
		else{
			sql = "update fz_admin set password = '"+password+"' ,flag = '"+type+"' ,isuse = '"+isuse+"' where username = '"+username+"'";
		}
		dao.open();
		try{
			int i = dao.executeUpdate(sql);
			if(i == 1)return Constant.SUCCESS;
			else return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//获取所有管理员信息
	public List getAllManager() {
		String sql = "select * from fz_admin where flag !='1' order by id asc";
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List list2 = new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
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
	//删除管理员方法
	public int delManager(int id) {
		String sql = "delete from fz_admin where id = '"+id+"'";
		dao.open();
		try{
			int i = dao.executeUpdate(sql);
			if(i == 1)return Constant.SUCCESS;
			else return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}

//	public int delLog(int[] id) {
//		dao.open();
//		try{
//			for(int i = 0;i<id.length;i++){
//				dao.executeUpdate("delete from  fz_adminlog  where  id = '"+id[i]+"'");			
//			}
//			return Constant.SUCCESS;
//		}catch(Exception e){
//			e.printStackTrace();
//			return Constant.SYSTEM_ERROR;
//		}finally{
//			dao.close();
//		}
//	}
	
}
