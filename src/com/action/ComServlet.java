package com.action;
//友情链接
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.COM;
import com.service.admin.comService;
import com.service.admin.impl.comServiceImp;
import com.utils.Constant;

public class ComServlet extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENTTYPE);
		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		HttpSession session = request.getSession();
		comService cBean=new comServiceImp();
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String date2=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String method = request.getParameter("method");
		int i;
		 if(method.equals("addlj")){ //  增加链接
			String mc = request.getParameter("mc");  
			String dz = request.getParameter("dz");   
			COM com=new COM(mc, dz);
			i=1;
				int flag=cBean.comUp(com,i);
				if(flag == Constant.SUCCESS){ 
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response); 
				}
				else { 
					request.setAttribute("message", "操作失败！");
					request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
				}
			 
		 } 
		 else if(method.equals("uplj")){  // 修改链接
			i=2;
			int id = Integer.parseInt(request.getParameter("id"));  
			String mc = request.getParameter("mc");  
			String dz = request.getParameter("dz");
			COM com=new COM(id, mc, dz);
			int flag=cBean.comUp(com,i);
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
			else { 
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
		}
		else if(method.equals("dellj")){   //删除链接
			int id =Integer.parseInt(request.getParameter("id")) ;
			COM com=new COM(id);
			i=3;
			int flag=cBean.comUp(com,i);
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
			else { 
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
		} 
		else if(method.equals("delss")){   //获得搜索的,关键字方便推荐同类型新闻
			int id = Integer.parseInt(request.getParameter("id")) ;
			COM com=new COM(id);
			i=4;
			int flag=cBean.comUp(com,i);
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("member/ss/index.jsp").forward(request, response);  
			}
			else { 
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("member/ss/index.jsp").forward(request, response);  
			}
		} 
		 
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
