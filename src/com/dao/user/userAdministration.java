package com.dao.user;
//�û�����
import java.util.List;

public interface userAdministration {
	//��ҳ��ѯ�û�
	public void setEVERYPAGENUM(int EVERYPAGENUM);//��ҳ��ѯ���и��˻�Ա
	public int getMessageCount();//�õ���Ϣ����
	public int getPageCount();//�õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
	public List getMessage(int page);//�õ�ÿҳҪ��ʾ����Ϣ
	//���������û�
//	public int getMessageCountUS();//�õ���Ϣ����
//	public List getMessageUS(int page);//�õ�ÿҳҪ��ʾ����Ϣ
	//���ж����û�
//	public int getMessageCountCL();//�õ���Ϣ����
//	public List getMessageCL(int page);//�õ�ÿҳҪ��ʾ����Ϣ
//	//����ע���û�
//	 public int getMessageCountTODAY();//�õ���Ϣ����
//	 public List getMessageTODAY(int page);//�õ�ÿҳҪ��ʾ����Ϣ
	 //����ɾ���û�
	 public int delMember(int id);//ɾ���û�
	 public int closeMember(int id);//�����û�
	 //��̨��ѯ��������  ��ѯ�û�����
//	 public String getType(int id); //��idΪ������ѯ�û�����
	 public List getMemberLogin(int id); //��idΪ���� ������Ա��½��Ϣ
	 public List getPerSonMember(int id);//��idΪ���� �������˻�Ա��Ϣ
	 public String getType(String name);//	���û���Ϊ������ѯ��Ա����
	 public int getID(String name); //���û���Ϊ������ѯ�û�id
	 public String getType(int id,String name);//���û��� idΪ������ѯ
	 public List getMemberByTime(String stime,String etime);//��ע��ʱ���ѯ
	 
	 
}
