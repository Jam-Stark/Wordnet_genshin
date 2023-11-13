package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.NewbookMapper;
import wordnet.genshin.domain.Newbook;
import wordnet.genshin.domain.NewbookExample;
import wordnet.genshin.service.NewbookService;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service(value="newbookservice")
public class NewbookServiceImpl implements NewbookService {
    @Autowired
    private NewbookMapper newbookMapper;

    public boolean InsertOne(String word,String uname){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 定义日期格式
        String dateString = dateFormat.format(date); // 将Date对象转换为String类型
        Newbook newbook = new Newbook();
        newbook.setNewdata(dateString);
        newbook.setNewword(word);
        newbook.setUsername(uname);

        NewbookExample newexample = new NewbookExample();
        NewbookExample.Criteria criteria = newexample.createCriteria();
        criteria.andNewwordEqualTo(word).andUsernameEqualTo(uname);

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

    public boolean DeleteOne(String word,String uname){
        NewbookExample newexample = new NewbookExample();
        NewbookExample.Criteria criteria = newexample.createCriteria();
        criteria.andNewwordEqualTo(word).andUsernameEqualTo(uname);

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
    @Override
    public List<Newbook> selectByuser(String uname) {
        NewbookExample newbookExample=new NewbookExample();
        NewbookExample.Criteria criteria=newbookExample.createCriteria();
        criteria.andUsernameEqualTo(uname);

        return newbookMapper.selectByExample(newbookExample);
    }


}
