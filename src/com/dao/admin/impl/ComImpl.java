package com.dao.admin.impl;
/**
 * ͨ�÷�����
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dao.admin.Com;
import com.utils.Constant;
import com.utils.DAO;

public class ComImpl implements Com {
	private List list;
	private ResultSet rs = null;
	private int EVERYPAGENUM = 2;
	private int count = -1;
	private int qq = 0;
	
	//����ʱ�����
	String date1=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	//��ҳ��ѯ������ʾ����
	public void setEVERYPAGENUM(int EVERYPAGENUM){
    	this.EVERYPAGENUM=EVERYPAGENUM;
    }
	
	DAO dao=new DAO(); 
	//��ȡ��Ϣ��������
	public int getMessageCount(String sql) {
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
	//��ȡҳ������
	public int getPageCount() {
		 if (count % EVERYPAGENUM == 0) {
	            return count / EVERYPAGENUM;
	        } else {
	            return count / EVERYPAGENUM + 1;
	        }
	}
	//ҳ���ȡ��Ϣ����
	public List getMessage(int page, String sql2, int rr) {
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
                    for(int cc=1;cc<=rr;cc++){
                    	list2.add(rs.getString(cc));
                    }
    				list.add(list2);
                } else {
                    break; //���ٿ�ѭ����ʱ��
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
	//ҳ�������Ϣ����
	public int comUp(String sql) {
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
	//��ȡ���������෽��
	public List getCom(String sql, int row) {
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			while(rs.next()){
				List list2 = new ArrayList();
				for(int i=1;i<=row;i++){
					list2.add(rs.getString(i));
				}
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

//	public List get1Com(String sql, int row) {
//		list = new ArrayList();
//		dao.open();
//		try{
//			rs = dao.executeQuery(sql);
//			if(rs.next()){
//				for(int i=1;i<=row;i++){
//					list.add(rs.getString(i));
//				}
//			}
//			return list;
//		}catch(Exception e){
//			e.printStackTrace();
//			return list;
//		}finally{
//			dao.close();
//		}
//	}
	//��ȡ��ҳ���ŷ���ı�ͷ��
	public String getString(String sql) {
		list = new ArrayList();
		dao.open();
		try{
			rs = dao.executeQuery(sql);
			if(rs.next())
			return rs.getString(1);
			else return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.close();
		}
	}
//
//	public String getString2(String sql) {
//		list = new ArrayList();
//		dao.open();
//		try{
//			rs = dao.executeQuery(sql);
//			if(rs.next())
//			return rs.getString(1);
//			else return "";
//		}catch(Exception e){
//			e.printStackTrace();
//			return "";
//		}finally{
//			dao.close();
//		}
//	}

//	public int getCount(String sql) {
//		dao.open();
//		try{
//			rs = dao.executeQuery(sql);
//			rs.next();
//			return rs.getInt(1);
//		}catch(Exception e){
//			e.printStackTrace();
//			return 0;
//		}finally{
//			dao.close();
//		}
//	}
//
//	public float getFloat(String sql) {
//		dao.open();
//		try{
//			rs = dao.executeQuery(sql);
//			rs.next();
//			return rs.getInt(1);
//		}catch(Exception e){
//			e.printStackTrace();
//			return 0;
//		}finally{
//			dao.close();
//		}
//	}
	
}
