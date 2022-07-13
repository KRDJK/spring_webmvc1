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
            
            <form action="/coffee/check" method="post">
                <label>
                    <select name="menu" id="coffee-name" size="3">
                        <optgroup label="커피">
                            <option value="아메리카노">아메리카노</option>
                            <option value="카페라떼">카페라떼</option>
                        </optgroup>
    
                        <optgroup label="음료">
                            <option value="아이스티">아이스티</option>
                        </optgroup>
    
                    </select>
                    
                    <br>

                    <label class="price"># 가격: 3000원</label>
                    <input id="price-tag" type="hidden" name="price" value="3000">

                    <br>

                    <button type="submit">주문하기</button>
                </label>
            </form>

        </div>
    </div>


    <script>

        const coffeePriceList = {
                아메리카노: 3000,
                카페라떼: 4500,
                아이스티: 4000,
            };

        const $select = document.querySelector('select');
        const $priceTag = document.getElementById('price-tag');

        $select.addEventListener('change',  (e) => {
            console.log(e.target.value);
            const price = coffeePriceList[e.target.value];

            const $priceLabel = document.querySelector('.price');
            $priceLabel.textContent = '# 가격: ' + price + "원";

            const $priceTag = document.getElementById('price-tag');
            $priceTag.value = price;

        });

    </script>

</body>
</html>