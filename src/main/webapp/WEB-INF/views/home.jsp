<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/simple/resources/css/home.css" rel="stylesheet"/>
	<title>메인 화면</title>
</head>	
<body>
	<script type="text/javascript" src="/simple/resources/javascript/home.js"></script>
	
	<jsp:include page="/WEB-INF/views/header.jsp">
		<jsp:param name="loggedInUsername" value="${loggedInUsername}" />
	</jsp:include>
	
	
	<div class="board">
		<table>
			<thead>
				<tr>
					<th colspan="4">
						<form method="get" action="/simple/home">
							<input type="hidden" name="page" value="1"/>
							<input type="text" name="keyword" value="${keyword}"/>
							<input type="submit" value="검색"/>
						</form>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>날짜</td>
				</tr>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td><a href="/simple/post?id=${post.id}">${post.id}</a></td>
						<td><a href="/simple/post?id=${post.id}">${post.title}</a></td>
						<td><a href="/simple/post?id=${post.id}">${post.author}</a></td>
						<td><a href="/simple/post?id=${post.id}">${post.date}</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<c:if test = "${not empty loggedInUsername}">
				<tfoot>
					<tr>
						<td colspan="4">
							<button id="create_post" onclick="gotoCreatePost()">글 작성하기.</button>
						</td>
					</tr>
				</tfoot>
			</c:if>
		</table>
	</div>
	<div class="page_container">
		<button onclick="gotoPageLeft('${page}','${keyword}')">🡄</button>
		<c:choose>
			<c:when test = "${not empty keyword}">
				<c:choose>
					<c:when test = "${page eq linkPages[0]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=${keyword}" class="current-page-button">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=${keyword}">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=${keyword}">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=${keyword}">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=${keyword}">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[1]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=${keyword}">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=${keyword}" class="current-page-button">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=${keyword}">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=${keyword}">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=${keyword}">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[2]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=${keyword}">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=${keyword}">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=${keyword}" class="current-page-button">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=${keyword}">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=${keyword}">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[3]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=${keyword}">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=${keyword}">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=${keyword}">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=${keyword}" class="current-page-button">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=${keyword}">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[4]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=${keyword}">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=${keyword}">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=${keyword}">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=${keyword}">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=${keyword}" class="current-page-button">${linkPages[4]}</a>
					</c:when>
					<c:otherwise>
						<a href="/simple/home?page=${linkPages[0]}&keyword=${keyword}">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=${keyword}">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=${keyword}">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=${keyword}">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=${keyword}">${linkPages[4]}</a>
					</c:otherwise>
				</c:choose>	
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test = "${page eq linkPages[0]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=" class="current-page-button">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[1]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=" class="current-page-button">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[2]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=" class="current-page-button">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[3]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=" class="current-page-button">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=">${linkPages[4]}</a>
					</c:when>
					<c:when test = "${page eq linkPages[4]}">
						<a href="/simple/home?page=${linkPages[0]}&keyword=">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=" class="current-page-button">${linkPages[4]}</a>
					</c:when>
					<c:otherwise>
						<a href="/simple/home?page=${linkPages[0]}&keyword=">${linkPages[0]}</a>
						<a href="/simple/home?page=${linkPages[1]}&keyword=">${linkPages[1]}</a>
						<a href="/simple/home?page=${linkPages[2]}&keyword=">${linkPages[2]}</a>
						<a href="/simple/home?page=${linkPages[3]}&keyword=">${linkPages[3]}</a>
						<a href="/simple/home?page=${linkPages[4]}&keyword=">${linkPages[4]}</a>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<button onclick="gotoPageRight('${page}','${keyword}')">🡆</button>
	</div>
</body>
</html>