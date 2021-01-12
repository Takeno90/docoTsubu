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
<title>Insert title here</title>
</head>
<body>
<%if(user != null){ %>
	<p>ログインに成功しました</p>
	<p>ようこそ<%= user.getName() %>さん</p>
	<a href="/docoTsubu/Main">つぶやきの投稿・閲覧へ</a>
<%}else{ %>
	<p>ログインに失敗しました</p>
	<a href="/docoTsubu/">トップへ</a>
<%} %>
</body>
</html>