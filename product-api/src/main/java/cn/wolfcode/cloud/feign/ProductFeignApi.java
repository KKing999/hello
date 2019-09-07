package cn.wolfcode.cloud.feign;

import cn.wolfcode.cloud.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-server",fallback = ProductFeignHystrix.class)
public interface ProductFeignApi {
    @RequestMapping("find")
    Product find(@RequestParam("id") Long id);
}