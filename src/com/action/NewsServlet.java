package com.action;

/**
 * ���Ź���
 * 
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.admin.Com;
import com.dao.admin.impl.ComImpl;
import com.entity.news;
import com.entity.pl;
import com.service.admin.newsService;
import com.service.admin.systemService;
import com.service.admin.impl.newsServiceImpl;
import com.service.admin.impl.systemServiceImpl;
import com.utils.Constant;
import com.utils.Filter;

@WebServlet("/newsIndex")
public class NewsServlet extends HttpServlet {

	private ServletConfig config;
	final public void init(ServletConfig config) throws ServletException
    {
        this.config = config;  
    }

    final public ServletConfig getServletConfig()
    {
        return config;
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		response.setContentType(Constant.CONTENTTYPE);
		//String sysdir = new SystemBean().getDir();
		systemService sys=new systemServiceImpl();
		String sysdir = sys.getDir() ;
		HttpSession session = request.getSession();
		try{
			String username2 = (String)session.getAttribute("user");
			 
				 String method = request.getParameter("method").trim();
				  newsService newsBean=new newsServiceImpl();
		             
		            if(method.equals("ADDNEWS")){//��������
		            	String title = Filter.escapeHTMLTags(request.getParameter("title").trim());
		            	String fenlei = request.getParameter("fenlei");
						String content = request.getParameter("content1");
						String gjz = request.getParameter("gjz");
						news news=new news(title, fenlei, content, username2, gjz);
						if(content.length()>8000){
						request.setAttribute("message", "�Բ������ݲ��ܳ���8000���ַ���");
						request.setAttribute("method", method);
						request.getRequestDispatcher(sysdir+"/news/edit.jsp").forward(request, response);
						}
						else{
							
							int flag = newsBean.addNews(news);
								if(flag == Constant.SUCCESS){
									request.setAttribute("message", "���ӳɹ���");
									request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
								}
								else{
									request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
									request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
								}
		                    }
		                    				
		            }
		            else if(method.equals("editnews")){//�޸�����
		            	String id = Filter.escapeHTMLTags(request.getParameter("id").trim());
		            	String title = Filter.escapeHTMLTags(request.getParameter("title").trim());
		            	String fenlei = request.getParameter("fenlei");
						String content = request.getParameter("content1");
						String gjz = request.getParameter("gjz");
							int flag = newsBean.updateNews(Integer.parseInt(id), title,fenlei, content, username2,gjz);
							if(flag == Constant.SUCCESS){
								request.setAttribute("message", "�޸ĳɹ���");
								request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
							}
							else{
								request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
								request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
							}
	                    
		            }
		            else if(method.equals("delnews")){//ɾ������  delnews
		            	int id =Integer.parseInt(request.getParameter("did")) ;
						int flag =newsBean.delNews(id);
						int it=0;
						System.out.println("it:"+it+" +id:"+id+" flag:"+flag);
						if(flag == Constant.SUCCESS){
							request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
						}
					}
		            else if(method.equals("addFenlei")){//���ӷ���
		            	String title=request.getParameter("title");
		            	int flag = newsBean.addFenlei(title);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
		            }
		            else if(method.equals("delFenlei")){//ɾ����
		            	String id=request.getParameter("id");
		            	int flag = newsBean.delFenlei(id);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
		            }
		            
		            
		            
		            
		            
		            
		            else if(method.equals("mdelPl")){//ɾ����
		            	int i=1;
		            	int id=Integer.parseInt(request.getParameter("did"));
		            	System.out.println(id);
		            	pl pl=new pl(id);
		            	int flag = newsBean.delMethod(i,pl);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher(sysdir+"/news/pl.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher(sysdir+"/news/pl.jsp").forward(request, response);
						}
		            }
		            
		            
		            
		            //��������
		            else if(method.equals("pl")){
		            	int i=2;
		            	Com cb=new ComImpl();
		            	int nid=Integer.parseInt(request.getParameter("nid"));
		            	String content=request.getParameter("content");
		            	String member = (String)session.getAttribute("member");
		            	pl pls=new pl(nid, content, member);
		            	System.out.println(pls.getContent());
		            	String str = String.valueOf(pls.getNid());
		            	 if(member==null){
		            		 request.setAttribute("message", "���ȵ�¼��");
								request.setAttribute("id",str);
								request.getRequestDispatcher("newsinfo.jsp").forward(request, response);
		            	 }
		            	 else{
		            		 int flag = newsBean.delMethod(i,pls);
								if(flag == Constant.SUCCESS){
									request.setAttribute("message", "�����ɹ���");
									request.setAttribute("id", str);
									request.getRequestDispatcher("newsinfo.jsp").forward(request, response);
								}
								else{
									request.setAttribute("message", "����ʧ�ܣ�");
									request.setAttribute("id",str);
									request.getRequestDispatcher("newsinfo.jsp").forward(request, response);
								}
		            	 }
		            	 
		            }
		            else if(method.equals("pt")) {//��ҳ
		            	String page=request.getParameter("page");
		            	System.out.println(page);
		            }
		            else{
		            	request.getRequestDispatcher("error.jsp").forward(request, response);
		            }
		      
			 
		}catch(Exception e){
			e.printStackTrace();
			
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	public void init() throws ServletException {
		//
	}

}
