<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mb" scope="page" class="com.service.user.impl.memberServiceImpl"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML><HEAD>
<LINK href="<%=basePath %>member/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %>member/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="<%=basePath %>images/css/Common.js"></SCRIPT>
<SCRIPT language=JavaScript src="<%=basePath %>member/images/calendar.js"></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>
<SCRIPT language=JavaScript src="<%=basePath %>member/images/city.js"></SCRIPT>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%>
<%
	String member=(String)session.getAttribute("member");
	String type=(String)session.getAttribute("type");
	if(member==null||type==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
		List list = mb.getRegInfo(member);
		String str="checked";String str2="";
		if(list.get(2).toString().trim().equals("f")){
			str=""; str2="checked";
		}
%>
<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %>member/images/MainBg.gif topMargin=0 scroll=yes marginheight="0" marginwidth="0">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD align="left" vAlign=top >
	<form action="<%=basePath %>Member?method=UPREGINFO" method="post" name="regform" onSubmit="return checkpersonreg()">
       <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD colspan="2" height=23>修改会员资料  <FONT color="#FF0000">**</FONT>为必填写字段</TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >真实姓名：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT class=inputb maxLength=24 size=30 name=realname value=<%=list.get(1).toString() %>> <FONT color=#ff0000>**</FONT>
			</TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >性&nbsp;&nbsp;&nbsp;&nbsp;别：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT type="radio" name="sex" value="m" <%=str %>> 男 <input type="radio" name="sex" value="f" <%=str2 %>>女
			</TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >出生日期：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT type="datetime" class=inputb maxLength=24 size=30 name=bir value="<%=list.get(3).toString() %>" />  
			</TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >籍&nbsp;&nbsp;&nbsp;&nbsp;贯：</TD>
			<TD width="70%" align="left" id=map>
			<input type="text"  class=inputb maxLength=12 size=11 name=sheng value="<%=list.get(4).toString() %>" >                             
                                	  省&nbsp;&nbsp;
			<input type="text"  class=inputb maxLength=12 size=11 name=city value="<%=list.get(5).toString() %>" >市      
	
			</TD>
		  <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >联系电话：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT class=inputb name=telphone maxLength=18 size=30  onkeyup="this.value=this.value.replace(/\D/gi,'')" value="<%=list.get(6).toString() %>"> <FONT color=#ff0000>**</FONT>
			</TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >E-mail：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT class=inputb  name=email maxLength=50 size=30  value="<%=list.get(7).toString() %>"> <FONT color=#ff0000>**</FONT> <FONT color=#ff6600>(此电子邮件非常重要，请认真填写！）</FONT>
			</TD>
		  </TR>
		   <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >密码提示问题：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT class=inputb maxLength=28 size=30 name=question  value="<%=list.get(8).toString() %>"> <FONT color=#ff0000>**</FONT> 需要找回密码的时候,提示的问题“您叫什么名字？”
			</TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >问题回答：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT class=inputb maxLength=28 size=30  name=answer value="<%=list.get(9).toString() %>"> <FONT color=#ff0000>**</FONT> 您自设问题的答案,如您的答案是“小黄”
			</TD>
		  </TR>
		   <TR align="center" bgColor=#ffffff>
			<TD width="30%" align="right" >详细地址：</TD>
			<TD width="70%" align="left" id=map>
			<INPUT class=inputb  name=address maxLength=50 size=30  value="<%=list.get(10).toString() %>"> <FONT color=#ff0000>**</FONT>
			</TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD colspan="2" align="center" ><input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重填"></TD>
		  </TR>
		</TBODY>
	   </TABLE>
	  </form>
    </TD>
  </TR>
  </TBODY>
</TABLE>
</BODY>
<%} %>
</HTML>
