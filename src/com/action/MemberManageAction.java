package com.action;

/**
 * 
 * ��վ��̨����ע���Ա ��ѯ ���� ɾ����Ա
 */		


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.admin.systemService;
import com.service.admin.impl.systemServiceImpl;
import com.service.user.userAdministrationService;
import com.service.user.impl.userAdministrationServiceImpl;
import com.utils.Constant;
import com.utils.Filter;
public class MemberManageAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constant.CONTENTTYPE);
		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		systemService sys=new systemServiceImpl();
		String sysdir = sys.getDir();
		HttpSession session = request.getSession();
		try{
			String username2 = (String)session.getAttribute("user");
			if(username2 == null){
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			else{
				String method = Filter.escapeHTMLTags(request.getParameter("method").trim());
				userAdministrationService mmBean=new userAdministrationServiceImpl();
				if(method.equals("DELMEMBER")){//ɾ�����Ժ�̨����ҳ��Ļ�Ա  
					int check=Integer.parseInt(request.getParameter("did").trim());
					if( check==-1 ){
						if(method.equals("DELMEMBER")){//�������и��˻�Աҳ��
							request.setAttribute("message", "��ѡ��Ҫɾ���ļ�¼��");
							request.getRequestDispatcher(sysdir+"/member/person.jsp").forward(request, response);
						}
					}
					else{
						int flag = mmBean.delMember(check);
						if(flag == Constant.SUCCESS){
							if(method.equals("DELMEMBER")){//�������и��˻�Աҳ��
								request.getRequestDispatcher(sysdir+"/member/person.jsp").forward(request, response);
							}
//							
						}
						else{
							if(method.equals("DELMEMBER")){//�������и��˻�Աҳ��
								 request.getRequestDispatcher(sysdir+"/member/person.jsp").forward(request, response);
							}
//							
						}
					}
				}
				else if(method.equals("CLOSE")){//���� ����û�
					String id=request.getParameter("cid").trim();
					System.out.println(id);
					int flag=mmBean.closeMember(Integer.parseInt(id));
					if(flag==Constant.SUCCESS){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher(sysdir+"/member/person.jsp").forward(request, response);
					}
					else{
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher(sysdir+"/member/person.jsp").forward(request, response);
					}
				}
				else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
		}catch(Exception e){
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
