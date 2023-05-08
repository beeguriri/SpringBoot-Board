# SpringBoot-Board
+ `Springboot` &nbsp;`JPA` &nbsp; `MySQL` 이용한 게시판 만들기 <br>
:white_check_mark: member-board-comment join <br>
:white_check_mark: board, comment CRUD <br>
:white_check_mark: member CRU <br>
:white_check_mark: `AuditingEntityListener`로 입력, 수정시간 자동 반영 <br>
:white_check_mark: `pagable` 이용한 페이징 <br>
:white_check_mark: `security` 이용한 사용자 로그인 하기 <br>
:white_check_mark: `thymeleaf` 이용한 View 작성 <br>

<br>

## 작업환경
+ IDE: IntelliJ
+ Java: 17
+ Gradle 7.6.1
+ Spring Boot 3.0.5
+ `Spring Web` &nbsp; `MySQL Driver` &nbsp; `Spring Data JPA` &nbsp; `Lombok` &nbsp; `Thymeleaf` &nbsp; `security`

<br>

## ERD
+ `Board` - `User` - `Comment` &nbsp; join하기
<figure align="center">
  <img src="https://github.com/beeguriri/SpringBoot-Board/blob/main/image/erd.png">
</figure>

## API 명세
#### 📑 board

| Address        | Method        |                                      |                                       |
| -------------- | ------------- | ------------------------------------ | ------------------------------------- |
| "/boardList"   | Get           | getBoardList()                       | Model                                 |
| "/getBoard"    | Get           | getBoard()                           | Model<br />@AuthenticationPrincipal*  |
| "/insertBoard" | Get<br />Post | insertBoardView()<br />insertBoard() | Model<br />*@AuthenticationPrincipal* |
| "/updateBoard" | Get<br />Post | updateBoardView()<br />updatdBoard() | Model                                 |
| "/deleteBoard" | Get           | deleteBoard()                        |                                       |

   + 게시글 작성, 수정, 삭제
   + 게시글 상세보기 -> 댓글 포함
   + 게시글 검색(내용)
   + 게시글 페이징
   
#### 📑 comment

| Address          | Method        |                                          |                                                              |
| ---------------- | ------------- | ---------------------------------------- | ------------------------------------------------------------ |
| "/addComment"    | Post          | addComment()                             | *@AuthenticationPrincipal*<br />RedirectAttributes<br />"redirect:getBoard?seq={seq}" |
| "/updateComment" | Get<br />Post | updateCommentView()<br />updateComment() | Model<br />RedirectAttributes<br />"redirect:getBoard?seq={seq}" |
| "/deleteComment" | Get           | deleteComment()                          | RedirectAttributes<br />"redirect:getBoard?seq={seq}"        |

   + 게시글 내 댓글 리스트, 입력, 수정, 삭제
   
#### 📑 member, security

| Address   | Method |          |
| --------- | ------ | -------- |
| "/login"  | Get    | login()  |
| "/join"   | Get    | join()   |
| "/logout" | Get    | logout() |

| Address         | Method        |                                        |                                 |
| --------------- | ------------- | -------------------------------------- | ------------------------------- |
| "/join"         | Post          | joinMember()                           | "redirect:login"                |
| "/updateMember" | Get<br />Post | updateMemberView()<br />updateMember() | Model<br />"redirect:boardList" |

   + 회원가입
   + 로그인 후 회원정보 수정
   + 로그인 후 게시글 조회, 게시글 작성, 댓글 작성 가능
   + 본인이 작성한 글/댓글만 수정,삭제 가능   
   
<br>

## View (참고)
+ css는 일부만 작성
<figure>
  <img src="https://github.com/beeguriri/SpringBoot-Board/blob/main/image/login.png">
  <img src="https://github.com/beeguriri/SpringBoot-Board/blob/main/image/boardLists.png">
  <img src="https://github.com/beeguriri/SpringBoot-Board/blob/main/image/board.png">
</figure>

## 언젠가 해보고 싶은 것
+ member의 role이 admin일때는 모든 게시글, 댓글 삭제할 수 있는 기능
+ 비밀번호 암호화해서 DB 저장
+ 다른 html 파일들도 조금 예쁘게...
+ OAuth2.0 이용해서 구글/네이버/카카오 로그인도 가능하도록
