<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시글 수정</title>
	<link href="/simple/resources/css/update-post.css" rel="stylesheet"/>
</head>
<body>
	<div class="update-post-container">
      <form action="/simple/post/update.do" method="post" enctype="multipart/form-data">
      	 <table>
      	 	 <tr>
      	 	 	<td colspan="2"><h3>게시글 수정.</h3></td>
      	 	 </tr>
			 <tr>
			 	<td><input type="hidden" name="id" value="${id}"/></td>
	      	 	<td><input type="hidden" name="author" value="${author}"/></td>
	         </tr>
	         <tr>
	            <td><label for="title">제목:</label></td>
	            <td><input type="text" name="title"/></td>
	         </tr>
	         <tr>
	            <td><label>내용:</label></td>
	            <td><textarea rows="5" cols="30" name="content"></textarea></td>
	         </tr>
	         <tr>
	            <td><label for="image">첨부사진:</label></td>
	            <td><input type="file" name="image" accept="image/*"/></td>
	         </tr>
	         <tr>
	         	<td colspan="2"><button type="submit">등록하기</button></td>
	         </tr>
	         <tr>
	         	<td colspan="2"><a href="/simple/home?page=1">뒤로 가기</a></td>
	         </tr>
         </table>
      </form>
   </div>
</body>
</html>