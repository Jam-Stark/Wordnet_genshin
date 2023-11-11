package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.service.FamiliarService;
import wordnet.genshin.dao.FamiliarMapper;
import wordnet.genshin.domain.Familiar;
import wordnet.genshin.domain.FamiliarExample;

import wordnet.genshin.dao.GuserMapper;
import wordnet.genshin.domain.Guser;
import wordnet.genshin.domain.GuserExample;
import wordnet.genshin.service.GuserService;

import java.util.List;

@Service(value = "FamiliarService")
public class FamiliarServiceImpl implements FamiliarService {

    @Autowired
    private FamiliarMapper familiarMapper;

    @Autowired
    private GuserMapper guserMapper;


    @Override
    public boolean detectWord(String word,String uname){

        boolean flag=false;

        FamiliarExample familiarExample=new FamiliarExample();
        FamiliarExample.Criteria criteria=familiarExample.createCriteria();
        criteria.andUnameEqualTo(uname);

//        GuserExample guserExample=new GuserExample();
//        GuserExample.Criteria gcriteria=guserExample.createCriteria();
//        gcriteria.andUnameEqualTo(uname);

        List<Familiar> familiarList=familiarMapper.selectByExample(familiarExample);
//        guserMapper.selectByExample(guserExample).isEmpty()

        for (Familiar familiar : familiarList) {
            if (word.equals(familiar.getWord())) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    @Override
    public List<Familiar> selectAll() {
        FamiliarExample familiarExample=new FamiliarExample();
        FamiliarExample.Criteria criteria=familiarExample.createCriteria();
        criteria.andFidGreaterThan(0);

        return familiarMapper.selectByExample(familiarExample);
    }

    ;

}
