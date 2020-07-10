package com.dao.admin;
//���Ź���
import java.util.List;

public interface newsDao {
	public int getMessageCount();//�õ���Ϣ����
	public int getPageCount();//�õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
	public List<List<String>> getMessage(int page) ;//�õ�ÿҳҪ��ʾ����Ϣ
	 public int addNews(String title,String fenlei,String content,String adder,String gjz);//add news
	 public int updateNews(int id,String title,String fenlei,String content,String adder,String gjz);//update news
	 public int delNews(int id);//delete news
	 public List<Object> getOneNews(int id);//ĳһ������
	 public List<Object> getIndexNews();//��ҳ10������
	 public List<Object> getAllNews();//ǰ̨����ҳ�����б�
	 public int upVisit(int id);//���µ����
	 public List<Object> getFenlei();//��ȡ������Ϣ
	 public int addFenlei(String title);//��ӷ���
	 public int delFenlei(String id);//ɾ������
	
	 public int delMethod(String sql);
	 
	 public List<Object> getPl(String nid);//��ȡ����
	 
	 public List<List<String>> getMessageSS(int page,String sql2,int jj); //�õ�ÿҳҪ��ʾ����Ϣ
	 
	 public List<Object> get10HotNews();//��ȡ5����������
	 public List<Object> getaNews();
	 public int getMessageCountSs(String sql);//�õ���Ϣ����
}
