package com.dao.admin;

import java.util.List;

public interface Affiche {
	public int addAffiche(String title,String content,String adder,String i);//���ӹ���\
	public int updateAffiche(int id,String title,String content,String adder,String ifhide);//�޸Ĺ���
	public int delAffiche(int id[]);//ɾ������
	public int hideAffiche(int id);//��ʾ���ع���
	public List getOneAffiche(int id);//ͨ��id��ȡ����
	public List getAllAffiche();//��ҳ��ʾ���й���
	public List getAllAfficheManage();//��̨��ʾ���й���
	
}
