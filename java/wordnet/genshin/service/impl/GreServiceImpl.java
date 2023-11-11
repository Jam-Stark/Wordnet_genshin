package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.GreMapper;
import wordnet.genshin.domain.Gre;
import wordnet.genshin.domain.GreExample;
import wordnet.genshin.service.GreService;

import java.util.ArrayList;
import java.util.List;

@Service(value="GreService")
public class GreServiceImpl implements GreService {

    @Autowired
    private GreMapper greMapper;

    @Override
    public List<Gre> selectOne(String word) {


        GreExample greexample= new GreExample();
        GreExample.Criteria criteria=greexample.createCriteria();
        criteria.andWordEqualTo(word);

        return greMapper.selectByExample(greexample);
    }

    @Override
    public Gre selectOne(int id){
        return greMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Gre> selectMuti(Integer from, Integer to) {
        List<Gre> greList=new ArrayList<Gre>();
        for(;from<to;from++){
            greList.add(greMapper.selectByPrimaryKey(from));};
        return greList;
    }


}
