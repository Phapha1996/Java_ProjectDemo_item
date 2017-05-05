<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'body.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center;">
  
  <br><br><br><br>
    <h3>考试须知</h3>
    
    1.在做题的时候，请勿请教他人，遵守规则<br><br>
    2.请按照格式填图答题卡，否则不给分<br><br>
    <font color="red">3.请注意，答题的时候务必都要带小数点，如：13.0，15.2</font><br><br>
    4.以上任意一条不符合规则，都将影响您的最后成绩！
    <br><br>
    <h2>祝您考试成功!</h2>
    
    
  </body>
</html>
