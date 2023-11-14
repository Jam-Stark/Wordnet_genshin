package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.GRE_lMapper;
import wordnet.genshin.domain.GRE_l;
import wordnet.genshin.domain.GRE_lExample;
import wordnet.genshin.service.Gre_lService;
import wordnet.genshin.service.FamiliarService;

import java.util.*;

@Service(value="Gre_lService")
public class Gre_lServiceImpl implements Gre_lService {

    @Autowired
    private GRE_lMapper gre_l_lMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<GRE_l> selectOne(String word) {


        GRE_lExample gre_l_lexample= new GRE_lExample();
        GRE_lExample.Criteria criteria=gre_l_lexample.createCriteria();
        criteria.andWordEqualTo(word);

        return gre_l_lMapper.selectByExample(gre_l_lexample);
    }

    @Override
    public GRE_l selectOne(int id){
        return gre_l_lMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GRE_l> selectMuti(Integer from, Integer to, String uname) {
        List<GRE_l> GRE_lList = new ArrayList<GRE_l>();

        for (; from < to; from++) {
            GRE_lList.add(gre_l_lMapper.selectByPrimaryKey(from));
        }

        GRE_lList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (GRE_lList.size() > 15) {
            return GRE_lList.subList(0, 15);
        }

        return GRE_lList;
    }


}