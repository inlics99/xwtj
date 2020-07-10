<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
    <jsp:useBean id="cb6" scope="page" class="com.service.admin.impl.comServiceImp"/> 

<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper_backBg_04" id ="SUBD1561600658148883"  data-spm="S48883" >
		
	<div class="wrapper_1200" id ="SUBD1561600708886953"  data-spm="S86953" >
		<div class="ELMTnZwJYbrEClsgnR1UEpt7190627 program_wrapper" id="nav15" data-spm= "EnZwJYbrECls" >
<div class="kj">
<div class="bt" style="margin-top:-30px;"><a href="http://localhost:8080/xwtj/index.jsp" target="_blank"><img src="<%=request.getContextPath()%>/images/lo.png" alt="中国仰望电视台" height="100px" ></a></div><div class="xz"></div></div>
<div class="kjf">
	<table cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td class="cur"><p><a href="https://tv.cctv.com/live/cctv1/">YWTV-1<br /><i>综 合</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv2/">YWTV-2<br /><i>财 经</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv3/">YWTV-3<br /><i>综 艺</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv4asia/">YWTV-4<br /><i>中文国际</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv5/">YWTV-5<br /><i>体 育</i></a></p></td>
			<td><p><a href="http://tv.cctv.com/cctv5plus/">YWTV-5+<br /><i>体育赛事</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv6/">YWTV-6<br /><i>电 影</i></a></p></td>
			<td><p><a href="http://tv.cctv.com/cctv7/">YWTV-7<br /><i>国防军事</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv8/">YWTV-8<br /><i>电视剧</i></a></p></td>
		</tr>
		<tr>
			<td><p><a href="https://tv.cctv.com/cctv9/">YWTV-9<br /><i>纪 录</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv10/">YWTV-10<br /><i>科 教</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv11/">YWTV-11<br /><i>戏 曲</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv12/">YWTV-12<br /><i>社会与法</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv13/">YWTV-13<br /><i>新 闻</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv14/">YWTV-14<br /><i>少 儿</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv15/">YWTV-15<br /><i>音 乐</i></a></p></td>
			<td><p><a href="https://tv.cctv.com/cctv17/">YWTV-17<br /><i>农业农村</i></a></p></td>
			<td></td>
		</tr>
	</table>
</div>
	
				
					<style type="text/css">
body,div,p,ul,ol,dl,dt,dd,li,form,input,table,th,td,img,h1,h2,h3,h4,h5,h6{margin:0;padding:0;}
/*节目单*/
.wrapper_backBg_04{ background:#fff;margin: 0 auto;width:100%;padding-top:30px;padding-bottom:40px;}
.program{width:100%;background-color: #fff;}
.program_wrapper{ width:1200px; margin:0 auto;}
.program_wrapper .kj{position:relative;}
.program_wrapper .kj .bt{ width:1200px; text-align: center;padding-top:10px;margin-top:-50px; }
.program_wrapper .kj .bt a{}
.program_wrapper .kj .xz{ position:absolute; right:40px; top:32px;}
.program_wrapper .kj .xz a{ display:block; background:url(//p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1549941859564401/compose07.jpg) no-repeat scroll right -86px; padding-right:20px}
.program_wrapper .kjf{clear:both;margin-top:0px;}
.program_wrapper .kjf table{border-collapse:collapse;height:139px;width:100%;}
.program_wrapper .kjf table td {text-align:center;border:1px solid #ebebeb;width:149px;}
.program_wrapper .kjf table td.cur p{border-bottom: 6px solid #bf0614;}
.program_wrapper .kjf table td p{cursor:pointer;display:block; font-size:16px; line-height:20px; color:#535353; font-weight:bold;padding: 14px 0 8px 0;border-bottom: 6px solid #fff;}
.program_wrapper .kjf table td p a{ color:#535353}
.program_wrapper .kjf table td p a:hover{text-decoration:none}
.program_wrapper .kjf table td.cur p a{ color:#bf0614}
.program_wrapper .kjf table td:hover p a{ color:#bf0614}
</style>

				
			


	</div>
 
			

	<div class="footerPC" id ="SUBD1554102359512432"  data-spm="S12432" >
		<div class="ELMTQA74jQrJ52rKQF2QHAdo190401 footer_hd" data-spm= "EQA74jQrJ52r" >
<div class="footer_hdCon"><div class="links"><dl class="gywm"><dt>关于我们</dt>
<dd><ul><li><a href="http://www.cctv.com/gyys/index.shtml" target="_blank">仰望动态</a></li><li><a href="http://www.cctv.cn/ly/index.shtml" target="_blank">联系YWTV</a></li><li><a href="https://www.cctv.com/special/guanyunew/PAGE1381886879510187/index.shtml" target="_blank">关于YWTV</a></li><li><a href="https://1118.cctv.com/chinese/index.shtml" target="_blank">YWTV广告中心</a></li><li><a href="https://www.cctv.com/special/guanyunew/PAGE13818868795101878/index.shtml" target="_blank">网站声明</a></li></ul>
</dd></dl><dl class="ywgk"><dt>业务概况</dt>
<dd><ul>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE1381886879510187/index.shtml" target="_blank">仰望网</a></li>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE13818868795101872/index.shtml" target="_blank">互联网电视</a></li>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE1381887108536138/index.shtml" target="_blank">央视影音</a></li>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE13818868795101871/index.shtml" target="_blank">手机电视</a></li>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE13818868795101870/index.shtml" target="_blank">IP电视</a></li>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE13818868795101874/index.shtml" target="_blank">移动传媒</a></li>
</ul></dd></dl><dl class="gdlj"><dt>更多链接</dt>
<dd><ul>
<li style="width:208px;"><a href="https://www.12377.cn/" target="_blank">网上有害信息举报专区</a></li>
<li><a href="https://help.cctv.com/" target="_blank">帮助中心</a></li>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE13818868795101879/index.shtml" target="_blank">法律顾问</a></li>
<li><a href="https://www.cctv.com/special/guanyunew/PAGE1381887116691173/index.shtml" target="_blank">友情链接</a></li>
<li><a href="http://career.cntv.cn/" target="_blank">人才招聘</a></li>
</ul></dd></dl><div class="footer_hdCon_r"><div class="topIcon">
<a href="http://app.cctv.com/appkhdxz/ydb/index.shtml" target="_blank"><img src="//p2.img.cctvpic.com/photoAlbum/page/performance/img/2019/8/6/1565056605605_277.png"  alt="">央视<br>影音</a>
<a href="http://app.cctv.com/appkhdxz/ysxwydb/index.shtml" target="_blank"><img src="//p2.img.cctvpic.com/photoAlbum/page/performance/img/2019/10/7/1570430463035_589.png"  alt="">央视<br>新闻</a>
<a href="http://app.cctv.com/appkhdxz/yscj/index.shtml" target="_blank"><img src="//p3.img.cctvpic.com/photoAlbum/page/performance/img/2019/8/6/1565056628496_952.png"  alt="">央视<br>财经</a>
<a href="http://app.cctv.com/appkhdxz/xmpdydb/index.shtml" target="_blank"><img src="//p2.img.cctvpic.com/photoAlbum/page/performance/img/2019/8/6/1565056634691_485.png"  alt="">熊猫<br>频道</a></div>
<div class="bottonSearch"><input type="text" id="mytxtbottom" value="" onfocus="if(this.value==this.defaultValue){this.value='';}" onblur="if(this.value==''){this.value=this.defaultValue;}">
<input type="button" class="btns"  onclick="queryByInputbottom(document.getElementById('mytxtbottom').value);return false">
</div></div></div></div></div><div class="ELMT1Zr5TvzLbM28vVdo4b4S190401 footer_bd" data-spm= "E1Zr5TvzLbM2">
			<div class="footer_bdCon">
				<div class="footer_bdCon_l">
					<p>
						<a href="https://help.cctv.com/2020/03/11/ARTI2EZRxlz2vUYrpi2B86VV200311.shtml" target="_blank">违法和不良信息举报电话:010-88047123</a>
						<a href="http://www.beian.miit.gov.cn" target="_blank">京ICP证060535号</a>
						<a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000018" target="_blank"><img src="//p2.img.cctvpic.com/photoAlbum/page/performance/img/2019/1/17/1547690093181_865.png" >京公网安备 11000002000018号</a>京网文[2014]0383-083号
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网上传播视听节目许可证号 0102004  新出网证（京）字098号</p>
					
				</div>
				<div class="footer_bdCon_r">
					
					<dl>
						<dt><a><img src="//p3.img.cctvpic.com/photoAlbum/page/performance/img/2019/1/17/1547690271213_820.png" alt=""></a></dt>
						<dd><a><img src="//p4.img.cctvpic.com/photoAlbum/page/performance/img/2019/8/19/1566215593628_760.png" alt=""><span>网络110<br />报警服务</span></a></dd>
					</dl>
					<p>仰望广播电视总台&nbsp;&nbsp;仰望网&nbsp;&nbsp;版权所有</p>
					
				</div>
			</div>
	</div>
	
				
		
<style type="text/css">
body,div,p,ul,ol,dl,dt,dd,li,form,input,table,th,td,img,h1,h2,h3,h4,h5,h6{margin:0;padding:0;}
.footerPC{width: 100%;height: 300px;margin: 0 auto;}
.footerPC img{border: 0;}
.footerPC .footer_hd{height: 199px;border-bottom: 1px solid #484848;background: #333;}
.footerPC .footer_bd{height: 100px;background: #272727;color: #cacaca;font-size: 12px;}
.footerPC .footer_bd a{color: #cacaca;text-decoration: none;}
.footerPC .footer_bd a:hover{text-decoration: underline;}
.footerPC .footer_bdCon,.footerPC .footer_hdCon{width: 1200px;margin: 0 auto;}
.footerPC .footer_hdCon .gywm{width: 285px;}
.footerPC .footer_hdCon .ywgk{width: 285px;padding-left: 42px;}
.footerPC .footer_hdCon .gdlj{width: 220px;padding-left: 32px;}
.footerPC .footer_hdCon .links{padding-top: 28px;overflow: hidden;}
.footerPC .footer_hdCon .links dl{float: left;}
.footerPC .footer_hdCon .links dt{color: #c10714;font-size: 20px;font-weight: bold;padding-bottom: 18px;border-right: 1px solid #272727;}
.footerPC .footer_hdCon .links dd{border-right: 1px solid #272727;height: 88px;}
.footerPC .footer_hdCon .links a{color: #fefefe;font-size: 14px;text-decoration: none;}
.footerPC .footer_hdCon .links a:hover{color: #c10714;}
.footerPC .footer_hdCon .links li{list-style:none;float: left;width: 134px;line-height: 34px;font-size: 14px;}
.footerPC .footer_hdCon .gdlj li{width: 104px;list-style:none;}
.footerPC .footer_hdCon .footer_hdCon_r{float: right;}
.footerPC .footer_hdCon .footer_hdCon_r .topIcon{text-align: right;overflow: hidden;}
.footerPC .footer_hdCon .footer_hdCon_r .topIcon a{color: #fff;font-size: 12px;text-decoration: none;float: left;margin-left: 14px;}
.footerPC .footer_hdCon .footer_hdCon_r .topIcon a:hover{color: #c10714;}
.footerPC .footer_hdCon .footer_hdCon_r .topIcon img{float: left;margin-top: 1px;margin-right: 7px; width:32px; height:32px;/*background:#e6e6e6  url(//p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1549941859564401/zwPic30_8.png) no-repeat center center;*/}
.footerPC .footer_hdCon .bottonSearch{text-align: right;margin-top: 66px;position: relative;float: right;width: 288px;height: 40px;}
.footerPC .footer_hdCon .bottonSearch input{ width: 244px;height: 14px;line-height: 14px;background: #272727;border: 0;color: #b9b9b9;padding-left: 10px;font-size: 14px;outline: none;padding-right: 1px;margin-right: 34px;padding-top: 13px;padding-bottom: 13px;}
.footerPC .footer_hdCon .bottonSearch .btns{position: absolute;right: 0px;bottom: 0px;width: 34px;height: 40px;background: url(//p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1549941859564401/footer_searchIcon.jpg) no-repeat 2px center #272727;z-index: 2;cursor: pointer;padding: 0;border: 0;margin: 0;}
.footerPC .footer_bd .footer_bdCon_l{float: left;padding-top: 17px;}
.footerPC .footer_bd .footer_bdCon_l p{line-height: 32px;}
.footerPC .footer_bd .footer_bdCon_l p img{vertical-align: middle;margin: 0 8px;}
.footerPC .footer_bd .footer_bdCon_r{float: right;}
.footerPC .footer_bd .footer_bdCon_r dl{overflow: hidden;padding: 22px 0 10px 66px;}
.footerPC .footer_bd .footer_bdCon_r dt,.footerPC .footer_bd .footer_bdCon_r dd{float: left;}
.footerPC .footer_bd .footer_bdCon_r dd{width: 87px;text-align: right;margin-left: 10px;}
.footerPC .footer_bd .footer_bdCon_r dd a:hover{text-decoration: none;}
.footerPC .footer_bd .footer_bdCon_r dd img{float: left;}
</style>
<script type="text/javascript">
	function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
	/*提交搜索*/
function queryByInputbottom(qtext) {
	
	var boottomtype="web"
	if(trim(qtext) != "") {
		window.open("https://www.baidu.com/" );
	} else {
		
		window.open("https://www.baidu.com/");
	}
}
	document.getElementById("mytxtbottom").onkeydown = function() {
	var event = window.event || arguments[0];
	if(event.keyCode == 13) { //回车       
		try {
			event.cancelBubble = true;
			event.returnValue = false;
			event.stopPropagation();
			event.preventDefault();
		} catch(e) {}
		queryByInputbottom(document.getElementById("mytxtbottom").value);
	}
}	
	$("#search_outer .buttonVal input").bind("focus", function() {
	if(this.blur) {
		this.blur()
	};
});
</script>
				
			


	</div>
 
        </div>
      </div>
    </div>
  </div>
</div>


</body>
</html>
 
