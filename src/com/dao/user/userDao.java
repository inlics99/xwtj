package com.dao.user;
//�û�
import java.util.List;

public interface userDao {
	 public int checkRegName(String username);//����Ƿ�����
	 public int editPassword(String username,String oldpwd,String newpwd);//�޸�����
	 public int memberLogin(String username,String password,String type);//��¼
	 public String getLastTimeIP(String username);//��¼��Ϣ
	 public int upmemberLogin(String username,String lastip );//���µ�½��Ϣ
	 public String getLogintimes(String username);//���ε�¼ʱ��,��¼����
	 public int personReg(String username,String password,String type,String realname,String sex,String bir,
				String sheng,String city,String telphone,String email,String question,String answer,String lastip,int off,String address);//��Աע��
	 public List getRegInfo(String username);//ĳ��Ա����
	 public int uppersonReg(String username,String realname,String sex,String bir,String sheng,String city,String telphone,String email,String question,String answer,String address);//�޸Ļ�Ա����
	 
	 public String returnPwd(String username,String question,String answer,String type);//
	 public int findPwd(String username);//
}
