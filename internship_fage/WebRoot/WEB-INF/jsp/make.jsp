<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>产生问题的页面</title>
  </head>
  
  <body style="text-align:center;">
  
  <br><br><br>
  
  <h3>考试准备开始！</h3>
  
  <br><br>
  
  <form action="${pageContext.request.contextPath }/servlet/MakeQuestionServlet" method="post">
   输入问题数：<input type="text" name="quenum" style="width:35px">
  考生姓名： <input type="text" name="stuname" style="width:60px">
   <br><br><br>
   
  <input type="submit" value="产生问题">
 </form>
    
  </body>
</html>
