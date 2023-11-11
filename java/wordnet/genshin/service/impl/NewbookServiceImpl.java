package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.NewbookMapper;
import wordnet.genshin.domain.Newbook;
import wordnet.genshin.domain.NewbookExample;
import wordnet.genshin.service.NewbookService;


import java.util.Date;
import java.util.List;

@Service(value="newbookservice")
public class NewbookServiceImpl implements NewbookService {
    @Autowired
    private NewbookMapper newbookMapper;

    public boolean InsertOne(String word, Date date){
        date = new Date();
        Newbook newbook = new Newbook();
        newbook.setNewdata(date);
        newbook.setNewword(word);

        NewbookExample newexample = new NewbookExample();
        NewbookExample.Criteria criteria = newexample.createCriteria();
        criteria.andNewwordEqualTo(word);

        List<Newbook> newbookList=newbookMapper.selectByExample(newexample);
        if(!newbookList.isEmpty()){
            System.out.println("该单词已加入生词本");
            return false;
        }
        else {
            int rows = newbookMapper.insert(newbook);
            return rows > 0;
        }
    }

    public boolean DeleteOne(String word){
        NewbookExample newexample = new NewbookExample();
        NewbookExample.Criteria criteria = newexample.createCriteria();
        criteria.andNewwordEqualTo(word);

        List<Newbook> newbookList=newbookMapper.selectByExample(newexample);
        if(newbookList.isEmpty()){
            System.out.println("生词本中不存在该单词");
            return false;
        }
        else {
            newbookMapper.deleteByExample(newexample);
            return true;
        }
    }
    @Override
    public Newbook selectOne(String word) {


        NewbookExample newexample = new NewbookExample();
        NewbookExample.Criteria criteria = newexample.createCriteria();
        criteria.andNewwordEqualTo(word);

        return newbookMapper.selectByExample(newexample).get(0);
    }


}
