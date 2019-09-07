package cn.wolfcode.cloud.controller;

import cn.wolfcode.cloud.domain.Product;
import cn.wolfcode.cloud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@RestController
public class productController {
    @Autowired
    private IProductService productService;

//    @RequestMapping("/list")
    public List<Product> list(){
        return productService.list();
    }

//    @RequestMapping("/get")
    public Product get(Long id){
        return productService.get(id);
    }

}
