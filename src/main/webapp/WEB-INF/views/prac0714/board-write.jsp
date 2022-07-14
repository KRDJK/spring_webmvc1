<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글 작성화면</title>
</head>
<body>

    <h1>글 작성하기</h1>

    <form action="/board/write" method="post">
        <label>
            <h2>작성자</h2>
            <input type="text" name="writer">
        </label>
        <label>
            <h2>글 제목</h2>
            <input type="text" name="title">
        </label>
        <label>
            <h2>내용</h2>
            <textarea name="content" cols="30" rows="10"></textarea>
        </label>

        <button type="submit">작성하기</button>
    </form>

</body>
</html>