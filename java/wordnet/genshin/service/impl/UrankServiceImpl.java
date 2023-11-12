package wordnet.genshin.service.impl;

import com.mysql.cj.conf.ConnectionUrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.CalendarMapper;
import wordnet.genshin.domain.CalendarExample;
import wordnet.genshin.domain.UrankExample;
import wordnet.genshin.service.UrankService;
import wordnet.genshin.domain.Urank;
import wordnet.genshin.dao.UrankMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;


@Service(value = "UrankService")
public class UrankServiceImpl implements UrankService {
    @Autowired
    private UrankMapper urankMapper;

    @Autowired
    private CalendarMapper calendarMapper;

    @Override
    public List<Urank> selectUserRank(String uname) {

        UrankExample urankExample=new UrankExample();
        UrankExample.Criteria criteria=urankExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        return  urankMapper.selectByExample(urankExample);

    }

    @Override
    public boolean awardMedal(String Date) {

        UrankExample urankExample=new UrankExample();
        UrankExample.Criteria criteria=urankExample.createCriteria();
        criteria.andDateEqualTo(Date);

        List<Urank> urankList=urankMapper.selectByExample(urankExample);

        CalendarExample calendarExample=new CalendarExample();
        CalendarExample.Criteria criteriaC=calendarExample.createCriteria();
        class MyPair {
            private String uname;
            private int number;

            public MyPair(String uname, int number) {
                this.uname = uname;
                this.number = number;
            }

            public String getuname() {
                return uname;
            }

            public int getNumber() {
                return number;
            }
        }  //自定义一个pair用于排序


        List<MyPair> rank=new ArrayList<>();

        for(Urank item:urankList){
            criteriaC.andUnameEqualTo(item.getUname()).andDateEqualTo(Date);
            MyPair pair = new MyPair(item.getUname(), calendarMapper.selectByExample(calendarExample).get(0).getNumber());
            rank.add(pair);
        }

        //排序，根据num（每日背的单词数）
        rank.sort(new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
                int number1 = o1.getNumber();
                int number2 = o2.getNumber();

                // 根据 number 值升序排序
                return Integer.compare(number1, number2);
            }
        });

        if (!rank.isEmpty()) {
            // 颁发 Gold 奖牌给排名第一的用户
            criteria.andUnameEqualTo(rank.get(0).getuname()).andDateEqualTo(Date);
            urankList.get(0).setMedal("Gold");
        }

        if (rank.size() >= 2) {
            // 颁发 Silver 奖牌给排名第二的用户
            criteria.andUnameEqualTo(rank.get(1).getuname()).andDateEqualTo(Date);
            urankList.get(1).setMedal("Silver");
        }

        if (rank.size() >= 3) {
            // 颁发 Copper 奖牌给排名第三的用户
            criteria.andUnameEqualTo(rank.get(2).getuname()).andDateEqualTo(Date);
            urankList.get(2).setMedal("Copper");
        }

        return !rank.isEmpty();
    }

    @Override
    public boolean addRank(String Date,Integer number, String uname) {

        boolean flag=false;
        Urank item=new Urank();
        item.setUname(uname);
        item.setDate(Date);
        urankMapper.insert(item);
        if(!item.toString().isEmpty()){
            flag=true;
        }
        return flag;
    }
}
