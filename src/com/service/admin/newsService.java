package com.service.admin;

import java.util.List;

import com.entity.news;
import com.entity.pl;

public interface newsService {
	public int getMessageCount();//�õ���Ϣ����
	public int getPageCount();//�õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
	public List<List<String>> getMessage(int page) ;//�õ�ÿҳҪ��ʾ����Ϣ
	 public int addNews(news news);//add news
	 public int updateNews(int id,String title,String fenlei,String content,String adder,String gjz);//update news
	 public int delNews(int id);//delete news
	 public List<Object> getOneNews(int id);//�޸�ĳһ������
	 //public List<Object> getIndexNews();//��ҳ10������
	 //public List<Object> getAllNews();//ǰ̨����ҳ�����б�
	 public int upVisit(int id);//���µ����
	 public List<Object> getFenlei();//��ȡ������Ϣ
	 public int addFenlei(String title);//��ӷ���
	 public int delFenlei(String id);//ɾ������
	
	 public int delMethod(int i,pl pl);
	 
	 public List<Object> getPl(String nid);//��ȡ����
	 
	 public List<List<String>> getMessageSS(int page,String sql2,int jj); //�õ�ÿҳҪ��ʾ����Ϣ
	 
}
