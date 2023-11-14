package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.Tofel_lMapper;
import wordnet.genshin.domain.Tofel_l;
import wordnet.genshin.domain.Tofel_lExample;
import wordnet.genshin.service.Tofel_lService;
import wordnet.genshin.service.FamiliarService;

import java.util.*;

@Service(value="Tofel_lService")
public class Tofel_lServiceImpl implements Tofel_lService {

    @Autowired
    private Tofel_lMapper tofel_lMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<Tofel_l> selectOne(String word) {


        Tofel_lExample tofel_lexample= new Tofel_lExample();
        Tofel_lExample.Criteria criteria=tofel_lexample.createCriteria();
        criteria.andWordEqualTo(word);

        return tofel_lMapper.selectByExample(tofel_lexample);
    }

    @Override
    public Tofel_l selectOne(int id){
        return tofel_lMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tofel_l> selectMuti(Integer from, Integer to, String uname) {
        List<Tofel_l> Tofel_lList = new ArrayList<Tofel_l>();

        for (; from < to; from++) {
            Tofel_lList.add(tofel_lMapper.selectByPrimaryKey(from));
        }

        Tofel_lList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (Tofel_lList.size() > 15) {
            return Tofel_lList.subList(0, 15);
        }

        return Tofel_lList;
    }


}