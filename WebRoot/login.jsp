<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="iframe/head.jsp" %>
<SCRIPT language=javascript>
//检验表单的合法性
function checklogin() {
	if (document.form1.username.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\请输入您的用户名！");
		document.form1.username.focus();
	}
	else if (document.form1.password.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\请输入您的密码！");
		document.form1.password.focus();
	} 
	else{
	     form1.submit();
	}
}
</SCRIPT>
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
 <br><br>
 <FORM id="form1" name="form1" action="<%=basePath %>Login?method=PAGEUSERLOGIN" method="post" >
	 <TABLE align=center width="900" border=0 style="margin-left:220px;">
		<TBODY>
		   <TR>
		        <TD width="40%" height=24 align=right>用户名：</TD>
		        <TD align=left><INPUT class=input_new id=username style="WIDTH: 210px" size=15 maxLength=10 name=username></TD>
		   </TR>
		   <TR>
		       <TD width="40%" height=24 align=right>密　码：<input type=hidden name=reg_type value=person></TD>
		       <TD align=left><INPUT class=input_new id=password style="WIDTH: 210px" type=password size=15  maxLength=16 name=password></TD>
		   </TR>
		   <TR>
		       <TD colspan=3 height=24 align=center><input type=button value="登陆" onClick="checklogin()" style="width:50px;margin-top:20px;">                    
		   </TR>						  
		 </TBODY>
	 </TABLE>
	 <table align=center style="margin-left:200px;margin-top:50px;">
	  <tr>
	  	<td><A href="lost.jsp" style="margin-left:300px">找回密码</A> </td>
	  	<td width="40%"><a href="http://localhost:8080/xwtj/admin/login.jsp" style="margin-left:90px">管理员登陆</a></td>
	  	<td><A href="<%=basePath %>reg2.jsp" style="margin-left:0px">注册会员</A></td>
	  </tr>
	 </table>
</FORM>
  <br><br>
<%@ include file="iframe/foot.jsp"%>