package cn.wolfcode.cloud.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Order implements Serializable {
    private String orderNo;
    private Date createTime;
    private String productName;
    private int productPrice;
    private Long userId;
}
