package cn.wolfcode.cloud.feign;

import cn.wolfcode.cloud.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductFeignHystrix implements ProductFeignApi{
    //feign熔断降级
    @Override
    public Product find(Long id) {
        Product product = new Product();
        log.info("兜底Hystrix在feign");
        product.setName("兜底数据");
        product.setPrice(1);
        product.setStock(0);
        return product;
    }
}
