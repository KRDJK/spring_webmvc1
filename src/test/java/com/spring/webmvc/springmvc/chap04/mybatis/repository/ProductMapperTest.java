package com.spring.webmvc.springmvc.chap04.mybatis.repository;

import com.spring.webmvc.springmvc.chap04.mybatis.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {

    @Autowired
    ProductMapper mapper;

    @Test
    @DisplayName("제품 정보를 등록해야 한다.")
    void saveTest() {
        for (int i = 0; i < 10; i++) {
            Product pro = new Product();
            pro.setProductName("좋은 제품" + i);
            pro.setPrice(10000 + 100 * i);

            mapper.save(pro);
        }
    }
}