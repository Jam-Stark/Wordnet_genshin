package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.Cet4Mapper;
import wordnet.genshin.domain.Cet4;
import wordnet.genshin.domain.Cet4Example;
import wordnet.genshin.service.Cet4Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="Cet4Service")
public class Cet4ServiceImpl implements Cet4Service {

    @Autowired
    private Cet4Mapper cet4Mapper;

    @Override
    public List<Cet4> selectOne(String word) {


        Cet4Example cet4example= new Cet4Example();
        Cet4Example.Criteria criteria=cet4example.createCriteria();
        criteria.andWordEqualTo(word);

        return cet4Mapper.selectByExample(cet4example);
    }

    @Override
    public Cet4 selectOne(int id){
        return cet4Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Cet4> selectMuti(Integer from, Integer to) {
        List<Cet4> cet4List=new ArrayList<Cet4>();
        for(;from<to;from++){
            cet4List.add(cet4Mapper.selectByPrimaryKey(from));};
        return cet4List;
    }


}
