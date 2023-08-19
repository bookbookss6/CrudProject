# CrudProject
<h1>기본적인 Create Read Update Delete 프로젝트 입니다.</h1>
<br/><br/><br/>

![home1](https://github.com/bookbookss6/CrudProject/assets/118971316/b0ca05b4-6b07-4553-8de3-5140a7fe30e7)

![home2](https://github.com/bookbookss6/CrudProject/assets/118971316/36a3b9ae-1e9c-4c7d-934e-db8e28ecdc89)

![board3](https://github.com/bookbookss6/CrudProject/assets/118971316/0c88cfc7-b539-43e6-b86c-bf97cdc7cc75)


<br/><br/><br/>

<h1>개발 환경 </h1>
<hr/>

<p>백엔드 : Spring Framework </p>

<p>데이터베이스 : mysql , mybatis</p>

<p>프론트엔드 : jsp , css , javascript</p>

<p>자바 버전 : openJDK 11</p>

<p>개발 도구 : sts 3.9.17</p>

<br/><br/><br/>
<hr/>

![table](https://github.com/bookbookss6/CrudProject/assets/118971316/a10c2615-ae26-4b7c-839f-a61e6d9f9eca)

<br/><br/><br/>
<hr/>


<h1>테이블 명 USER</h1>

<p>컬럼 : id  </p>
<p>타입 : int , primary key , auto_increment</p>

<p>컬럼 : username </p>
<p>타입 : varchar(100) </p>

<p>컬럼 : password</p>
<p>타입 : varchar(100)</p>

<br/><br/><br/>
<hr/>


<h1>테이블 명 POST</h1>

<p>컬럼 : id  </p>
<p>타입 : int , primary key , auto_increment</p>

<p>컬럼 : title </p>
<p>타입 : varchar(100) </p>

<p>컬럼 : author</p>
<p>타입 : varchar(100)</p>

<p>컬럼 : content</p>
<p>타입 : varchar(1000)</p>

<p>컬럼 : image</p>
<p>타입 : mediumblob</p>

<p>컬럼 : date</p>
<p>타입 : date</p>

<p>컬럼 : user_id</p>
<p>타입 : int</p>

<p>컬럼 : visited</p>
<p>타입 : int</p>

<p>외래어 키 : user_id </p>
<p>타겟 : user(user_id -> id)</p>
<p>On Update: RESTRICT</p>
<p>On Delete: CASCADE</p>

<br/><br/><br/>
<hr/>

<h1>테이블 명 COMMENT</h1>

<p>컬럼 : id  </p>
<p>타입 : int , primary key , auto_increment</p>

<p>컬럼 : content </p>
<p>타입 : varchar(500) </p>

<p>컬럼 : postId</p>
<p>타입 : int </p>

<p>컬럼 : author</p>
<p>타입 : varchar(100) </p>

<p>외래어 키 : postId </p>
<p>타겟 : post(postId -> id)</p>
<p>On Update: RESTRICT</p>
<p>On Delete: CASCADE</p>

<br/><br/><br/>
<hr/>

<h1>API 설계</h1>

<table>
  <tr>
    <td>기능</td>
    <td>URL</td>
    <td>동작 방법</td>
  </tr>
  <tr>
    <td>로그인</td>
    <td>/simple/login.do</td>
    <td>로그인 후 메인 화면으로 이동.</td>
  </tr>
  <tr>
    <td>로그아웃</td>
    <td>/simple/logout.do</td>
    <td>로그아웃 후 로그인 페이지로 이동.</td>
  </tr>
  <tr>
    <td>회원가입</td>
    <td>/simple/signup.do</td>
    <td>회원가입후 데이터베이스에 회원정보 저장.</td>
  </tr>
  <tr>
    <td>홈페이지</td>
    <td>/simple/home?page={page}&keyword={keyword}</td>
    <td>홈페이지에 모든 게시물 불러오기</td>
  </tr>
   <tr>
    <td>홈페이지</td>
    <td>/simple/home/{loggedInUsername}?page={page}&keyword={keyword}</td>
    <td>홈페이지에 로그인 된 유저의 모든 게시물 불러오기</td>
  </tr>
  <tr>
    <td>게시물 보기</td>
    <td>/simple/post?id={id}</td>
    <td>해당 유저의 게시물 보기</td>
  </tr>
  <tr>
    <td>게시물 삭제</td>
    <td>/simple/post/delete?id={id}</td>
    <td>해당 유저의 게시물 삭제</td>
  </tr>
  <tr>
    <td>게시물 수정</td>
    <td>/simple/post/update.do?id={id}&author={author}&title=title&content={content}&image={image}</td>
    <td>해당 유저의 게시물 수정</td>
  </tr>
  <tr>
    <td>게시물 만들기</td>
    <td>/simple/post/create.do?&author={author}&title=title&content={content}&image={image}</td>
    <td>해당 유저의 게시물 등록</td>
  </tr>
  <tr>
    <td>프로필 보기</td>
    <td>/simple/profile</td>
    <td>해당 유저의 프로필 보기</td>
  </tr>
  <tr>
    <td>유저 삭제</td>
    <td>/simple/profile/delete?username=${username}</td>
    <td>해당 유저를 데이터베이스로 부터 삭제</td>
  </tr>
  <tr>
    <td>에러코드 보기</td>
    <td>/simple/error/{status-code}</td>
    <td>해당 에러코드 보기</td>
  </tr>
  <tr>
    <td>댓글 등록하기</td>
    <td>/simple/comment.do?commentAuthor={commentAuthor}&postId={postId}&content={content}</td>
    <td>해당 유저의 댓글 등록하기</td>
  </tr>
  <tr>
    <td>댓글 삭제하기</td>
    <td>/simple/comment/delete?id={id}</td>
    <td>해당 유저의 댓글 삭제 하기</td>
  </tr>
</table>


<br/><br/><br/>
<hr/>





