package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.ZK_lMapper;
import wordnet.genshin.domain.ZK_l;
import wordnet.genshin.domain.ZK_lExample;
import wordnet.genshin.service.Zk_lService;
import wordnet.genshin.service.FamiliarService;

import java.util.*;

@Service(value="Zk_lService")
public class Zk_lServiceImpl implements Zk_lService {

    @Autowired
    private ZK_lMapper Zk_lMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<ZK_l> selectOne(String word) {


        ZK_lExample Zk_lexample= new ZK_lExample();
        ZK_lExample.Criteria criteria=Zk_lexample.createCriteria();
        criteria.andWordEqualTo(word);

        return Zk_lMapper.selectByExample(Zk_lexample);
    }

    @Override
    public ZK_l selectOne(int id){
        return Zk_lMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ZK_l> selectMuti(Integer from, Integer to, String uname) {
        List<ZK_l> ZK_lList = new ArrayList<ZK_l>();

        for (; from < to; from++) {
            ZK_lList.add(Zk_lMapper.selectByPrimaryKey(from));
        }

        ZK_lList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (ZK_lList.size() > 15) {
            return ZK_lList.subList(0, 15);
        }

        return ZK_lList;
    }


}