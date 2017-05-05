<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>产生问题页面</title>
    
  </head>
  
  <body style="text-align:center;">
  <form action="${pageContext.request.contextPath }/servlet/DoQuestionServlet" method="post">
  
  <c:forEach var="q" items="${list }" >
  	<h3><font color="red">${q.question }</font></h3>
  	
  </c:forEach>
  
  请将答案填入答题卡：<br><br>
  <c:forEach var="index" begin="0" end="${fn:length(list)-1}">
  	<input type="text" name="${index }" style="width:30px">
  </c:forEach>
  
  <br><br>
  <input type="submit" value="提交答案">
  </form>
  </body>
</html>
