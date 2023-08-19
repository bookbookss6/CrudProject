<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/simple/resources/css/signup.css" rel="stylesheet"/>
<title>회원가입</title>
</head>
<body>
	<div class="signup-form-container">
		<h1>회원 가입</h1>
		<form method="post" action="/simple/signup.do">
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
						<input type="submit" value="가입하기">
					</td>
				</tr>
			</table>
		</form>
		<br>
		<a href="/simple/login">뒤로 가기</a>
		<c:if test = "${not empty errorMessage}">
			<h3>${errorMessage}</h3>
		</c:if>
	</div>
</body>
</html>