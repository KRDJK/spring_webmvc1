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

    <h1>${member.userNum}번 회원 상세 정보</h1>
    <ul>
        <li># 계정명: ${member.account}</li>
        <li># 비번: ${member.password}</li>
        <li># 이름: ${member.userName}</li>
    </ul>

</body>
</html>