package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.ZkMapper;
import wordnet.genshin.domain.Zk;
import wordnet.genshin.domain.ZkExample;
import wordnet.genshin.service.ZkService;

import java.util.ArrayList;
import java.util.List;

@Service(value="ZkService")
public class ZkServiceImpl implements ZkService {

    @Autowired
    private ZkMapper zkMapper;

    @Override
    public List<Zk> selectOne(String word) {


        ZkExample zkexample= new ZkExample();
        ZkExample.Criteria criteria=zkexample.createCriteria();
        criteria.andWordEqualTo(word);

        return zkMapper.selectByExample(zkexample);
    }

    @Override
    public Zk selectOne(int id){
        return zkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Zk> selectMuti(Integer from, Integer to) {
        List<Zk> zkList=new ArrayList<Zk>();
        for(;from<to;from++){
            zkList.add(zkMapper.selectByPrimaryKey(from));};
        return zkList;
    }


}
