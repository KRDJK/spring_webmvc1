<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <ul>
    
        <h1>MVC버전 목록보기</h1>

        <c:forEach var="member" items="${mList}">
            <li>
                <!-- 멤버 클래스의 필드명을 그대로 써도 된다. 다만!! 멤버 클래스에서 필드별 getter 메서드가 생성 되어있어야 함. -->
                # 회원번호 : ${member.userNum}, 
                아이디: ${member.account}, 
                <a href="/mvc/v4/member?userNum=${member.userNum}">
                    이름: ${member.userName}
                </a> 

                &nbsp;&nbsp;&nbsp;
                <a id="rm-btn" href="/mvc/v4/remove?userNum=${member.userNum}">[delete]</a>

            </li>
        </c:forEach>

        
    </ul>

    <a href="/mvc/join">새로운 회원가입하기</a>
    
    <script>

        const $rmBtn = document.getElementById('rm-btn');
        $rmBtn.addEventListener('click', e => {
            
            if (!confirm('진짜루 삭제???')) {
                // 삭제 취소
                e.preventDefault(); // 링크 이동 중지
                return;
            } 
            // const userNum = '${member.userNum}';
            // 삭제 진행
            // location.href = '/mvc/v4/remove?userNum=' + userNum;
        });

    </script>


</body>
</html>