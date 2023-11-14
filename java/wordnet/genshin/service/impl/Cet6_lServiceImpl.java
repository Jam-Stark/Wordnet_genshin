package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.Cet6_lMapper;
import wordnet.genshin.domain.Cet6_l;
import wordnet.genshin.domain.Cet6_lExample;
import wordnet.genshin.service.Cet6_lService;
import wordnet.genshin.service.FamiliarService;

import java.util.*;

@Service(value="Cet6_lService")
public class Cet6_lServiceImpl implements Cet6_lService {

    @Autowired
    private Cet6_lMapper cet6_lMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<Cet6_l> selectOne(String word) {


        Cet6_lExample cet6_lexample= new Cet6_lExample();
        Cet6_lExample.Criteria criteria=cet6_lexample.createCriteria();
        criteria.andWordEqualTo(word);

        return cet6_lMapper.selectByExample(cet6_lexample);
    }

    @Override
    public Cet6_l selectOne(int id){
        return cet6_lMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Cet6_l> selectMuti(Integer from, Integer to, String uname) {
        List<Cet6_l> Cet6_lList = new ArrayList<Cet6_l>();

        for (; from < to; from++) {
            Cet6_lList.add(cet6_lMapper.selectByPrimaryKey(from));
        }

        Cet6_lList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (Cet6_lList.size() > 15) {
            return Cet6_lList.subList(0, 15);
        }

        return Cet6_lList;
    }


}