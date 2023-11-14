package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.GK_lMapper;
import wordnet.genshin.domain.GK_l;
import wordnet.genshin.domain.GK_lExample;
import wordnet.genshin.service.Gk_lService;
import wordnet.genshin.service.FamiliarService;

import java.util.*;

@Service(value="Gk_lService")
public class Gk_lServiceImpl implements Gk_lService {

    @Autowired
    private GK_lMapper Gk_lMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<GK_l> selectOne(String word) {


        GK_lExample Gk_lexample= new GK_lExample();
        GK_lExample.Criteria criteria=Gk_lexample.createCriteria();
        criteria.andWordEqualTo(word);

        return Gk_lMapper.selectByExample(Gk_lexample);
    }

    @Override
    public GK_l selectOne(int id){
        return Gk_lMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GK_l> selectMuti(Integer from, Integer to, String uname) {
        List<GK_l> GK_lList = new ArrayList<GK_l>();

        for (; from < to; from++) {
            GK_lList.add(Gk_lMapper.selectByPrimaryKey(from));
        }

        GK_lList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (GK_lList.size() > 15) {
            return GK_lList.subList(0, 15);
        }

        return GK_lList;
    }


}