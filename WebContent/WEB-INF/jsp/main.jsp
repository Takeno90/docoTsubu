<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
	User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶログイン</h1>
<%= user.getName() %>さん、ログイン中<a href="/docoTsubu/Logout">ログアウト</a><br>
<a href="/docoTsubu/Main">更新</a><br>
<input type="text" name="text">
<input type="submit" value="つぶやく">
</body>
</html>