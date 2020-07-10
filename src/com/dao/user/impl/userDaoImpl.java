package com.dao.user.impl;
/**
 * �û���ɾ�Ĳ� ͨ�÷���
 */
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dao.user.userDao;
import com.utils.CheckCode;
import com.utils.Constant;
import com.utils.MD5;
import com.utils.DAO;

public class userDaoImpl implements userDao {
	private List list;
	private ResultSet rs;
	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	DAO dao=new DAO();
	//����Ƿ�����
	public int checkRegName(String username) {
		String sql = "select * from member where username='"+username+"'";
    	dao.open();
		try{
			
				rs = dao.executeQuery(sql);
				if(rs.next()){
					return Constant.SAME_NAME;
				}
				else{
					return Constant.SUCCESS;
				}	
							
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//�޸�����
	public int editPassword(String username, String oldpwd, String newpwd) {
		String sql="select * from member where username = '"+username+"' and password = '"+oldpwd+"'";
		String sql2="update member set password = '"+newpwd+"' where username = '"+username+"'";
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
	//�û���¼��֤
	public int memberLogin(String username, String password, String type) {
		password=MD5.MD5(password);
		String sql = "select password from member where username='"+username+"' and type='"+type+"' and ifuse='1' ";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next()){//����и��û���
				String str = rs.getString("password");
				if(str.trim().equals(password)){
					//dbo.executeUpdate(sql2);
					return Constant.SUCCESS;
				}
				else{
					return Constant.PASSWORD_ERROR;
				}
			}
			else{//���û��
				return Constant.NAME_ERROR;
			}
		}catch(Exception e){
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}	
	}
	//��ȡ����¼��ַ��Ϣ
	public String getLastTimeIP(String username) {
		String sql = "select lasttime,lastip from member where username='"+username+"'";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			String str=rs.getString(1)+"/"+rs.getString(2);
			return str;
		}catch(Exception e){
			return null;
		}finally{
			dao.close();
		}	
	}
	//�����û���¼��Ϣ
	public int upmemberLogin(String username, String lastip) {
		String sql = "update member set logintimes=logintimes+1,lasttime='"+date+"',lastip='"+lastip+"' where username='"+username+"' ";
		dao.open();
		try{
			int i = dao.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}	
	}
	//���µ�¼����
	public String getLogintimes(String username) {
		String sql = "select lasttime,logintimes from member where username='"+username+"'";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			String str=rs.getString(1)+"/"+rs.getString(2);
			return str;
		}catch(Exception e){
			return null;
		}finally{
			dao.close();
		}	
	}
	//�����޸ĸ�����Ϣ
	public int personReg(String username, String password, String type, String realname, String sex, String bir,
			String sheng, String city, String telphone, String email, String question, String answer, String lastip,
			int off, String address) {
		password=MD5.MD5(password);
		String sql = "insert into member(username,password,type,regtime,ifuse,logintimes,lasttime,lastip)" +
		" values('"+username+"','"+password+"','"+type+"','"+date+"','"+off+"','0','"+date+"','"+lastip+"') ";
		dao.open();
		try{
			int i = dao.executeUpdate(sql);
			if(i == 1){
				rs = dao.executeQuery("select id from member where username='"+username+"'");
				rs.next();
				int mid = rs.getInt(1);
				String sql2 = "insert into pmember(mid,realname,sex,bir,sheng,city,telphone,email,question,answer,address)" +
								"values('"+mid+"','"+realname+"','"+sex+"','"+bir+"','"+sheng+"','"+city+"','"+telphone+"','"+email+"','"+question+"','"+answer+"','"+address+"') ";
				System.out.println(sql2);
				int j = dao.executeUpdate(sql2);
				if(j == 1)
					return Constant.SUCCESS;
				else
					return Constant.SYSTEM_ERROR;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			System.out.println("ϵͳ����");
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}

		
	}
	
	//���û�����ȡ�û���ϸ��Ϣ �û�����ʹ��
	public List getRegInfo(String username) {
		String sql = "select * from pmember where mid=(select id from member where username='"+username+"') ";
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			rs.next();
			list.add(rs.getString("mid"));//0
			list.add(rs.getString("realname"));//1
			list.add(rs.getString("sex"));//2
			list.add(rs.getString("bir"));//3
			list.add(rs.getString("sheng"));//4
			list.add(rs.getString("city"));//5
			list.add(rs.getString("telphone"));//6
			list.add(rs.getString("email"));//7
			list.add(rs.getString("question"));//8
			list.add(rs.getString("answer"));//9
			list.add(rs.getString("address"));//9
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}	
	}
	//�޸��û���ϸ��Ϣ
	public int uppersonReg(String username, String realname, String sex, String bir, String sheng, String city,
			String telphone, String email, String question, String answer, String address) {
		String sql = "select id from member where username='"+username+"'";
		
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			
			if(rs.next()){
				int mid = rs.getInt(1);
				String sql2 = "update pmember set realname='"+realname+"',sex='"+sex+"',bir='"+bir+"',sheng='"+sheng+"',city='"+city+"',telphone='"+telphone+"'," +
						"email='"+email+"',question='"+question+"',answer='"+answer+"',address='"+address+"' where mid='"+mid+"' ";
				
				int i = dao.executeUpdate(sql2);
				if(i == 1)
					return Constant.SUCCESS;
				else
					return Constant.SYSTEM_ERROR;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}	
	}
	
	//�һ�����
	public String returnPwd(String username, String question, String answer, String type) {
		int i=this.findPwd(username);//��ѯ�Ƿ�����û������û���δ����
		if(i!=0){
			if(type.equals("person")){
				type="pmember";
			}
			else{
				type="cmember";
			}
			String sql ="select * from "+type+" where mid='"+i+"' and question='"+question+"' and answer='"+answer+"'";
			dao.open();
			try{
				rs = dao.executeQuery(sql);
				if(rs.next()){
					String yzm=new CheckCode().getCheckCode()+"123";
					String pwd=MD5.MD5(yzm);
					//System.out.println("��֤��:"+yzm);
					//System.out.println("pwd:"+pwd);
					int k=dao.executeUpdate("update member set password='"+pwd+"' where username='"+username+"'");
					if(k==1){
						return yzm;
					}
					else{System.out.print("aaaaaaaaaaaaaa");
						return "error";
					}
				}
				else{
					return "error";
				}
			}catch(Exception e){
				e.printStackTrace();
				return "error";
			}finally{
				dao.close();
			}		
		}
		else{
			return "nameerror";
		}
	}
	//��ѯ�Ƿ�����û������û���δ����
	public int findPwd(String username) {
		String sql="select id from member where username='"+username+"'";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.close();
		}
	}
	
	
	
}
