package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.ZKMapper;
import wordnet.genshin.domain.ZK;
import wordnet.genshin.domain.ZKExample;
import wordnet.genshin.service.ZkService;

import java.util.ArrayList;
import java.util.List;

@Service(value="ZkService")
public class ZkServiceImpl implements ZkService {

    @Autowired
    private ZKMapper zkMapper;

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
    public List<ZK> selectMuti(Integer from, Integer to) {
        List<ZK> zkList=new ArrayList<ZK>();
        for(;from<to;from++){
            zkList.add(zkMapper.selectByPrimaryKey(from));};
        return zkList;
    }


}
