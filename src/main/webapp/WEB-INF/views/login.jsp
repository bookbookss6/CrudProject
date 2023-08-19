<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/simple/resources/css/login.css" rel="stylesheet"/> 	
<title>로그인</title>
</head>	
<body>
	<div class="login-form-container">
		<h1>로그인 페이지</h1>
		<form method="post" action="/simple/login.do">
			<table>
				<tr>
					<td>
						<label for="username">이름:</label>
					</td>
					<td>
						<input type="text" name="username"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="password">비밀번호:</label>
					</td>
					<td>
						<input type="password" name="password"/>
					</td>
					<td>
						<input type="submit" value="로그인">
					</td>
				</tr>
			</table>
		</form>
		<p>회원이 아니신가요? <a href="/simple/signup">회원가입하기.</a> </p>
		<c:if test = "${not empty errorMessage}">
			<h3>${errorMessage}</h3>
		</c:if>
		<p><a href="/simple/home?page=1">홈으로 이동.</a></p>
	</div>
</body>
</html>