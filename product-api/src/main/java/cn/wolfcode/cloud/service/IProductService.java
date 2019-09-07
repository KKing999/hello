package cn.wolfcode.cloud.service;

import cn.wolfcode.cloud.domain.Product;

import java.util.List;

public interface IProductService {
    /**
     * 查询所有商品信息
     * @return
     */
    List<Product> list();

    /**
     * 查询指定商品信息
     * @return
     */
    Product get(Long productId);
}
