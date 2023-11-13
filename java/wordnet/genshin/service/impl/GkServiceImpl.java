package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.GkMapper;
import wordnet.genshin.domain.Gk;
import wordnet.genshin.domain.GkExample;
import wordnet.genshin.service.GkService;

import java.util.ArrayList;
import java.util.List;

@Service(value="GkService")
public class GkServiceImpl implements GkService {

    @Autowired
    private GkMapper gkMapper;

    @Override
    public List<Gk> selectOne(String word) {


        GkExample gkexample= new GkExample();
        GkExample.Criteria criteria=gkexample.createCriteria();
        criteria.andWordEqualTo(word);

        return gkMapper.selectByExample(gkexample);
    }

    @Override
    public Gk selectOne(int id){
        return gkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Gk> selectMuti(Integer from, Integer to) {
        List<Gk> gkList=new ArrayList<Gk>();
        for(;from<to;from++){
            gkList.add(gkMapper.selectByPrimaryKey(from));};
        return gkList;
    }


}
