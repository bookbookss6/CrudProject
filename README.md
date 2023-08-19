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





