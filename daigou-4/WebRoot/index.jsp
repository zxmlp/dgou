<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>直接跳转到显示所有Goods的页面</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Refresh" content="0;url=goods/goods_showGoods">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>

   <!--  <s:form action="goods/goods_addGoods" method="post">
      <s:textfield name="goods.goodsname" label="商品名称"></s:textfield>
      <s:textfield name="goods.price"  label="价格"></s:textfield>
      <s:submit value="提交"></s:submit>
    </s:form> --> 
    <h1>正在跳转...</h1>
    <br>
  </body>
</html>
