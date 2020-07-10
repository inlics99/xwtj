<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="iframe/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<LINK href="images/default.css" type=text/css rel=stylesheet>
<LINK href="images/css.css" type=text/css rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2900.3268" name=GENERATOR>
</HEAD>
<!-- 翻页功能js代码 -->
<script type="text/javascript" language="javascript" >
function ne1(){//下一页
	var page=parseInt(form3.page.value);
	  var pageCount=parseInt(form3.pageCount.value);
	  if(page>=pageCount){
	    alert("已至最后一页");
	  }else{
	    form3.action="<%=basePath%>news.jsp?page="+(page+1);
	    form3.submit();
	  }
}
function ne2(){//上一页
	var page=parseInt(form3.page.value);
	  if(page<=1){
	    alert("已至第一页");
	  }else{
	    form3.action="<%=basePath%>news.jsp?page="+(page-1);
	    form3.submit();
	  }
}
function ne3(){//尾页
	 if(form3.pageCount.value==0){//如果总页数为0，那么最后一页为1，也就是第一页，而不是第0页
		    form3.action="<%=basePath%>news.jsp?page=1";
		    form3.submit();
			}else{
			form3.action="<%=basePath%>news.jsp?page="+form3.pageCount.value;
		    	form3.submit();
			}
}
function ne4(){//首页
	form3.action="<%=basePath%>news.jsp?page=1";
    form3.submit();
}
function ne5(){//跳转
  	var pageCount=parseInt(form3.pageCount.value);
  	if( fIsNumber(form3.busjump.value,"1234567890")!=1 ){
		alert("跳转文本框中只能输入数字!");
		form3.busjump.select();
		form3.busjump.focus();
		return false;
	}
	if(form3.busjump.value>pageCount){//如果跳转文本框中输入的页数超过最后一页的数，则跳到最后一页
	  if(pageCount==0){	
	  form3.action="<%=basePath%>news.jsp?page=1";
	  form3.submit();
	}
	else{
		form3.action="<%=basePath%>news.jsp?page="+pageCount;
		form3.submit();
	}
}
else if(form3.busjump.value<=pageCount){
var page=parseInt(form3.busjump.value);
   if(page==0){
      page=1;//如果你输入的是0，那么就让它等于1
      form3.action="<%=basePath%>news.jsp?page="+page;
      form3.submit();
   }else{
      form3.action="<%=basePath%>news.jsp?page="+page;
      form3.submit();
   }

}
}

//****判断是否是Number.
function fIsNumber (sV,sR){
var sTmp;
if(sV.length==0){ return (false);}
for (var i=0; i < sV.length; i++){
sTmp= sV.substring (i, i+1);
if (sR.indexOf (sTmp, 0)==-1) {return (false);}
}
return (true);
}
function del()
{
	pageform.submit();
}
</script>
<!--获取当前分类页分类名  -->
<%
String id=request.getParameter("id");
String fenlei=cb.getString("select title from fenlei where id='"+id+"' ") ;
%>
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
 
     <TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
		<TBODY>
        <TR>
          <TD class=head colspan="2">
          	<!-- 分类名 -->
			<SPAN class=TAG><%=fenlei%></SPAN> 
			
		  </TD>
		</TR>
		<TR>
		<TD  class=middle align="left" >
          <TABLE class=xsnr id=tb1_nr1  cellSpacing=0 cellPadding=0 width="100%" border=0>
             <TBODY>
                 <tr class="head">  
					<td  align="center">新闻标题</td>
					<td  align="center">新闻栏目</td>
					<td  align="center">新闻关键字</td>
					<td  align="center">发布时间</td>
					<td  align="center">发布人</td>
					<td  align="center">点击率</td> 
    		      </tr>
    	<!-- 按获取到的分类名查询新闻 -->
        <%
            cb.setEVERYPAGENUM(12);  //每页展示12条数据
			int cou = cb.getMessageCount("select count(*) from fz_news where fenlei='"+fenlei+"'");//得到信息总数			        
			String page1=request.getParameter("page");
			if(page1==null){
				page1="1";
			}
			//将数据发送到作用域,使后面的代码方便使用
			session.setAttribute("busMessageCount", cou + "");
			session.setAttribute("busPage", page1);
			//newsServiceImpl.getMessage(int, String, int) 查询当前页码(page1)的内容
			List pagelist1 = cb.getMessage(Integer.parseInt(page1),"select * from fz_news where fenlei='"+fenlei+"' order by id desc",8);
			session.setAttribute("qqq", pagelist1);
			int pageCount = cb.getPageCount(); //得到页数  
			session.setAttribute("busPageCount", pageCount + "");  
			List pagelist3=(ArrayList)session.getAttribute("qqq"); 
		%>
       <%
       		//循环输出获取信息
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
		%> 
				<tr  class="trA" onMouseOver="this.className='trB'" onMouseOut="this.className='trA'"> 
       				<td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><a href="<%=basePath %>newsinfo.jsp?id=<%=pagelist2.get(0).toString()%>" ><%=pagelist2.get(1).toString() %></a> </td>
			        <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(2).toString() %></td>
			        <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(7).toString() %></td>
			        <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(4).toString().substring(0,10) %></td>
			        <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(5).toString() %></td>
			        <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(6).toString() %></td>
      		    </tr>
	
		<%
				}
			}
		%>  
				</TBODY>
			</TABLE>			
			</TD>
		</TR>
        </TBODY>
	  </TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
            <TR>
                <TD align=right>
	                <form action="" method="post" name="form3">	
						 <input type="hidden" name="pageCount" value="<%= session.getAttribute("busPageCount").toString()%>" /><!--//用于给上面javascript传值-->
						 <input type="hidden" name="page" value="<%=session.getAttribute("busPage").toString()%>" /><!--//用于给上面javascript传值-->         
						 <a href="#" onClick="en4()"><img src="<%=basePath %>images/first.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
						 <a href="#" onClick="ne2()"><img src="<%=basePath %>images/pre.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
						  共<%=session.getAttribute("busMessageCount").toString()%>条记录,共计<%=session.getAttribute("busPageCount").toString()%>页,当前第<%=session.getAttribute("busPage").toString()%>页&nbsp;&nbsp;&nbsp;
						 <a href="#" onClick="ne1()"><img src="<%=basePath %>images/next.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
						 <a href="#" onClick="ne3()"><img src="<%=basePath %>images/last.gif" border="0" /></a>
				 	 	   第<input name="busjump" type="text" size="3" />页<a href="#" onClick="ne5()"><img src="<%=basePath %>images/jump.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
				 	</form>
                </TD>
            </TR>
        </TBODY>
    </TABLE>
 

<%@ include file="iframe/foot.jsp"%>