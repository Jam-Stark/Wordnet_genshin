package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.Ielts_lMapper;
import wordnet.genshin.domain.Ielts_l;
import wordnet.genshin.domain.Ielts_lExample;
import wordnet.genshin.service.Ielts_lService;
import wordnet.genshin.service.FamiliarService;

import java.util.*;

@Service(value="Ielts_lService")
public class Ielts_lServiceImpl implements Ielts_lService {

    @Autowired
    private Ielts_lMapper ielts_lMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<Ielts_l> selectOne(String word) {


        Ielts_lExample ielts_lExample= new Ielts_lExample();
        Ielts_lExample.Criteria criteria=ielts_lExample.createCriteria();
        criteria.andWordEqualTo(word);

        return ielts_lMapper.selectByExample(ielts_lExample);
    }

    @Override
    public Ielts_l selectOne(int id){
        return ielts_lMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ielts_l> selectMuti(Integer from, Integer to, String uname) {
        List<Ielts_l> Ielts_lList = new ArrayList<Ielts_l>();

        for (; from < to; from++) {
            Ielts_lList.add(ielts_lMapper.selectByPrimaryKey(from));
        }

        Ielts_lList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (Ielts_lList.size() > 15) {
            return Ielts_lList.subList(0, 15);
        }

        return Ielts_lList;
    }


}