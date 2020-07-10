package com.action;
//��������
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
		 if(method.equals("addlj")){ //  ��������
			String mc = request.getParameter("mc");  
			String dz = request.getParameter("dz");   
			COM com=new COM(mc, dz);
			i=1;
				int flag=cBean.comUp(com,i);
				if(flag == Constant.SUCCESS){ 
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response); 
				}
				else { 
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
				}
			 
		 } 
		 else if(method.equals("uplj")){  // �޸�����
			i=2;
			int id = Integer.parseInt(request.getParameter("id"));  
			String mc = request.getParameter("mc");  
			String dz = request.getParameter("dz");
			COM com=new COM(id, mc, dz);
			int flag=cBean.comUp(com,i);
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
			else { 
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
		}
		else if(method.equals("dellj")){   //ɾ������
			int id =Integer.parseInt(request.getParameter("id")) ;
			COM com=new COM(id);
			i=3;
			int flag=cBean.comUp(com,i);
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
			else { 
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/lj/index.jsp").forward(request, response);  
			}
		} 
		else if(method.equals("delss")){   //���������,�ؼ��ַ����Ƽ�ͬ��������
			int id = Integer.parseInt(request.getParameter("id")) ;
			COM com=new COM(id);
			i=4;
			int flag=cBean.comUp(com,i);
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("member/ss/index.jsp").forward(request, response);  
			}
			else { 
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("member/ss/index.jsp").forward(request, response);  
			}
		} 
		 
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
