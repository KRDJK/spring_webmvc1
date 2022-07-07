<%@ page contentType="text/html; charset=UTF-8" language="java" %>

                                                <!-- jstl을 쓰려면 필요함 -->
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

    
    <h1>blah.jsp입니다~~ 이 파일은 서버에서만 접근 가능합니다.</h1>

    <p>
        <!-- <%= request.getAttribute("msg") %> 이 자바코드가 ${msg}로 퉁쳐진다. -->
        서버에서 온 메시지: ${msg}
        <br>
        서버에서 온 숫자: ${number * 3}
        <br>
        <!-- 서버에서 온 리스트: ${hobbys.get(0)} -->
        서버에서 온 리스트: ${hobbys}
        <br>


        <!-- jstl을 이용한 반복문 (iter)-->
                                    <!-- 맵이라면 hobbys.keySet(), 리스트, 배열도 가능 -->
        <c:forEach var="h" items="${hobbys}">
            # 취미 : ${h} <br>
        </c:forEach>


        <!-- jstl을 이용한 fori 반복문 -->
                            <!-- 1부터 시작해서 10까지인거임 i<=10 step은 1++ 만약 step에 -1이었으면 i를 1씩 감소 -->
        <c:forEach var="i" begin="1" end="10" step="1">
            ${i}!!
        </c:forEach>


        <br>


        <!-- jstl 활용 if문 -->
        <c:if test="${number == 100}">
            서버에서 온 숫자는 100과 같습니다!!
        </c:if>


        <br>


        <!-- 다중 if문 -->
        <c:choose>
            <c:when test="${hobbys.size() > 1}">
                취미가 2개 이상 있습니다~~~
            </c:when>

            <c:when test="${hobbys.size() == 1}">
                취미가 1개 있습니다~~~
            </c:when>

            <c:otherwise>
                취미가 없습니다~~~
            </c:otherwise>
        </c:choose>


    </p>

</body>
</html>