package com.dao.admin;
//新闻功能
import java.util.List;

public interface newsDao {
	public int getMessageCount();//得到信息总数
	public int getPageCount();//得到共多少页（根据每页要显示几条信息）
	public List<List<String>> getMessage(int page) ;//得到每页要显示的信息
	 public int addNews(String title,String fenlei,String content,String adder,String gjz);//add news
	 public int updateNews(int id,String title,String fenlei,String content,String adder,String gjz);//update news
	 public int delNews(int id);//delete news
	 public List<Object> getOneNews(int id);//某一个新闻
	 public List<Object> getIndexNews();//首页10条新闻
	 public List<Object> getAllNews();//前台新闻页新闻列表
	 public int upVisit(int id);//更新点击率
	 public List<Object> getFenlei();//获取分类信息
	 public int addFenlei(String title);//添加分类
	 public int delFenlei(String id);//删除分类
	
	 public int delMethod(String sql);
	 
	 public List<Object> getPl(String nid);//获取评论
	 
	 public List<List<String>> getMessageSS(int page,String sql2,int jj); //得到每页要显示的信息
	 
	 public List<Object> get10HotNews();//获取5条热门新闻
	 public List<Object> getaNews();
	 public int getMessageCountSs(String sql);//得到信息总数
}
