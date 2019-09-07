package cn.wolfcode.cloud.service;

import cn.wolfcode.cloud.domain.Order;

public interface IOrderService {
    Order save(Long userId, Long productId);
}
