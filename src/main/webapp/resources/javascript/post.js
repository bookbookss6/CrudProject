function gotoDeletePost(postId)
{
	if (confirm('정말로 삭제하겠습니까?')) {
		// 확인 버튼 누르면 데이터베이스 안의 해당 게시물 삭제.
		alert('삭제완료 되었습니다');
		location.href=`/simple/post/delete?id=${postId}`;
	} else {
		
	}
}

function gotoModifyPost(postId)
{
	location.href=`/simple/post/update?id=${postId}`;
}

function gotoDeleteComment(commentId)
{
	if (confirm('정말로 삭제하겠습니까?')) {
		// 확인 버튼 누르면 데이터베이스 안의 해당 댓글 삭제.
		alert('삭제완료 되었습니다');
		location.href=`/simple/comment/delete?id=${commentId}`;
	} else {
		
	}
}