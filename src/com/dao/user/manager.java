package com.dao.user;
//����Ա
import java.util.List;

public interface manager {
	 public int getMessageCount();//�õ���Ϣ����
	 public int getPageCount();//�õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
	 public List getMessage(int page);//�õ�ÿҳҪ��ʾ����Ϣ
	 public int adminLogin(String username,String md5password,String password,String loginip,String useros);//����Ա��¼ ���µ�¼���� д��¼��־
	 public List getAdminInfo(String username);//��ѯ����Ա��Ϣ
	 public int editPassword(String username,String oldpwd,String newpwd);//�޸Ĺ���Ա����
	 public int addManager(String username,String password,String type,String isuse);//���ӹ���Ա
	 public int updateManager(String username,String password,String type,String isuse);//�޸Ĺ���Ա��Ϣ
	 public List getAllManager();//��ȡ���й���Ա��Ϣ
	 public int delManager(int id);//ɾ������Ա
//	 public int delLog(int id[]);//delete login note
	 
}
