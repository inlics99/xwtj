package com.dao.user.impl;
/**
 * 用户管理类
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dao.user.userAdministration;
import com.utils.Constant;
import com.utils.DAO;

public class userAdministrationImpl implements userAdministration {
	
	private List list;
	private ResultSet rs = null;
	private int EVERYPAGENUM = 2;
	private int count = -1;
	private int qq = 0;
	private String sql="select count(*) from member where type='person'";
	private String sql2="select * from member where type='person' order by id desc ";
	//声明时间变量
	String date1=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	DAO dao=new DAO();
	//获取分页信息
	public void setEVERYPAGENUM(int EVERYPAGENUM) {
		this.EVERYPAGENUM=EVERYPAGENUM;

	}
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
	//获取分页总数
	public int getPageCount() {
		  if (count % EVERYPAGENUM == 0) {
	            return count / EVERYPAGENUM;
	        } else {
	            return count / EVERYPAGENUM + 1;
	        }
	}
	//获取分页每页显示信息
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
    				list2.add(rs.getString("regtime"));
    				list2.add(rs.getString("ifuse"));
    				list2.add(rs.getString("logintimes"));
    				list2.add(rs.getString("lasttime"));
    				list2.add(rs.getString("lastip"));
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
	
//	public int getMessageCountUS() {
//		dao.open();
//        try { 
//            rs = dao.executeQuery("select count(*) from member where ifuse='1'");
//            rs.next();
//            count = rs.getInt(1);
//            return count;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return -1;
//        } finally {
//            dao.close();
//        }
//	}

//	public List getMessageUS(int page) {
//		dao.open();
//        List list = new ArrayList();
//        try {
//            rs = dao.executeQuery("select * from member where ifuse='1' order by id desc ");
//            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
//                rs.next();
//            }
//            for (int t = 0; t < EVERYPAGENUM; t++) {
//                if (rs.next()) {
//                    qq++;
//                   List list2=new ArrayList();
//                   list2.add(rs.getString("id"));
//    				list2.add(rs.getString("username"));
//    				list2.add(rs.getString("regtime"));
//    				list2.add(rs.getString("ifuse"));
//    				list2.add(rs.getString("logintimes"));
//    				list2.add(rs.getString("lasttime"));
//    				list2.add(rs.getString("lastip"));
//    				list2.add(rs.getString("type"));
//    				list.add(list2);
//                } else {
//                    break; //减少空循环的时间
//                }
//            }
//            return list;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        } finally {
//            dao.close();
//        }
//	}

//	public int getMessageCountCL() {
//		dao.open();
//        try { 
//            rs = dao.executeQuery("select count(*) from member where ifuse='0'");
//            rs.next();
//            count = rs.getInt(1);
//            return count;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return -1;
//        } finally {
//            dao.close();
//        }
//	}
//
//	public List getMessageCL(int page) {
//		dao.open();
//        List list = new ArrayList();
//        try {
//            rs = dao.executeQuery("select * from member where ifuse='0' order by id desc ");
//            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
//                rs.next();
//            }
//            for (int t = 0; t < EVERYPAGENUM; t++) {
//                if (rs.next()) {
//                    qq++;
//                   List list2=new ArrayList();
//                   list2.add(rs.getString("id"));
//    				list2.add(rs.getString("username"));
//    				list2.add(rs.getString("regtime"));
//    				list2.add(rs.getString("ifuse"));
//    				list2.add(rs.getString("logintimes"));
//    				list2.add(rs.getString("lasttime"));
//    				list2.add(rs.getString("lastip"));
//    				list2.add(rs.getString("type"));
//    				list.add(list2);
//                } else {
//                    break; //减少空循环的时间
//                }
//            }
//            return list;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        } finally {
//            dao.close();
//        }
//	}
//
//	public int getMessageCountTODAY() {
//		dao.open();
//        try { 
//            rs = dao.executeQuery("select count(*) from member where regtime between '"+date1+"' and '"+date+"'");
//            rs.next();
//            count = rs.getInt(1);
//            return count;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return -1;
//        } finally {
//            dao.close();
//        }
//	}
//
//	public List getMessageTODAY(int page) {
//		dao.open();
//        List list = new ArrayList();
//        try {
//            rs = dao.executeQuery("select * from member where regtime between '"+date1+"' and '"+date+"' order by id desc ");
//            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
//                rs.next();
//            }
//            for (int t = 0; t < EVERYPAGENUM; t++) {
//                if (rs.next()) {
//                    qq++;
//                   List list2=new ArrayList();
//                   list2.add(rs.getString("id"));
//    				list2.add(rs.getString("username"));
//    				list2.add(rs.getString("regtime"));
//    				list2.add(rs.getString("ifuse"));
//    				list2.add(rs.getString("logintimes"));
//    				list2.add(rs.getString("lasttime"));
//    				list2.add(rs.getString("lastip"));
//    				list2.add(rs.getString("type"));
//    				list.add(list2);
//                } else {
//                    break; //减少空循环的时间
//                }
//            }
//            return list;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        } finally {
//            dao.close();
//        }
//	}
	//删除用户
	public int delMember(int id) {
		dao.open();
		try{
			dao.executeUpdate("delete from  member where  id = '"+id+"'");
			return Constant.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//冻结 启用用户账号
	public int closeMember(int id) {
		String sql = "select ifuse from member where id='"+id+"' ";
		String sql2 = "update member set ifuse='0' where id='"+id+"'";
		String sql3 = "update member set ifuse='1' where id='"+id+"'";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next()){
				int ifuse=rs.getInt(1);
				if(ifuse == 1){
					int j = dao.executeUpdate(sql2);
					if(j == 1)
						return Constant.SUCCESS;
					else
						return Constant.SYSTEM_ERROR;
				}
				else{
					int j = dao.executeUpdate(sql3);
					if(j == 1)
						return Constant.SUCCESS;
					else
						return Constant.SYSTEM_ERROR;
				}
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
//	//以id为条件查询用户类型 
//	public String getType(int id) {
//		String sql = "select type from member where id='"+id+"'";
//    	dao.open();
//		try{
//			rs = dao.executeQuery(sql);
//			if(rs.next()){
//				String type = rs.getString(1);
//				return type;
//			}
//			else
//				return null;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally{
//			dao.close();
//		}
//	}
	//以id为条件 单条会员登陆信息
	public List getMemberLogin(int id) {
		String sql = "select * from member where id='"+id+"'";
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			list.add(rs.getString("username"));
			list.add(rs.getString("type"));
			list.add(rs.getString("regtime"));
			list.add(rs.getString("ifuse"));
			list.add(rs.getString("logintimes"));
			list.add(rs.getString("lasttime"));
			list.add(rs.getString("lastip"));
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}
	//以id为条件 单条个人会员信息
	public List getPerSonMember(int id) {
		String sql = "select * from pmember where mid='"+id+"'";
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			list.add(rs.getString("realname"));
			list.add(rs.getString("sex"));
			list.add(rs.getString("bir"));
			list.add(rs.getString("sheng"));
			list.add(rs.getString("city"));
			list.add(rs.getString("telphone"));
			list.add(rs.getString("email"));
			list.add(rs.getString("question"));
			list.add(rs.getString("answer"));
			list.add(rs.getString("address"));
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}
	//	以用户名为条件查询会员类型
	public String getType(String name) {
		String sql = "select type from member where username='"+name+"'";
    	dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next()){
				String type = rs.getString(1);
				return type;
			}
			else
				return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.close();
		}
	}
	//以用户名为条件查询用户id
	public int getID(String name) {
		String sql = "select id from member where username='"+name+"'";
    	dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next()){
				int id = rs.getInt(1);
				return id;
			}
			else
				return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.close();
		}
	}
	//以用户名 id为条件查询
	public String getType(int id, String name) {
		String sql = "select type from member where id='"+id+"' and username='"+name+"'";
    	dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next()){
				String type = rs.getString(1);
				return type;
			}
			else
				return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.close();
		}
	}
	//按注册时间查询
	public List getMemberByTime(String stime, String etime) {
		String sql = "select * from member where regtime between '"+stime+"' and '"+etime+" 23:59:59' ";
    	list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
                list2.add(rs.getString("id"));
 				list2.add(rs.getString("username"));
 				list2.add(rs.getString("regtime"));
 				list2.add(rs.getString("ifuse"));
 				list2.add(rs.getString("logintimes"));
 				list2.add(rs.getString("lasttime"));
 				list2.add(rs.getString("lastip"));
 				list2.add(rs.getString("type"));
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
