package com.spring.webmvc.springmvc.chap01;

import lombok.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private int oNum;
    private String goods;
    private int amount;
    private int price;

}
