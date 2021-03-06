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


    @Test
    @DisplayName("특정 제품번호를 주면 해당하는 제품이 삭제되어야 한다.")
    void removeTest() {

        boolean flag = mapper.remove("202207200007");

        assertTrue(flag);
    }


    @Test
    @DisplayName("수정 정보를 주면 해당 시리얼넘버를 가진 제품의 정보가 수정되어야 한다.")
    void modifyTest() {

        Product pro = new Product();
        pro.setSerialNo("202207200005");
        pro.setProductName("수정제품");
        pro.setPrice(99999);

        boolean flag = mapper.modify(pro);

        assertTrue(flag);
    }


    @Test
    @DisplayName("제품 정보를 전체 조회해야 한다.")
    void findAllTest() {

        mapper.findAll().forEach(System.out::println);
    }


    @Test
    @DisplayName("제품 고유 번호를 주면 해당 번호를 가진 제품을 조회해야 한다.")
    void findOneTest() {

        Product product = mapper.findOne("202207200009");
        System.out.println("product = " + product);
    }
}