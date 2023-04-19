# SpringBoot-Board
+ `Springboot` &nbsp;`JPA` &nbsp; `MySQL` 이용한 게시판 만들기 <br>
:white_check_mark: domain 작성 <br>
:white_check_mark: repository 작성 <br>
:white_check_mark: service 작성 <br>
  - [ ] controller 작성
  - [ ] view 작성
  - [ ] 배포
<br>

## 목표
+ `Board` - `User` - `Comment` &nbsp; join하기
<figure>
    <img src="https://github.com/beeguriri/SpringBoot-Board/blob/main/diagram.png">
</figure>

+ 게시글 관련
   + 게시글 작성, 수정, 삭제
   + 게시글 상세보기 -> 코멘트 포함
   + 게시글 검색(id/제목/내용)
   + 게시글 페이징
+ 댓글 관련
   + 게시글 내 댓글 작성, 수정, 삭제
+ 사용자 관련
   + 로그인 없이 게시글 목록 확인
   + 회원가입
   + 로그인 시 게시글 조회, 게시글 작성, 댓글 작성 가능
   + 본인이 작성한 글/댓글만 수정,삭제 가능   

<br>

## 작업환경
+ IDEA: IntelliJ
+ Java: 17
+ Gradle 7.6.1
+ Spring Boot 3.0.5
+ `Spring Web` &nbsp; `MySQL Driver` &nbsp; `Spring Data JPA` &nbsp; `Lombok` &nbsp; `Thymeleaf`
