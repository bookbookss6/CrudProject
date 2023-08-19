function showDeleteUserDialog(loggedInUsername)
{
	if (confirm('정말로 삭제하겠습니까?')) {
		// 확인 버튼 누르면 데이터베이스 안의 해당 유저 삭제.
		alert(`삭제완료 되었습니다 이름: ${loggedInUsername}`);
		location.href=`/simple/profile/delete?username=${loggedInUsername}`;
	} else {
		
	}
}

function gotoShowUserPost(loggedInUsername)
{
	location.href=`/simple/home/${loggedInUsername}?page=1&keyword=`;
}