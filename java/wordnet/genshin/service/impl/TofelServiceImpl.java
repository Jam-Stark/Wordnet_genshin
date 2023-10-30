package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.tofelMapper;
import wordnet.genshin.domain.tofelExample;
import wordnet.genshin.service.TofelService;

@Service(value="TofelService")
public class TofelServiceImpl implements TofelService {

    @Autowired
    private tofelMapper tofelMapper;

    @Override
    public String selectOne(String word) {


        tofelExample tofelexample= new tofelExample();
        tofelExample.Criteria criteria=tofelexample.createCriteria();
        criteria.andWordEqualTo(word);

        return tofelMapper.selectByExample(tofelexample).toString();
    }

    @Override
    public String selectOne(int id){
        return tofelMapper.selectByPrimaryKey(id).toString();
    }
}
