package cn.wolfcode.cloud.controller;

import cn.wolfcode.cloud.domain.Product;
import cn.wolfcode.cloud.feign.ProductFeignApi;
import cn.wolfcode.cloud.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductFeignClient implements ProductFeignApi {
    @Autowired
    private IProductService productService;
    @Value("${server.port}")
    private String port;
    @Override
    public Product find(Long id) {
        log.info("商品服务:接收的请求参数:id:{}",id);
        Product product = productService.get(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(result.getName()+",data from "+port);
        log.info("商品服务: 响应的数据:{}", result.toString());
        return result;
    }
}