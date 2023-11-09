package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.OrderdetailMapper;
import vip.epss.dao.OrdersMapper;
import vip.epss.domain.OrderdetailExample;
import vip.epss.domain.Orders;
import vip.epss.service.OrdersService;

@Service(value = "ordersService")
public class OrdersServiceImap implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public Integer deleteById(Integer id) {
        //业务整合
        //1 先删除订单的 详情信息
        OrderdetailExample orderdetailExample = new OrderdetailExample();
        OrderdetailExample.Criteria criteria = orderdetailExample.createCriteria();
        criteria.andFoidEqualTo(id);

        orderdetailMapper.deleteByExample(orderdetailExample);
        //2 删除订单信息
        int i = ordersMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public Orders selectOne(Integer id) {
        return ordersMapper.selectByPrimaryKey(id);
    }
}
