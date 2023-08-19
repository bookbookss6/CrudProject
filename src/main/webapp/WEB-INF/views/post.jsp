<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
	<link href="/simple/resources/css/post.css" rel="stylesheet"/>
</head>
<body>
	<script type="text/javascript" src="/simple/resources/javascript/post.js"></script>
	<jsp:include page="/WEB-INF/views/header.jsp">
		<jsp:param name="loggedInUsername" value="${loggedInUsername}" />
	</jsp:include>
	<div class="post_container">
		<table>
			<tr>
				<td>Id:</td>
				<td>${post.id}</td>
				<td>제목:</td>
				<td>${post.title}</td>
			</tr>
			<tr>
				<td>작성자:</td>
				<td>${post.author}</td>
				<td>조회수:</td>
				<td>${post.visited}</td>
			</tr>
			<tr>
				<td class="content" colspan="4">${post.content}</td>
			</tr>
		<c:if test = "${not empty imgStr}">
			<tr>
				<td class="image" colspan="4"><img src="data:image/png;base64,${imgStr}"></td>
			</tr>
		</c:if>
			<tr>
				<td>날짜:</td>
				<td colspan="2"><fmt:formatDate value = "${post.date}" pattern="yyyy.MM.dd"/></td>
				<td><a href="/simple/home?page=1">메인 화면으로</a></td>
			</tr>
		<c:if test = "${loggedInUsername eq post.author}">
			<tr>
				<td colspan="2" class="modify_button">
					<button onclick="gotoModifyPost('${post.id}')">수정하기</button>
				</td>
				<td colspan="2" class="delete_button">
					<button onclick="gotoDeletePost('${post.id}')">삭제하기</button>
				</td>
			</tr>
		</c:if>
		</table>
	</div>
	
	<c:if test = "${not empty loggedInUsername}">
		<div class="comment-area-container">
			<table>
				<form method="post" action="/simple/comment.do">
					<input type="hidden" name="commentAuthor" value="${commentAuthor}"/>
					<input type="hidden" name="postId" value="${post.id}"/>
					<tr class="comment-area">
						<td><label>내용:</label></td>
			            <td><textarea cols="50" name="content"></textarea></td>
			            <td><button type="submit">등록하기</button></td>
					</tr>
				</form>
			</table>	
		</div>
	</c:if>
	
	
	<div class="comment-container">
		<table>
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td>작성자: ${comment.author}</td>
					<td width="65%">내용: ${comment.content}</td>c
					<c:if test = "${loggedInUsername eq comment.author}">
						<td style="text-align: center">
							<button onclick="gotoDeleteComment('${comment.id}')">삭제하기</button>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>