package com.service.admin;

import java.util.List;

import com.entity.affiche;

public interface afficheService {
	public int addAffiche(affiche affiche);//���ӹ���\
	public int updateAffiche(affiche affiche);//�޸Ĺ���
	public int delAffiche(int id[]);//ɾ������
	public int hideAffiche(int id);//��ʾ���ع���
	public List getOneAffiche(int id);//ͨ��id��ȡ����
	public List getAllAffiche();//��ҳ��ʾ���й���
	public List getAllAfficheManage();//��̨��ʾ���й���
}
