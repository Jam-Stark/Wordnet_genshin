package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.epss.domain.Orders;
import vip.epss.service.OrdersService;
import vip.epss.utils.MessageAndData;
//http://localhost:8080/ssmDemo_war/orders
//orders/del?id=8



@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "opt/{num}",method = RequestMethod.DELETE)
    public MessageAndData deleteOrder(@PathVariable("num")Integer id){
        ordersService.deleteById(id);
        return MessageAndData.success().setMessage("删除成功");
    }

    @RequestMapping(value = "opt/{num}",method = RequestMethod.GET)
    public MessageAndData getOrder(@PathVariable("num")Integer id){
        Orders orders = ordersService.selectOne(id);

        if(orders == null){
            return MessageAndData.error().setMessage("未查询到");
        }else{
            return MessageAndData.success().setMessage("查询成功").add("orders",orders);
        }
    }
}