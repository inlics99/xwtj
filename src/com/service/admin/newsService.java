package com.service.admin;

import java.util.List;

import com.entity.news;
import com.entity.pl;

public interface newsService {
	public int getMessageCount();//得到信息总数
	public int getPageCount();//得到共多少页（根据每页要显示几条信息）
	public List<List<String>> getMessage(int page) ;//得到每页要显示的信息
	 public int addNews(news news);//add news
	 public int updateNews(int id,String title,String fenlei,String content,String adder,String gjz);//update news
	 public int delNews(int id);//delete news
	 public List<Object> getOneNews(int id);//修改某一个新闻
	 //public List<Object> getIndexNews();//首页10条新闻
	 //public List<Object> getAllNews();//前台新闻页新闻列表
	 public int upVisit(int id);//更新点击率
	 public List<Object> getFenlei();//获取分类信息
	 public int addFenlei(String title);//添加分类
	 public int delFenlei(String id);//删除分类
	
	 public int delMethod(int i,pl pl);
	 
	 public List<Object> getPl(String nid);//获取评论
	 
	 public List<List<String>> getMessageSS(int page,String sql2,int jj); //得到每页要显示的信息
	 
}
