package com.service.user;
//�û�ע��
import java.util.List;

import com.entity.member;
import com.entity.pmember;

public interface memberService {
	 public int checkRegName(String username);//����Ƿ�����
	 public int editPassword(String username,String oldpwd,String newpwd);//�޸�����
	 public int memberLogin(String username,String password,String type);//��¼
	 public String getLastTimeIP(String username);//��¼��Ϣ
	 public int upmemberLogin(String username,String lastip );//���µ�½��Ϣ
	 public String getLogintimes(String username);//���ε�¼ʱ��,��¼����
	 public int personReg(String username,String password,String type,String realname,String sex,String bir,String sheng,String city,String telphone,String email,String question,String answer,String lastip,int off,String address);//��Աע��
	 public List getRegInfo(String username);//ĳ��Ա����
	 public int uppersonReg(String username,pmember pmem);//�޸Ļ�Ա����
	 
	 public String returnPwd(member mem,pmember pmem);//
}
