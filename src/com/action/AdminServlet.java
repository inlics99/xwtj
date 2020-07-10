package com.action;
/**
 * 管理员登陆 增加 修改 删除 删除
 */
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.admin.systemService;
import com.service.admin.impl.systemServiceImpl;
import com.service.user.managerService;
import com.service.user.impl.managerServiceImpl;
import com.utils.Constant;
import com.utils.MD5;

public class AdminServlet extends HttpServlet {
	public AdminServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constant.CONTENTTYPE);
		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		try{
			String method=request.getParameter("method").trim();
			managerService loginbean=new managerServiceImpl();
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1200);//session会话维持20分钟超时
			systemService systembean=new systemServiceImpl();
			String sysdir = systembean.getDir();//获取常量
			if(method.equals("one")){//管理员登录
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if(username == null||username.trim().equals("")){
					request.setAttribute("message", "请正确输入用户名！");
					request.getRequestDispatcher(sysdir+"/login.jsp").forward(request, response);
				}
				else if(password == null||password.trim().equals("")){
					request.setAttribute("message", "请输入密码！");
					request.getRequestDispatcher(sysdir+"/login.jsp").forward(request, response);
				}
				else{
					String md5password = MD5.MD5(password);
					String agent = request.getHeader("user-agent"); 
					StringTokenizer st = new StringTokenizer(agent,";"); 
					String useros=st.nextToken();
					String loginip = request.getRemoteAddr();			
					int flag = loginbean.adminLogin(username,md5password, password,useros,loginip);
					switch (flag){
						case Constant.SUCCESS:
							List list = loginbean.getAdminInfo(username);
							session.setAttribute("user", username);
							session.setAttribute("list", list);
							request.getRequestDispatcher(sysdir+"/").forward(request, response);
							break;
						case Constant.NAME_ERROR:
							request.setAttribute("message", "用户名错误！请确认管理权限！");
							request.getRequestDispatcher(sysdir+"/login.jsp").forward(request, response);
							break;
						case Constant.PASSWORD_ERROR:
							request.setAttribute("message", "密码错误，请确认管理权限！");
							request.getRequestDispatcher(sysdir+"/login.jsp").forward(request, response);
							break;
					}
				}
			}
			else if(method.equals("editpwd")){//修改密码
				String username2 = (String)session.getAttribute("user");
				if(username2 == null){
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else{
					String oldpwd = MD5.MD5(request.getParameter("oldpwd").trim());
					String newpwd = MD5.MD5(request.getParameter("newpwd").trim());
					String username = (String)session.getAttribute("user");
					int flag = loginbean.editPassword(username, oldpwd, newpwd);
					switch (flag){
						case Constant.SUCCESS:
							request.setAttribute("message", "密码修改成功！");
							request.getRequestDispatcher(sysdir+"/system/editpwd.jsp").forward(request, response);
							break;
						case Constant.PASSWORD_ERROR:
							request.setAttribute("message", "原始密码错误，请确认权限！");
							request.getRequestDispatcher(sysdir+"/system/editpwd.jsp").forward(request, response);
							break;
						case Constant.SYSTEM_ERROR:
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/system/editpwd.jsp").forward(request, response);
							break;
					}
				}		
			}
			else if(method.equals("exit")){//退出登录
				String username2 = (String)session.getAttribute("user");
				if(username2 == null){
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else{
					session.removeAttribute("user");
					session.removeAttribute("list");
					System.gc();
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}			
			}
			else if(method.equals("manager")){//增加管理员
				String username2 = (String)session.getAttribute("user");
				if(username2 == null){
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else{
					String ra = request.getParameter("type").trim();
					if(ra.equals("add")){
						String username = request.getParameter("username").trim();
						String password = MD5.MD5(request.getParameter("password").trim());
						String isuse = request.getParameter("isuse").trim();
						System.out.println(isuse);
						if(isuse.equals("1"))
							isuse = "1";
						else
							isuse = "2";
						int flag = loginbean.addManager(username, password, "2", isuse);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "增加管理员成功！");
							request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
						}
						else if(flag == Constant.SAME_NAME){
							request.setAttribute("username", username);
							request.setAttribute("message", "该用户名已经存在！");
							request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
						}		
					}
					else if(ra.equals("update")){
						String username = request.getParameter("username").trim();
						String password = request.getParameter("password").trim();
						String isuse = request.getParameter("isuse").trim();
						System.out.println(isuse);
						if(!password.equals("")){
							password = MD5.MD5(password);
						}
						if(isuse.equals("1"))
							isuse = "1";
						else
							isuse = "2";
						int flag = loginbean.updateManager(username, password, "2", isuse);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "修改管理员信息成功！");
							request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
						}	
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
						}		
					}
				}
			}
			else if(method.equals("delm")){//删管理员
				String username2 = (String)session.getAttribute("user");
				if(username2 == null){
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else{
					int id = Integer.parseInt(request.getParameter("id").trim());
					if(id == 1){
						request.setAttribute("message", "不能删除原始帐号！");
						request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
					}
					else{
						int flag = loginbean.delManager(id);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "删除成功！");
							request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
						}	
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/system/user.jsp").forward(request, response);
						}	
					}
				}			
			}
			else{//无参数传入转到错误页面
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}
	public void init() throws ServletException {
		// Put your code here
	}
}
