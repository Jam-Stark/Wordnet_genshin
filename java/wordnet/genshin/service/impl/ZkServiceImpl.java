package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.ZKMapper;
import wordnet.genshin.domain.ZK;
import wordnet.genshin.domain.ZK;
import wordnet.genshin.domain.ZKExample;
import wordnet.genshin.service.FamiliarService;
import wordnet.genshin.service.ZkService;

import java.util.ArrayList;
import java.util.List;

@Service(value="ZkService")
public class ZkServiceImpl implements ZkService {

    @Autowired
    private ZKMapper zkMapper;
    @Autowired
    private FamiliarService familiarService;
    @Override
    public List<ZK> selectOne(String word) {


        ZKExample zkexample= new ZKExample();
        ZKExample.Criteria criteria=zkexample.createCriteria();
        criteria.andWordEqualTo(word);

        return zkMapper.selectByExample(zkexample);
    }

    @Override
    public ZK selectOne(int id){
        return zkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ZK> selectMuti(Integer from, Integer to, String uname) {
        List<ZK> ZKList = new ArrayList<ZK>();

        for (; from < to; from++) {
            ZKList.add(zkMapper.selectByPrimaryKey(from));
        }

        ZKList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (ZKList.size() > 15) {
            return ZKList.subList(0, 15);
        }

        return ZKList;
    }


}
