package cn.wolfcode.cloud.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor@NoArgsConstructor
public class Product implements Serializable {
    private Long id;//商品id
    private String name;//商品名称
    private int price;//商品价格
    private int stock;//商品库存
}