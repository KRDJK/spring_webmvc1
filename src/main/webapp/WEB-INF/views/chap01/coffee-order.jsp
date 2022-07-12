<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Coffee-Shop</title>
</head>
<body>

    <div class="wrapper">
        <h1>커피 주문서</h1>
        
        <div class="container">
            <h2># 주문 목록</h2>
            
            <form action="/coffee/check" method="get">
                <label>
                    <select name="coffeeName" id="coffee-name" size="3">
                        <optgroup label="커피">
                            <option value="아메리카노">아메리카노</option>
                            <option value="카페라떼">카페라떼</option>
                        </optgroup>
    
                        <optgroup label="음료">
                            <option value="복숭아 아이스티">복숭아 아이스티</option>
                        </optgroup>
    
                    </select>
                    <h2 id="price"># 가격: </h2>
                    <button type="submit">주문하기</button>
                </label>
            </form>

        </div>
    </div>


    <script>

        const $select = document.querySelector('select');
        const $price = document.getElementById('price');

        $select.addEventListener('change',  (e) => {
            console.log(e.target);
            
        });

    </script>

</body>
</html>