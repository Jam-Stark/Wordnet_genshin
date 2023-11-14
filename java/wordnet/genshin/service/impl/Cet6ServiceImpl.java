package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.Cet6Mapper;
import wordnet.genshin.domain.Cet6;
import wordnet.genshin.domain.Cet6Example;
import wordnet.genshin.domain.Cet6;
import wordnet.genshin.service.Cet6Service;
import wordnet.genshin.service.FamiliarService;

import java.util.ArrayList;
import java.util.List;

@Service(value="Cet6Service")
public class Cet6ServiceImpl implements Cet6Service {

    @Autowired
    private Cet6Mapper cet6Mapper;
    @Autowired
    private FamiliarService familiarService;
    @Override
    public List<Cet6> selectOne(String word) {


        Cet6Example cet6example= new Cet6Example();
        Cet6Example.Criteria criteria=cet6example.createCriteria();
        criteria.andWordEqualTo(word);

        return cet6Mapper.selectByExample(cet6example);
    }

    @Override
    public Cet6 selectOne(int id){
        return cet6Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Cet6> selectMuti(Integer from, Integer to,String uname) {
        List<Cet6> Cet6List = new ArrayList<Cet6>();

        for (; from < to; from++) {
            Cet6List.add(cet6Mapper.selectByPrimaryKey(from));
        }

        Cet6List.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (Cet6List.size() > 15) {
            return Cet6List.subList(0, 15);
        }

        return Cet6List;
    }

}
