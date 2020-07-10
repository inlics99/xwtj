package com.action;

/**
 * 前台会员登陆 退出
 * 
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.user.memberService;
import com.service.user.impl.memberServiceImpl;
import com.utils.Constant;
import com.utils.Filter;

public class LoginAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constant.CONTENTTYPE);
		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		HttpSession session = request.getSession();
		memberService memberBean=new memberServiceImpl();
		String method = Filter.escapeHTMLTags(request.getParameter("method").trim());
		//网页头部会员登陆
		if(method.equals("HEADUSERLOGIN")){
			String reg_user = Filter.escapeHTMLTags(request.getParameter("reg_user").trim());
			String reg_pwd = Filter.escapeHTMLTags(request.getParameter("reg_pwd").trim());
			String reg_type = Filter.escapeHTMLTags(request.getParameter("reg_type").trim());
			String lastip = request.getRemoteAddr();
			int flag = memberBean.memberLogin(reg_user, reg_pwd, reg_type);
			//登陆成功
			if(flag == Constant.SUCCESS){
				String info = memberBean.getLastTimeIP(reg_user);
				int flag2 = memberBean.upmemberLogin(reg_user, lastip);
				if(flag2 == Constant.SUCCESS){
					session.setAttribute("member", reg_user);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					request.getRequestDispatcher("login1.jsp").forward(request, response);
				}
				else{
					session.setAttribute("member", reg_user);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					session.setAttribute("message", "登陆成功，登陆信息更新失败！");
					request.getRequestDispatcher("login1.jsp").forward(request, response);
				}
			}
			//用户名错误
			else if(flag == Constant.NAME_ERROR){
				request.setAttribute("reg_user", reg_user);
				request.setAttribute("message", "该用户名不存在或者已被管理员冻结！");
				request.getRequestDispatcher("login1.jsp").forward(request, response);
			}
			//密码错误
			else if(flag == Constant.PASSWORD_ERROR){
				request.setAttribute("reg_user", reg_user);
				request.setAttribute("message", "密码错误！");
				request.getRequestDispatcher("login1.jsp").forward(request, response);
			}
		}
		//登陆页面会员登陆
		else if(method.equals("PAGEUSERLOGIN")){
			String username = Filter.escapeHTMLTags(request.getParameter("username").trim());
			String password = Filter.escapeHTMLTags(request.getParameter("password").trim());
			String reg_type = Filter.escapeHTMLTags(request.getParameter("reg_type").trim());
			String lastip = request.getRemoteAddr();
			int flag = memberBean.memberLogin(username, password, reg_type);
			if(flag == Constant.SUCCESS){//登陆成功
				String info = memberBean.getLastTimeIP(username);
				int flag2 = memberBean.upmemberLogin(username, lastip);
				if(flag2 == Constant.SUCCESS){
					session.setAttribute("member", username);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					request.getRequestDispatcher("member/index.jsp").forward(request, response);
				}
				else{
					session.setAttribute("member", username);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					session.setAttribute("message", "登陆成功，登陆信息更新失败！");
					request.getRequestDispatcher("member/index.jsp").forward(request, response);
				}
			}
			//用户名错误
			else if(flag == Constant.NAME_ERROR){
				request.setAttribute("reg_user", username);
				request.setAttribute("message", "该用户名不存在！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			//密码错误
			else if(flag == Constant.PASSWORD_ERROR){
				request.setAttribute("reg_user", username);
				request.setAttribute("message", "密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		//从iframe页面退出登陆
		else if(method.equals("logout")){
			session.removeAttribute("member");
			session.removeAttribute("type");
			request.getRequestDispatcher("login1.jsp").forward(request, response);
		}
		//从网页退出登陆
		else if(method.equals("pagelogout")||method.equals("memberexit")){
			session.removeAttribute("member");
			session.removeAttribute("type");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
