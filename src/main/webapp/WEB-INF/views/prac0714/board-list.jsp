<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아무튼 게시판 화면</title>

<style>

    

</style>

</head>
<body>

    <h1> 아무튼 게시판 </h1>

    <ul>
        <!-- <li>
            # 글 번호 ||            # 글 제목             || # 작성자 || # 조회수 ||  # 등록일자
        </li> -->
        <c:forEach var="c" items="${contentList}">
            <li>
                # 글 번호 : ${c.boardNum} || # 제목 : <a href="/board/content?boardNum=${c.boardNum}">${c.title}</a>|| # 작성자 : ${c.writer} || 조회수: ${c.viewCount} || 등록일자
            </li>
        </c:forEach>
    </ul>


    <div>
        <a href="/board/write">글쓰기</a>
    </div>
</body>
</html>