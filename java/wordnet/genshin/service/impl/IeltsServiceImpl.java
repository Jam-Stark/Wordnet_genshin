package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.IeltsMapper;
import wordnet.genshin.domain.Ielts;
import wordnet.genshin.domain.IeltsExample;
import wordnet.genshin.domain.Ielts;
import wordnet.genshin.service.FamiliarService;
import wordnet.genshin.service.IeltsService;

import java.util.ArrayList;
import java.util.List;

@Service(value="IeltsService")
public class IeltsServiceImpl implements IeltsService {

    @Autowired
    private IeltsMapper ieltsMapper;
    @Autowired
    private FamiliarService familiarService;

    @Override
    public List<Ielts> selectOne(String word) {


        IeltsExample ieltsexample= new IeltsExample();
        IeltsExample.Criteria criteria=ieltsexample.createCriteria();
        criteria.andWordEqualTo(word);

        return ieltsMapper.selectByExample(ieltsexample);
    }

    @Override
    public Ielts selectOne(int id){
        return ieltsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ielts> selectMuti(Integer from, Integer to, String uname) {
        List<Ielts> IeltsList = new ArrayList<Ielts>();

        for (; from < to; from++) {
            IeltsList.add(ieltsMapper.selectByPrimaryKey(from));
        }

        IeltsList.removeIf(item -> familiarService.detectWord(item.getWord(), uname));

        if (IeltsList.size() > 15) {
            return IeltsList.subList(0, 15);
        }

        return IeltsList;
    }


}
