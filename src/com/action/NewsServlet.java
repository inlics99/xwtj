package com.action;

/**
 * 新闻管理
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
		             
		            if(method.equals("ADDNEWS")){//增加新闻
		            	String title = Filter.escapeHTMLTags(request.getParameter("title").trim());
		            	String fenlei = request.getParameter("fenlei");
						String content = request.getParameter("content1");
						String gjz = request.getParameter("gjz");
						news news=new news(title, fenlei, content, username2, gjz);
						if(content.length()>8000){
						request.setAttribute("message", "对不起，内容不能超过8000个字符！");
						request.setAttribute("method", method);
						request.getRequestDispatcher(sysdir+"/news/edit.jsp").forward(request, response);
						}
						else{
							
							int flag = newsBean.addNews(news);
								if(flag == Constant.SUCCESS){
									request.setAttribute("message", "增加成功！");
									request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
								}
								else{
									request.setAttribute("message", "系统维护中，请稍后再试！");
									request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
								}
		                    }
		                    				
		            }
		            else if(method.equals("editnews")){//修改新闻
		            	String id = Filter.escapeHTMLTags(request.getParameter("id").trim());
		            	String title = Filter.escapeHTMLTags(request.getParameter("title").trim());
		            	String fenlei = request.getParameter("fenlei");
						String content = request.getParameter("content1");
						String gjz = request.getParameter("gjz");
							int flag = newsBean.updateNews(Integer.parseInt(id), title,fenlei, content, username2,gjz);
							if(flag == Constant.SUCCESS){
								request.setAttribute("message", "修改成功！");
								request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
							}
							else{
								request.setAttribute("message", "系统维护中，请稍后再试！");
								request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
							}
	                    
		            }
		            else if(method.equals("delnews")){//删除新闻  delnews
		            	int id =Integer.parseInt(request.getParameter("did")) ;
						int flag =newsBean.delNews(id);
						int it=0;
						System.out.println("it:"+it+" +id:"+id+" flag:"+flag);
						if(flag == Constant.SUCCESS){
							request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/news/index.jsp").forward(request, response);
						}
					}
		            else if(method.equals("addFenlei")){//增加分类
		            	String title=request.getParameter("title");
		            	int flag = newsBean.addFenlei(title);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
		            }
		            else if(method.equals("delFenlei")){//删分类
		            	String id=request.getParameter("id");
		            	int flag = newsBean.delFenlei(id);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/fenlei/index.jsp").forward(request, response);
						}
		            }
		            
		            
		            
		            
		            
		            
		            else if(method.equals("mdelPl")){//删评论
		            	int i=1;
		            	int id=Integer.parseInt(request.getParameter("did"));
		            	System.out.println(id);
		            	pl pl=new pl(id);
		            	int flag = newsBean.delMethod(i,pl);
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher(sysdir+"/news/pl.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher(sysdir+"/news/pl.jsp").forward(request, response);
						}
		            }
		            
		            
		            
		            //增加评论
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
		            		 request.setAttribute("message", "请先登录！");
								request.setAttribute("id",str);
								request.getRequestDispatcher("newsinfo.jsp").forward(request, response);
		            	 }
		            	 else{
		            		 int flag = newsBean.delMethod(i,pls);
								if(flag == Constant.SUCCESS){
									request.setAttribute("message", "操作成功！");
									request.setAttribute("id", str);
									request.getRequestDispatcher("newsinfo.jsp").forward(request, response);
								}
								else{
									request.setAttribute("message", "操作失败！");
									request.setAttribute("id",str);
									request.getRequestDispatcher("newsinfo.jsp").forward(request, response);
								}
		            	 }
		            	 
		            }
		            else if(method.equals("pt")) {//翻页
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
