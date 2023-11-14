package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.Cet4_lMapper;
import wordnet.genshin.domain.Cet4_l;
import wordnet.genshin.domain.Cet4_lExample;
import wordnet.genshin.service.Cet4_lService;
import wordnet.genshin.service.FamiliarService;

import java.util.*;

@Service(value="Cet4_lService")
public class Cet4_lServiceImpl implements Cet4_lService {

    @Autowired
    private Cet4_lMapper cet4_lMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<Cet4_l> selectOne(String word) {


        Cet4_lExample cet4_lexample= new Cet4_lExample();
        Cet4_lExample.Criteria criteria=cet4_lexample.createCriteria();
        criteria.andWordEqualTo(word);

        return cet4_lMapper.selectByExample(cet4_lexample);
    }

    @Override
    public Cet4_l selectOne(int id){
        return cet4_lMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Cet4_l> selectMuti(Integer from, Integer to, String uname) {
        List<Cet4_l> Cet4_lList = new ArrayList<Cet4_l>();

        for (; from < to; from++) {
            Cet4_lList.add(cet4_lMapper.selectByPrimaryKey(from));
        }

        Cet4_lList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (Cet4_lList.size() > 15) {
            return Cet4_lList.subList(0, 15);
        }

        return Cet4_lList;
    }


}