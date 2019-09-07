package cn.wolfcode.cloud.service.impl;

import cn.wolfcode.cloud.domain.Product;
import cn.wolfcode.cloud.mapper.ProductMapper;
import cn.wolfcode.cloud.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Value("${server.port}")
    private String port;

    @Override
    public List<Product> list() {
        return productMapper.list();
    }

    @Override
    public Product get(Long productId) {
        System.out.println("正常feign");


        Product product = productMapper.get(productId);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(product.getName()+" 这是端口: "+port);
     /*   try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("开始调用"+port);
        return result;
    }
}
