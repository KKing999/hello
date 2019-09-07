package cn.wolfcode.cloud.mapper;

import cn.wolfcode.cloud.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Component
public class ProductMapper {
    private HashMap<Long,Product> hashMap=new HashMap<>();

    public ProductMapper(){
        Product p1 = new Product(1L, "小米", 1999, 10);
        Product p2 = new Product(2L, "华为", 2999, 10);
        Product p3 = new Product(3L, "oppo", 3999, 10);
        Product p4 = new Product(4L, "vivo", 4999, 10);
        Product p5 = new Product(5L, "apple", 5999, 10);
        hashMap.put(p1.getId(),p1);
        hashMap.put(p2.getId(),p2);
        hashMap.put(p3.getId(),p3);
        hashMap.put(p4.getId(),p4);
        hashMap.put(p5.getId(),p5);
    }
    public List<Product> list(){
        Collection<Product> values = hashMap.values();
        ArrayList<Product> products = new ArrayList<>(values);
        return products;
    }

    public Product get(Long id){
        return hashMap.get(id);
    }

}
