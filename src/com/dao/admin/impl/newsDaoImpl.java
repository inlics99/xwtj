package com.dao.admin.impl;
/**
 * ���Ź�����
 */
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dao.admin.newsDao;
import com.utils.Constant;
import com.utils.DAO;

public class newsDaoImpl implements newsDao {

	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	private List list;
	private ResultSet rs = null;
	
	//���ö����ŷ�ҳ
	private int EVERYPAGENUM = 10;//ÿҳ��ʾ����������
	private int count = -1;//��ȡ������������
	private int qq = 0;//��������
	private String sql="select count(*) from fz_news";
	private String sql2="select * from fz_news order by id desc";
	//����ÿҳ��ʾ����������
	public void setEVERYPAGENUM(int EVERYPAGENUM){
    	this.EVERYPAGENUM=EVERYPAGENUM;
    }
	
	
	DAO dao=new DAO();
	//��ȡ��������
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
	//��ȡ������ҳ��
	public int getPageCount() {
		if (count % EVERYPAGENUM == 0) {
            return count / EVERYPAGENUM;
        } else {
            return count / EVERYPAGENUM + 1;
        }
	}
	//��ȡ��������
	public int getPlPagecount() {
		dao.open();
		String sql="SELECT COUNT(*) FROM pl";
		try {
			rs = dao.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
			if (count % EVERYPAGENUM == 0) {
	            return count / EVERYPAGENUM;
	        } else {
	            return count / EVERYPAGENUM + 2;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally {
			dao.close();
			
		}
	}
	//��ȡ ��������
	public List<List<String>> getMessage(int page) {
	        dao.open();
	        List<List<String>> list = new ArrayList<List<String>>();
	        try {
	            rs = dao.executeQuery(sql2);
	            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
	                rs.next();
	            }
	            for (int t = 0; t < EVERYPAGENUM; t++) {
	                if (rs.next()) {
	                    qq++;
	                    List<String> list2=new ArrayList<String>();
	                    list2.add(rs.getString(1));
	    				list2.add(rs.getString(2));
	    				list2.add(rs.getString(3));
	    				list2.add(rs.getString(4));
	    				list2.add(rs.getString(5));
	    				list2.add(rs.getString(6));
	    				list2.add(rs.getString(7));
	    				list2.add(rs.getString(8));
	    				list.add(list2);
	                } else {
	                    break; //���ٿ�ѭ����ʱ��
	                }
	                
	                
	                
	            }
	            return list;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return list;
	        } finally {
	            dao.close();
	        }
	}
	
	//��������
	public int addNews(String title, String fenlei, String content, String adder, String gjz) {
		String sql = "insert into fz_news (title,fenlei,content,addtime,adder,visit,gjz) " +
				"values ('"+title+"','"+fenlei+"','"+content+"','"+date+"','"+adder+"','0','"+gjz+"')";
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
	//�޸�����
	public int updateNews(int id, String title, String fenlei, String content, String adder, String gjz) {
		String sql = "update fz_news set title = '"+title+"',fenlei = '"+fenlei+"',content='"+content+"',addtime='"+date+"'," +
				"adder='"+adder+"',gjz='"+gjz+"' where id = '"+id+"' ";
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
	//ɾ������
	public int delNews(int id) {
		dao.open();
		System.out.println("delete from  fz_news  where  id = '"+id+"'");
		try{
			dao.executeUpdate("delete from  fz_news  where  id = '"+id+"'");				
			return Constant.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dao.close();
		}
	}
	//ɾ���ļ�
	public void del(String filepath) {
		try{
			File f = new File(filepath);//�����ļ�·��        
			if(f.exists()){//�ж����ļ�����Ŀ¼
			    f.delete();//�ݹ����
			}
		}catch(Exception e){
			
		}
	}

	//��ѯ���ȡĳһ������
	public List<Object> getOneNews(int id) {
		String sql = "select * from fz_news where id = '"+id+"'";
		list = new ArrayList<Object>();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));//0id
				list.add(rs.getString(2));//1title
				list.add(rs.getString(3));//2content
				list.add(rs.getString(4));//3addtime
				list.add(rs.getString(5));//4adder
				list.add(rs.getString(6));//4adder
				list.add(rs.getString(7));//4adder
				list.add(rs.getString(8));//4adder
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dao.close();
		}
	}

	//���µ����
	public int upVisit(int id) {
		dao.open();
		try{
			int i = dao.executeUpdate("update  fz_news set visit=visit+1  where  id = '"+id+"'");		
			if(i==1){
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

	//��ӷ���
	public int addFenlei(String title) {
		dao.open();
		try{
			int i = dao.executeUpdate("insert into fenlei(title,addtime) values('"+title+"','"+date+"')");		
			if(i==1){
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

	//ɾ������
	public int delFenlei(String id) {
		dao.open();
		try{
			int i = dao.executeUpdate("delete from fenlei where id='"+id+"'");		
			if(i==1){
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
	//��ȡ����
	public List<Object> getFenlei() {
		String sql = "select* from fenlei  order by id asc";
		list = new ArrayList<Object>();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List<String> list2=new ArrayList<String>();
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

	//����ɾ������
	public int delMethod(String sql) {
		dao.open();
		try{
			int i = dao.executeUpdate(sql);		
			if(i==1){
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
	//��ȡ����
	public List<Object> getPl(String nid) {
		list = new ArrayList<Object>();
		String sql="SELECT * FROM pl WHERE nid='"+nid+"' ORDER BY ADDTIME DESC";
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List<String> list2=new ArrayList<String>();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
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

	//��ҳͨ�ò�ѯ���� ��ѯ��ǰҳ�������
	public List<List<String>> getMessageSS(int page, String sql2, int jj) {
		dao.open();
        List<List<String>> list = new ArrayList<List<String>>();
        try {
            rs = dao.executeQuery(sql2);
            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
                rs.next();
            }
            for (int t = 0; t < EVERYPAGENUM; t++) {
                if (rs.next()) {
                    qq++;
                    List<String> list2=new ArrayList<String>();
                    for(int mm=1;mm<=jj;mm++){
                    	list2.add(rs.getString(mm));
                    }
    				list.add(list2);
                } else {
                    break; //���ٿ�ѭ����ʱ��
                }
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        } finally {
            dao.close();
        }
	}
	//��ȡ��ҳ��������
	public List<Object> getIndexNews() {
		String sql = "select id,title,addtime from fz_news  order by id desc  limit 0,10";
		list = new ArrayList<Object>();
		dao.open();
		try{
			rs = dao.executeQuery(sql);			
			while(rs.next()){
				List<String> list2 = new ArrayList<String>();
				list2.add(rs.getString("id"));
				list2.add(rs.getString("title"));
				list2.add(rs.getString("addtime"));
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
	//��ȡ��������
	public List<Object> getAllNews() {
		String sql = "select id,title,addtime  from fz_news   order by id desc ";
		list = new ArrayList<Object>();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List<String> list2 = new ArrayList<String>();
				list2.add(rs.getString("id"));
				list2.add(rs.getString("title"));
				list2.add(rs.getString("addtime"));
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
	//��ȡ��������,��������
	public List<Object> get10HotNews() {
		String sql = "select  * from fz_news order by visit desc limit 0,10 ";
		list = new ArrayList<Object>();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List<String> list2 = new ArrayList<String>();
				list2.add(rs.getString(1));//0id
				list2.add(rs.getString(2));//1title
				list2.add(rs.getString(3));//2content
				list2.add(rs.getString(4));//3addtime
				list2.add(rs.getString(5));//4adder
				list2.add(rs.getString(6));//4adder
				list2.add(rs.getString(7));//4adder
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
	//���·�������
	public List<Object> getaNews() {
		// TODO Auto-generated method stub
		String sql = "select  * from fz_news order by ADDTIME desc  limit 0,10";
		list = new ArrayList<Object>();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List<String> list2 = new ArrayList<String>();
				list2.add(rs.getString(1));//0id
				list2.add(rs.getString(2));//1title
				list2.add(rs.getString(3));//2content
				list2.add(rs.getString(4));//3addtime
				list2.add(rs.getString(5));//4adder
				list2.add(rs.getString(6));//4adder
				list2.add(rs.getString(7));//4adder
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
	//��ȡ �������,����,�Ƽ� ������ͨ�÷��� 
	public int getMessageCountSs(String sql) {
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
	
	
//	public List<Object> get4News() {
//		dao.open();
//		String sql="SELECT id,title  FROM fz_news ORDER BY visit DESC LIMIT 3";
//		list = new ArrayList<Object>();
//		try{
//			List list2=new ArrayList<Object>();
//			rs = dao.executeQuery(sql);
//			while(rs.next()){
//				list2.add(rs.getString(1));//0id
//				list2.add(rs.getString(2));//1title
//				list.add(list2);
//			}
//			return list;
//		}catch(Exception e){
//			e.printStackTrace();
//			return list;
//		}finally{
//			dao.close();
//		}
//	}
	
	
	
	
	


	
	
}
