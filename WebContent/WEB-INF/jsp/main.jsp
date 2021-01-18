<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ page import="model.User,model.Mutter,java.util.List" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
	List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	String errorMsg = (String)request.getAttribute("errorMsg");
%>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<c:out value="${loginUser.name }"></c:out>
<%--<%= loginUser.getName() %> --%>さん、ログイン中<br>
<a href="/docoTsubu/Logout">ログアウト</a><br>
<a href="/docoTsubu/Main">更新</a><br>
<form action="/docoTsubu/Main" method="post">
	<input type="text" name="text">
	<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg }">
	<p>${errorMsg }</p>
</c:if>
<c:forEach var="mutter" items="${mutterList }">
	<p><c:out value="${mutter.userName }"></c:out>:
	<c:out value="${mutter.text }"></c:out>
</c:forEach>


<%--
<%if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<%} %>
<%for(Mutter mutter : mutterList){ %>
	<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<%} %>
 --%>
</body>
</html>