<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상세정보 조회</title>
</head>
<body>

    <h1># 글 번호 ${c.boardNum}번 게시글 정보</h1>
    
    <br>

    <ul>
        <li># 제목 : ${c.title}</li>
        <li># 작성자 : ${c.writer}</li>
        <li># 본문 내용 : ${c.content}</li>
        <li># 조회수 : ${c.viewCount}</li>
        <li># 등록일자 : ${c.regDate}</li>
    </ul>

    <a href="/board/delete?boardNum=${c.boardNum}">게시글 삭제</a>

    <br>

    <a href="/board/modify?boardNum=${c.boardNum}">게시글 수정</a>

    <br>

    <a href="/board/list">게시판 메인으로 돌아가기</a>

</body>
</html>