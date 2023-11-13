package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.WrongbookMapper;
import wordnet.genshin.domain.Wrongbook;
import wordnet.genshin.domain.WrongbookExample;
import wordnet.genshin.service.WrongbookService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service(value="wrongbookservice")
public class WrongbookServiceImpl implements WrongbookService {
    @Autowired
    private WrongbookMapper wrongbookMapper;

    public boolean InsertOne(String word, String uname){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 定义日期格式
        String dateString = dateFormat.format(date); // 将Date对象转换为String类型
        Wrongbook wrongbook = new Wrongbook();
        wrongbook.setWrongdata(dateString);
        wrongbook.setWord(word);
        wrongbook.setUsername(uname);

        WrongbookExample wrongexample = new WrongbookExample();
        WrongbookExample.Criteria criteria = wrongexample.createCriteria();
        criteria.andWordEqualTo(word).andUsernameEqualTo(uname);

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

    public boolean DeleteOne(String word,String uname){
        WrongbookExample wrongexample = new WrongbookExample();
        WrongbookExample.Criteria criteria = wrongexample.createCriteria();
        criteria.andWordEqualTo(word).andUsernameEqualTo(uname);

        List<Wrongbook> wrongbookList=wrongbookMapper.selectByExample(wrongexample);
        if(wrongbookList.isEmpty()){
            System.out.println("错题本中不存在该单词");
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
    @Override
    public List<Wrongbook> selectByuser(String uname) {
        WrongbookExample wrongbookExample=new WrongbookExample();
        WrongbookExample.Criteria criteria=wrongbookExample.createCriteria();
        criteria.andUsernameEqualTo(uname);

        return wrongbookMapper.selectByExample(wrongbookExample);
    }

}
