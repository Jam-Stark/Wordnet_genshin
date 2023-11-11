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

import java.util.Date;
import java.util.List;

@Service(value = "FamiliarService")
public class FamiliarServiceImpl implements FamiliarService {

    @Autowired
    private FamiliarMapper familiarMapper;

    @Autowired
    private GuserMapper guserMapper;


    @Override
    public boolean addWord(String word, String uname) {

        boolean flag=true;

        Familiar record=new Familiar();
        record.setUname(uname);
        record.setWord(word);
        if(record.toString().isEmpty()){
            flag=false;
        }
        familiarMapper.insert(record);
        return flag;
    }
public boolean deleteWord(String word,String uname){
        boolean flag=true;

    FamiliarExample familiarExample=new FamiliarExample();
    FamiliarExample.Criteria criteria=familiarExample.createCriteria();
    criteria.andUnameEqualTo(uname).andWordEqualTo(word);

    if(familiarExample.toString().isEmpty()){
        flag=false;
    }

    familiarMapper.deleteByExample(familiarExample);
    return flag;
}
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
    public List<Familiar> selectByuser(String uname) {
        FamiliarExample familiarExample=new FamiliarExample();
        FamiliarExample.Criteria criteria=familiarExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        return familiarMapper.selectByExample(familiarExample);
    }

    ;

}
