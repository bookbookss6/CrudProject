<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
	String loggedInUsername= (String)request.getSession().getAttribute("loggedInUsername");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/simple/resources/css/profile.css" rel="stylesheet"/>
	<title>프로파일</title>
</head>	
<body>
	<script type="text/javascript" src="/simple/resources/javascript/profile.js"></script>
	<div class="profile_container">
		<div class="profile_item1">
			<img src="/simple/resources/img/user.png">
		</div>
		<div class="profile_item2">
			<p>이름: ${loggedInUsername}</p>
		</div>
		<div class="profile_item3">
			<button onclick="gotoShowUserPost('<%= loggedInUsername %>')">작성한 글 보기</button>
			<button onclick="showDeleteUserDialog('<%= loggedInUsername %>')">탈퇴 하기</button>
		</div>
		<div class="profile_item4">
			<a href="/simple/home?page=1&keyword=">홈페이지 이동.</a>
		</div>	
	</div>
</body>
</html>