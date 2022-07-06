<!-- 여기 전체가 서블릿으로 바뀐다. -->
<!-- html과 똑같지만 jsp는 코드 사이에 자바 코드를 끼워넣을 수 있다. -->

<!-- 이게 jsp라고 티를 내는 것이다.. .jsp라고 하는 것만으로는 .html과의 차이점이 있다고 인식되지 않나보다. -->
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <% for (int i = 0; i < 3; i++) { %>
        <h1>test.jsp 입니다~~~ 하하호호</h1>
    <% } %>

    <%
        String[] arr = {"감자", "고구마", "당근"};
        for (String s : arr) {
    %>
        <h2> <%= s %> 캐러 가자! </h2>
    <% } %>

</body>
</html>