<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>

    <c:choose>
        <c:when test="${flag == 'clear'}">
            <h1>로그인 성공!!</h1>
        </c:when>

        <c:when test="${flag == 'notExist'}">
            <h1>존재하지 않는 아이디입니다.</h1>
            <a href="/hw/s-login-form">다시 로그인하기</a>
        </c:when>

        <c:otherwise>
            <h1>비밀번호가 틀렸습니다.</h1>
            <a href="/hw/s-login-form">다시 로그인하기</a>
        </c:otherwise>
    </c:choose>

</body>
</html>