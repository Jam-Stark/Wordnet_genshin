package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.service.FamiliarService;
import wordnet.genshin.dao.FamiliarMapper;
import wordnet.genshin.domain.Familiar;
import wordnet.genshin.domain.FamiliarExample;

import java.util.List;

@Service(value = "FamiliarService")
public class FamiliarServiceImpl implements FamiliarService {

    @Autowired
    private FamiliarMapper familiarMapper;

    @Override
    public boolean detectWord(String word){

        boolean flag=false;

        FamiliarExample familiarExample=new FamiliarExample();
        FamiliarExample.Criteria criteria=familiarExample.createCriteria();
        criteria.andFidGreaterThan(0);

        List<Familiar> familiarList=familiarMapper.selectByExample(familiarExample);

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
