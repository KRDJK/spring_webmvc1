<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 수정 화면</title>
</head>
<body>

    <h1>${c.boardNum}번 게시글 수정 화면</h1>

    <form action="/board/modify" method="post">
        <input type="hidden" name="boardNum" value="${c.boardNum}">
        <input type="hidden" name="regDate" value="${c.regDate}">
        <input type="hidden" name="viewCount" value="${c.viewCount}">



        <label>
            <h2>작성자</h2>
            <input type="text" name="writer" value="${c.writer}">
        </label>
        <label>
            <h2>글 제목</h2>
            <input type="text" name="title" value="${c.title}">
        </label>
        <label>
            <h2>내용</h2>
            <textarea name="content" cols="30" rows="10">${c.content}</textarea>
        </label>

        <button type="submit">수정하기</button>
    </form>

</body>
</html>