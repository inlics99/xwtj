<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<jsp:useBean id="sys" scope="page" class="com.service.admin.impl.systemServiceImpl" />
<jsp:useBean id="abc" scope="page" class="com.service.admin.impl.afficheServiceImpl"/>
<jsp:useBean id="news" scope="page" class="com.service.admin.impl.newsServiceImpl"/>  
<jsp:useBean id="cb" scope="page" class="com.service.admin.impl.comServiceImp"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List sysList=sys.getSiteInfo();
	List affList=abc.getAllAffiche(); 
	List newsList=news.getIndexNews();
	List AllnewsList=news.getAllNews();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title><%=sysList.get(0).toString() %></title>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META name="keywords" content="<%=sysList.get(2).toString() %>" />
<META name="description" content="<%=sysList.get(3).toString() %>" />

<META content="MSHTML 6.00.2900.3243" name=GENERATOR>
<LINK href="images/css.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %>images/default.css" type=text/css rel=stylesheet>

</head>

<SCRIPT language=JavaScript src="<%=basePath %>images/Common.js"></SCRIPT>
<SCRIPT language=JavaScript src="<%=basePath %>images/index.js"></SCRIPT>
<SCRIPT language=JavaScript src="<%=basePath %>images/calendar.js"></SCRIPT>
 
<SCRIPT language=JavaScript src="images/inc.js"></SCRIPT>
<SCRIPT language=JavaScript src="images/default.js"></SCRIPT>
<SCRIPT language=JavaScript src="images/swfobject.js"></SCRIPT>

<link href="images/lanrenzhijia.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.featureList-1.0.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.featureList(
			$("#feature_tabs li"),
			$("#feature_output li"), {
				start_item : 0,
				transition_interval: 5000
			}
		);
	});
</script>

<body style="width:80%; margin:0 auto;">
<style type="text/css">
@charset "utf-8";
body,div,p,ul,ol,dl,dt,dd,li,form,input,table,th,td,img,h1,h2,h3,h4,h5,h6{margin:0;padding:0;}
em,b,i{font-style:normal;}
img{ border:none;}
a{ text-decoration:none; color:#333333;}
a:hover{text-decoration:none; color:#bf0614;}
ul li{ list-style:none;}

table{border-spacing:0;border-collapse:collapse;}
.last{margin-right:0}
.vspace{ height:10px; line-height:0; font-size:0; overflow:hidden; clear:both;}
.clear{ height:0px; line-height:0; font-size:0; overflow:hidden; clear:both;}

.nav_wrapper_bg{width: 100%;height:46px;margin:0 auto;margin-top:20px;background-color:#333333;}
.nav_wrapper_bg .nav_wrapper{width:100%;height:46px;margin: 0 auto;position: relative;z-index: 51;}
.nav_wrapper_bg .nav_wrapper .nav_list{width:1200px;margin: 0 auto;height: 46px;}
.nav_wrapper_bg .nav_wrapper .nav_list .nav_left{float: left; margin-left:350px;}
.nav_wrapper_bg .nav_wrapper .nav_list .nav_right{
	position: absolute;
	right:-150px;
}
.nav_wrapper_bg .nav_wrapper .navli{height: 46px;line-height: 46px;float: left;margin-right: 20px;cursor: pointer;}
.nav_wrapper_bg .nav_wrapper .navli .nav_tit{display: inline-block;height:46px;font-size: 14px;color: #000;line-height: 46px; position:relative;}
.nav_wrapper_bg .nav_wrapper .navli .nav_tit a{color:white;text-decoration: none;display: inline-block;float: left;margin：200px;}
.nav_wrapper_bg .nav_wrapper .navli .nav_tit .group{display: inline-block;margin-right: 1px;width:13px;height:8px;float: left;margin-top: 20px;margin-left: 4px;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_20190902_bai.png) no-repeat;background-position: 0 0;}
.nav_wrapper_bg .nav_wrapper .navli.rotate180 .nav_tit .group{background-image:url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) !important;}

.nav_wrapper_bg .nav_wrapper .navli .nav_tit .hot{display:inline-block;width:27px;height:13px;position:absolute;top:2px;right:-7px;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/hot_20190902_bai.png) no-repeat;}
.nav_wrapper_bg .nav_wrapper .navli .nav_tit:hover{color: #bf0614 !important;}
.nav_wrapper_bg .nav_wrapper .navli .nav_tit:hover a{color: #bf0614 !important;}
.nav_wrapper_bg .nav_wrapper .home{background:url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_home_20190902_bai.png) no-repeat left center;display: inline-block;height: 46px;
    padding-left: 22px}
.nav_wrapper_bg .nav_wrapper .nav_border{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_border_20190902_bai.png) no-repeat right center;padding-right:26px;margin-right:26px;}
.nav_wrapper_bg .nav_wrapper .nav_border.last{}
.nav_wrapper_bg .nav_wrapper .last{margin-right: 0px;}
.nav_wrapper_bg .nav_wrapper .icon{margin-right: 0px;margin-left:0;}

.nav_wrapper_bg .nav_wrapper .search_icon{color:white;width: 18px;height: 46px;padding:0 10px;margin-left:16px;}
.nav_wrapper_bg .nav_wrapper .search_icon .btn_icon{ color:white; display: inline-block;width: 18px;height: 19px;margin-top: 15px;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_20190902_bai.png) no-repeat;background-position: 0 -34px;}
.nav_wrapper_bg .nav_wrapper .search_icon:hover .btn_icon{color:white;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat !important;background-position: 0px -34px !important;}
.nav_wrapper_bg .nav_wrapper .search_icon.hov1 .btn_icon{color:white;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat !important;background-position: 0px -34px !important;}

.nav_wrapper_bg .nav_wrapper .app_icon{width: 16px;height: 46px;padding:0 10px;}
.nav_wrapper_bg .nav_wrapper .app_icon .btn_icon{display: inline-block;width: 16px;height: 19px;margin-top: 15px;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_20190902_bai.png) no-repeat;background-position: 0 -78px;}
.nav_wrapper_bg .nav_wrapper .app_icon:hover .btn_icon{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat !important;background-position: 0px -78px !important;}
.nav_wrapper_bg .nav_wrapper .app_icon.hov1 .btn_icon{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat !important;background-position: 0px -78px !important;}

.nav_wrapper_bg .nav_wrapper .user_icon{width: 21px;height: 46px;padding:0 10px;}
.nav_wrapper_bg .nav_wrapper .user_icon .btn_icon{display: inline-block;width: 21px;height: 19px;margin-top: 15px;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_20190902_bai.png) no-repeat;background-position: 0 -57px;}
.nav_wrapper_bg .nav_wrapper .user_icon:hover .btn_icon{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat  !important;background-position: 0px -57px !important;}
.nav_wrapper_bg .nav_wrapper .user_icon.cur .btn_icon{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat  !important;background-position: 0px -57px !important;}
.nav_wrapper_bg .nav_wrapper .user_icon.hov2 .btn_icon{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat  !important;background-position: 0 -57px !important;
}

.nav_wrapper_bg .nav_wrapper .class_icon{width: 16px;height: 46px;padding:0 10px;padding-right: 0;}
.nav_wrapper_bg .nav_wrapper .class_icon .btn_icon{display: inline-block;width: 16px;height: 16px;margin-top: 17px;background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_20190902_bai.png) no-repeat;background-position: 0 -13px;}
.nav_wrapper_bg .nav_wrapper .class_icon:hover .btn_icon{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat  !important;background-position: 0 -13px !important;}
.nav_wrapper_bg .nav_wrapper .class_icon.hov3 .btn_icon{background: url(//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/nav_icon_spirit_hover_20190902_bai.png) no-repeat  !important;background-position: 0 -13px !important;}

#lunbo{margin-top:20px;margin-left:0px;}
		
#logo{position:absolute;left:200px;top:20px; }

.headlines_1400{
	width:900px;
	position: relative;
	left:300px;
}
</style>
		
		
		

				
			
<div><a href="<%=basePath %>"><img id="logo" alt="logo" src="<%=request.getContextPath()%>/images/未标题-2.jpg" width="300px" height="45px"></a></div>
<div class="nav_wrapper_bg">
	<div class="wrapper_1200">
		<div class="nav_wrapper">
			<div class="nav_list">
				<div class="nav_left">
					<div class="navli"><span class="nav_tit"><a href="<%=basePath %>">首页</a></span></div> 
					<%
					List menulist=cb.getCom("select * from fenlei order by id asc",2);
					if(!menulist.isEmpty()){
						for(int i=0;i<menulist.size();i++){
						List listss=(List)menulist.get(i);
					 %>
				 	<div class="navli"><span class="nav_tit"><a href="<%=basePath %>news.jsp?id=<%=listss.get(0).toString()%>"><%=listss.get(1).toString()%></a></span></div> 
				 	<%}} %> 
				 
					<div class="navli"><span class="nav_tit"><a href="<%=basePath %>search.jsp">新闻搜索</a></span></div>
					<div class="navli"><span class="nav_tit"><a href="<%=basePath %>tj.jsp">个性推荐</a></span></div>    
				 
													
					</div>
					
				<div class="nav_right">
						
					<div class="navli icon search_icon slidenew"><a href="https://www.baidu.com/"><span class="btn_icon"></span></div>
					
					
					<div class="navli icon app_icon slidenew"><a target="_blank" href="http://app.cctv.com/appkhdxz/more/index.shtml" class="btn_icon"></a></div>
					<div class="navli icon user_icon slidenew"><a href="<%=basePath %>member/index.jsp"><span class="btn_icon"></span></a></div>
					
				</div>

			</div>

		</div>
	</div>
</div>



<div class="headlines_1400" id ="SUBD1547695103776262"  data-spm="S76262" style="margin-top:50px;">
		<div class="ELMTgdIq9hMACR0hrWuVzg33190117 headlines" data-spm= "EgdIq9hMACR0">
			<div class="head_tit">
				
				<a href="http://m.news.cctv.com/2020/07/06/ARTIaDFecJLM0i4CVxjDNnU1200706.shtml"  target="_blank" ><i style="color: rgb(191, 6, 20);" ><h2 style="margin-left:200px;margin-top:0px;">头条 · </i>习近平给巴布亚新几内亚布图卡学园复信</h2></a>
				
			</div>
			<div class="bottom_tit">
				
				<a href="http://m.news.cctv.com/2020/07/06/ARTIaDFecJLM0i4CVxjDNnU1200706.shtml" target="_blank" style="margin-left:-50px;">肯定学园办学成绩丨</a> <a href="http://m.news.cctv.com/2020/07/06/ARTIaDFecJLM0i4CVxjDNnU1200706.shtml" target="_blank">对学园近期克服新冠肺炎疫情影响实现复课表示欣慰丨</a> <a href="http://m.news.cctv.com/2020/07/06/ARTIaDFecJLM0i4CVxjDNnU1200706.shtml" target="_blank">指出中方将继续为学园发展提供必要支持和帮助</a>
			
			</div>
		</div>
	</div>

<div class="middle" >
<div id="feature_list" >
			<ul id="feature_tabs" >
				<li><span class="link-title">追寻</span>
				<div class="feature_cat">
					<a href="#" class="link-more">
				</a></div>
				</li>
				<li><span class="link-title">“第一书记”余恩：我是西部农村娃，在这里扶贫有感情</span>
				<div class="feature_cat">
					<a href="#/" class="link-more">
					</a></div>
				</li>
				<li><span class="link-title">2020年高考考生家长请注意了！“高考防疫”指南来了！</span>
				<div class="feature_cat">
					
					<a href="#" class="link-more"> </a></div>
				</li>
			</ul>
			<ul id="feature_output">
				<li>
				<img src="images/x3.jpg" height="325" width="960" class="slider-img" />
				<a href="#/">				</a></li>
				<li>
				<img src="images/x2.jpg" height="325" width="960" class="slider-img" />
				<a href="#">				</a></li>
				<li>
				<img src="images/x1.jpg" height="325" width="960" class="slider-img" />
				<a href="#">				</a></li>
			</ul>
		</div>
</div>


		
</body>
</html>

