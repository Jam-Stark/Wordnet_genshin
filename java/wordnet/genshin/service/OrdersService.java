package wordnet.genshin.service;

import wordnet.genshin.domain.Orders;

public interface OrdersService {
    public Integer deleteById(Integer id);
    public Orders selectOne(Integer id);
}
