<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="product_list.html">&nbsp;${Book.category}</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;${Book.name}
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="ad/page_ad.jpg" width="645" height="84" />

								<table width="100%%" border="0" cellspacing="0">
									<tr>
										<td width="30%">

											<div class="divbookcover">
												<p>
													<img src="${Book.imgurl}"
														width="213" height="269" border="0" />
												</p>
											</div>

											<div style="text-align:center; margin-top:25px">
												<a href="${pageContext.request.contextPath}/addCart?id=${Book.id}">
													<img src="images/buybutton.gif" border="0" /> 
												</a>
											</div></td>
										<td style="padding:20px 5px 5px 5px"><img
											src="images/miniicon3.gif" width="16" height="13" /><font
											class="bookname">&nbsp;&nbsp;${Book.name}</font>

											<hr />售价：<font color="#FF0000">￥${Book.price}</font>
											<hr /> 类别：${Book.category}

											<hr />
											<p>
												<b>内容简介：</b>
											</p> ${Book.description}</td>
									</tr>
								</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>cc
	</div>


	<jsp:include page="foot.jsp" />


</body>
</html>
