<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録もどき</title>
<style>
.age_content{
	width: 50px;
}
</style>
</head>
<body>
<form action="/docoTsubu/FormSampleServlet" method="post">
	名前:<br>
	<input type="text" name="name"><br>
	性別:<br>
	男<input type="radio" name="gender" value="0">
	女<input type="radio" name="gender" value="1">
	<br>
	年齢:
	<input type="text" name="age" class="age_content"><br>
	<input type="submit" value="登録">
</form>
</body>
</html>