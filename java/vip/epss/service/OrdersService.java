package vip.epss.service;

import vip.epss.domain.Orders;

public interface OrdersService {
    public Integer deleteById(Integer id);
    public Orders selectOne(Integer id);
}
