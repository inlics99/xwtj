package com.dao.user;
//用户
import java.util.List;

public interface userDao {
	 public int checkRegName(String username);//检查是否重名
	 public int editPassword(String username,String oldpwd,String newpwd);//修改密码
	 public int memberLogin(String username,String password,String type);//登录
	 public String getLastTimeIP(String username);//登录信息
	 public int upmemberLogin(String username,String lastip );//更新登陆信息
	 public String getLogintimes(String username);//本次登录时间,登录次数
	 public int personReg(String username,String password,String type,String realname,String sex,String bir,
				String sheng,String city,String telphone,String email,String question,String answer,String lastip,int off,String address);//会员注册
	 public List getRegInfo(String username);//某会员资料
	 public int uppersonReg(String username,String realname,String sex,String bir,String sheng,String city,String telphone,String email,String question,String answer,String address);//修改会员资料
	 
	 public String returnPwd(String username,String question,String answer,String type);//
	 public int findPwd(String username);//
}
