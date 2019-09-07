package cn.wolfcode.cloud.service.impl;

import cn.wolfcode.cloud.domain.Order;
import cn.wolfcode.cloud.domain.Product;
import cn.wolfcode.cloud.feign.ProductFeignApi;
import cn.wolfcode.cloud.service.IOrderService;
import cn.wolfcode.cloud.service.IProductService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {
    @Reference
    private IProductService productService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductFeignApi productFeignApi;

    @Override
    public Order save(Long userId, Long productId) {
        log.info("OrderServiceImpl:接收的请求参数:userId:{},productId:{}",userId,productId);

//        Product product = restTemplate.getForObject("http://PRODUCT-SERVER/get?id="+productId, Product.class);

//        Product product =new Product();//远程获取

        Product product = productFeignApi.find(productId);
        Order order = new Order();
        order.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        order.setCreateTime(new Date());
        order.setUserId(userId);
        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());
        System.out.println("执行保存订单操作");
        log.info("OrderServiceImpl: 响应的数据:{}",order.toString());
        return order;
    }
}