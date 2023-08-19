<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/simple/resources/css/header.css" rel="stylesheet"/>
	<title>메인 화면</title>
</head>	
<body>

	<script type="text/javascript" src="/simple/resources/javascript/header.js"></script>
	<c:choose>
	    <c:when test = "${not empty loggedInUsername}">
	     	<div class="header">
				<table>
					<td>
						<button class="user_profile" onclick="gotoProfile()">
							<img src="/simple/resources/img/user.png">
						</button>
					</td>
					<td>
						<span>${loggedInUsername}님 환영합니다.</span>
					</td>
					<td>
						<a href="/simple/logout.do">로그아웃</a>
					</td>
				</table>
			</div>
	    </c:when>
	    
	    <c:otherwise>
	    	<div class="header">
				<table>
					<td>
						<a href="/simple/login">로그인</a>
					</td>
				</table>
			</div>
	    </c:otherwise>
	</c:choose>
	
</body>
</html>