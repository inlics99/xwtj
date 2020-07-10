package com.service.admin.impl;

import java.util.List;

import com.dao.admin.Affiche;
import com.entity.affiche;
import com.service.admin.afficheService;

public class afficheServiceImpl implements afficheService {
	Affiche aff=new com.dao.admin.impl.Affiche();
	public int addAffiche(affiche affiche) {
		// TODO Auto-generated method stub
		return aff.addAffiche(affiche.getTitle(), affiche.getContent(), affiche.getAdder(), affiche.getIfhide());
	}

	public int updateAffiche(affiche affiche) {
		// TODO Auto-generated method stub
		return aff.updateAffiche(affiche.getId(), affiche.getTitle(), affiche.getContent(), affiche.getAdder(), affiche.getIfhide());
	}

	public int delAffiche(int[] id) {
		// TODO Auto-generated method stub
		return aff.delAffiche(id);
	}

	public int hideAffiche(int id) {
		// TODO Auto-generated method stub
		return aff.hideAffiche(id);
	}

	public List getOneAffiche(int id) {
		// TODO Auto-generated method stub
		return aff.getOneAffiche(id);
	}

	public List getAllAffiche() {
		// TODO Auto-generated method stub
		return aff.getAllAffiche();
	}

	public List getAllAfficheManage() {
		// TODO Auto-generated method stub
		return aff.getAllAfficheManage();
	}

}
