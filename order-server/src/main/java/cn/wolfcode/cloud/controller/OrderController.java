package cn.wolfcode.cloud.controller;

import cn.wolfcode.cloud.domain.Order;
import cn.wolfcode.cloud.service.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping
    @HystrixCommand(fallbackMethod ="saveFail")
    public Order save(Long userId, Long productId, HttpServletRequest request){
        log.info("订单服务:接收的请求参数:userId:{},productId:{}",userId,productId);
        log.info("正常业务处理");
        //获取请求中的token和cookie
        String token = request.getHeader("token");
        String cookie = request.getHeader("cookie");
        System.out.println(token);
        System.out.println(cookie);
        log.info("请求头信息: token:{},cookie:{}",token,cookie);
        if(userId%2==0){
            int a=1/0;
        }
        Order order = orderService.save(userId, productId);
        log.info("订单服务: 响应的数据:{}", order.toString());
        return order;
    }


    public Order saveFail(Long userId, Long productId,HttpServletRequest request){
        log.info("hystrix在前端熔断-执行失败调用");


        new Thread(){
            @Override
            public void run() {
                //熔断后定时20分钟给运维发短信
                //定时reids 先去redis里面去取key,看有没有,有就是发过
                Boolean flag = redisTemplate.hasKey("order-server");
                if(!flag){
                    log.info("运营人员,请尽快处理订单系统业务问题");
                    redisTemplate.opsForValue().set("order-server","msg",10, TimeUnit.SECONDS);
                }else {
                    log.info("已经发过短信了");
                }
            }
        }.start();


        Order order = new Order();
        return order;
    }
}