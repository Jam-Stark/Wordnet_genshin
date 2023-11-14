package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.GKMapper;
import wordnet.genshin.domain.GK;
import wordnet.genshin.domain.GKExample;
import wordnet.genshin.service.GkService;

import java.util.ArrayList;
import java.util.List;

@Service(value="GkService")
public class GkServiceImpl implements GkService {

    @Autowired
    private GKMapper gkMapper;

    @Override
    public List<GK> selectOne(String word) {


        GKExample gkexample= new GKExample();
        GKExample.Criteria criteria=gkexample.createCriteria();
        criteria.andWordEqualTo(word);

        return gkMapper.selectByExample(gkexample);
    }

    @Override
    public GK selectOne(int id){
        return gkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GK> selectMuti(Integer from, Integer to) {
        List<GK> gkList=new ArrayList<GK>();
        for(;from<to;from++){
            gkList.add(gkMapper.selectByPrimaryKey(from));};
        return gkList;
    }


}
