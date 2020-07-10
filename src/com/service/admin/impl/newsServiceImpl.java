package com.service.admin.impl;

import java.util.List;

import com.dao.admin.newsDao;
import com.dao.admin.impl.newsDaoImpl;
import com.entity.news;
import com.entity.pl;
import com.service.admin.newsService;


public class newsServiceImpl implements newsService {
	
	newsDao newsDao=new newsDaoImpl();
	newsDaoImpl ndi=new newsDaoImpl();
	public int getMessageCount() {
		return newsDao.getMessageCount();
	}

	public int getPageCount() {
		return newsDao.getPageCount();
	}

	public List<List<String>> getMessage(int page) {
		// TODO Auto-generated method stub
		return newsDao.getMessage(page);
	}

	public int addNews(news news) {
		// TODO Auto-generated method stub
		return newsDao.addNews(news.getTitle(), news.getFenlei(), news.getContent(), news.getAdder(), news.getGjz());
	}

	public int updateNews(int id, String title, String fenlei, String content, String adder, String gjz) {
		// TODO Auto-generated method stub
		return newsDao.updateNews(id, title, fenlei, content, adder, gjz);
	}

	public int delNews(int id) {
		// TODO Auto-generated method stub
		System.out.println("Service="+id);
		return newsDao.delNews(id);
	}

	public List<Object> getOneNews(int id) {
		// TODO Auto-generated method stub
		//System.out.println(id);
		return newsDao.getOneNews(id);
	}

	public int upVisit(int id) {
		// TODO Auto-generated method stub
		return newsDao.upVisit(id);
	}

	public List<Object> getFenlei() {
		// TODO Auto-generated method stub
		return newsDao.getFenlei();
	}

	public int addFenlei(String title) {
		// TODO Auto-generated method stub
		return newsDao.addFenlei(title);
	}

	public int delFenlei(String id) {
		// TODO Auto-generated method stub
		return newsDao.delFenlei(id);
	}

	public int delMethod(int i,pl pl) {
		String sql=null;
		if(i==1) {
			sql="delete from pl where id='"+pl.getId()+"'";
			//return newsDao.delMethod(sql);
		}
		if(i==2){
			sql="insert into pl(nid,content,member,addtime) values('"+pl.getNid()+"','"+pl.getContent()+"','"+pl.getMember()+"','"+new java.util.Date().toLocaleString()+"')" ;
			//return newsDao.delMethod(sql);
		}
//		else {
//			return 0;
//		}
//		System.out.println(sql);
		return newsDao.delMethod(sql);
	}

	public List<Object> getPl(String nid) {
		// TODO Auto-generated method stub
		return newsDao.getPl(nid);
	}

	public List<List<String>> getMessageSS(int page, String sql2, int jj) {
		// TODO Auto-generated method stub
		return newsDao.getMessageSS(page, sql2, jj);
	}
	 public List<Object> getIndexNews(){
		 return newsDao.getIndexNews();
	 }
	 public List<Object> getAllNews(){
		 return newsDao.getAllNews();
	 }
	 public List<Object> get10HotNews(){
		 return newsDao.get10HotNews();
	 }
	 public List<Object> getaNews(){
		 return newsDao.getaNews();
	 }
	 public void setEVERYPAGENUM(int EVERYPAGENUM){
	     ndi.setEVERYPAGENUM(EVERYPAGENUM);
	 }
	 public int getMessageCountSs(String sql) {
		 return ndi.getMessageCountSs(sql);
	 }
	 public int getPlPagecount() {
		 return ndi.getPlPagecount();
	 }
//	 public List<Object> get4News(){
//		 return ndi.get4News();
//	 }
}
