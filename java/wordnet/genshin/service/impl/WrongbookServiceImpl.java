package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.WrongbookMapper;
import wordnet.genshin.domain.Wrongbook;
import wordnet.genshin.domain.WrongbookExample;
import wordnet.genshin.service.WrongbookService;

import java.util.Date;
import java.util.List;

@Service(value="wrongbookservice")
public class WrongbookServiceImpl implements WrongbookService {
    @Autowired
    private WrongbookMapper wrongbookMapper;

    public boolean InsertOne(String word, Date date){
        date = new Date();
        Wrongbook wrongbook = new Wrongbook();
        wrongbook.setWrongdata(date);
        wrongbook.setWord(word);

        WrongbookExample wrongexample = new WrongbookExample();
        WrongbookExample.Criteria criteria = wrongexample.createCriteria();
        criteria.andWordEqualTo(word);

        List<Wrongbook> wrongbookList=wrongbookMapper.selectByExample(wrongexample);
        if(!wrongbookList.isEmpty()){
            System.out.println("该单词已加入生词本");
            return false;
        }
        else {
            int rows = wrongbookMapper.insert(wrongbook);
            return rows > 0;
        }
    }

    public boolean DeleteOne(String word){
        WrongbookExample wrongexample = new WrongbookExample();
        WrongbookExample.Criteria criteria = wrongexample.createCriteria();
        criteria.andWordEqualTo(word);

        List<Wrongbook> wrongbookList=wrongbookMapper.selectByExample(wrongexample);
        if(wrongbookList.isEmpty()){
            System.out.println("生词本中不存在该单词");
            return false;
        }
        else {
            wrongbookMapper.deleteByExample(wrongexample);
            return true;
        }
    }
    @Override
    public Wrongbook selectOne(String word) {


        WrongbookExample wrongexample = new WrongbookExample();
        WrongbookExample.Criteria criteria = wrongexample.createCriteria();
        criteria.andWordEqualTo(word);

        return wrongbookMapper.selectByExample(wrongexample).get(0);
    }


}
