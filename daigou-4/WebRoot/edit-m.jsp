<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示goods详情</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="shortcut icon" href="<%=basePath%>images/1128.png">
  </head>
  
  <body>
     <s:form action="moms/moms_editMoms">
       <h1>编辑商品</h1>
       <s:hidden name="moms.momsid"></s:hidden>
       <s:textfield name="moms.momsname" label="商品名称"></s:textfield>
       <s:textfield name="moms.mprice" label="单价"></s:textfield>
       <s:submit value="提交"></s:submit>
     </s:form>
  </body>
</html>
