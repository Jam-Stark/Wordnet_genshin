package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.GREMapper;
import wordnet.genshin.domain.GRE;
import wordnet.genshin.domain.GREExample;
import wordnet.genshin.service.GreService;

import java.util.ArrayList;
import java.util.List;

@Service(value="GreService")
public class GreServiceImpl implements GreService {

    @Autowired
    private GREMapper greMapper;

    @Override
    public List<GRE> selectOne(String word) {


        GREExample greexample= new GREExample();
        GREExample.Criteria criteria=greexample.createCriteria();
        criteria.andWordEqualTo(word);

        return greMapper.selectByExample(greexample);
    }

    @Override
    public GRE selectOne(int id){
        return greMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GRE> selectMuti(Integer from, Integer to) {
        List<GRE> greList=new ArrayList<GRE>();
        for(;from<to;from++){
            greList.add(greMapper.selectByPrimaryKey(from));};
        return greList;
    }


}
