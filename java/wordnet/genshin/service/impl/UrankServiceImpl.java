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
import wordnet.genshin.utils.MyPair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



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
    public List<MyPair> awardMedal(String Date) {

        UrankExample urankExample=new UrankExample();
        UrankExample.Criteria criteria=urankExample.createCriteria();
        criteria.andDateEqualTo(Date);
        System.out.println("Service: "+Date);
        List<Urank> urankList=urankMapper.selectByExample(urankExample);

        CalendarExample calendarExample=new CalendarExample();
        CalendarExample.Criteria criteriaC=calendarExample.createCriteria();



        List<MyPair> rank=new ArrayList<>();
        System.out.println("urankList size: " + urankList.size());

        for(Urank item:urankList){
            criteriaC.andUnameEqualTo(item.getUname()).andDateEqualTo(Date);
            System.out.println("each Rank: "+calendarMapper.selectByExample(calendarExample).get(0));
            System.out.println("number: "+calendarMapper.selectByExample(calendarExample).get(0).getNumber());
            System.out.println("item: "+item);
            MyPair pair = new MyPair( calendarMapper.selectByExample(calendarExample).get(0).getNumber(),item);
            rank.add(pair);
        }

        //排序，根据num（每日背的单词数）
        rank.sort(new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
                int number1 = o1.getNumber();
                int number2 = o2.getNumber();

                // 根据 number 值升序排序
                return Integer.compare(number2, number1);
            }
        });

        if (!rank.isEmpty()) {
            // 颁发 Gold 奖牌给排名第一的用户
            criteria.andUnameEqualTo(rank.get(0).getUrank().getUname()).andDateEqualTo(Date);
            urankList.get(0).setMedal("Gold");
        }

        if (rank.size() >= 2) {
            // 颁发 Silver 奖牌给排名第二的用户
            criteria.andUnameEqualTo(rank.get(1).getUrank().getUname()).andDateEqualTo(Date);
            urankList.get(1).setMedal("Silver");
        }

        if (rank.size() >= 3) {
            // 颁发 Copper 奖牌给排名第三的用户
            criteria.andUnameEqualTo(rank.get(2).getUrank().getUname()).andDateEqualTo(Date);
            urankList.get(2).setMedal("Copper");
        }

        // 删除非前三名的奖牌
        for (int i = 3; i < urankList.size(); i++) {
            urankList.get(i).setMedal(null);
        }
        System.out.println("todayRank: "+rank);
        return rank;
    }

    @Override
    public boolean addRank(String Date, String uname) {

        boolean flag=false;
        Urank item=new Urank();
        item.setUname(uname);
        item.setDate(Date);
        UrankExample urankExample=new UrankExample();
        UrankExample.Criteria criteria=urankExample.createCriteria();
        criteria.andUnameEqualTo(Date).andUnameEqualTo(uname);

        if(urankMapper.selectByExample(urankExample).isEmpty())
         urankMapper.insert(item);
        else {
            System.out.println("用户当日已有rank记录！");
        }
        if(!item.toString().isEmpty()){
            flag=true;
        }
        return flag;
    }

    @Override
    public List<Urank> selectAllbyDay(String Date) {
        UrankExample urankExample=new UrankExample();
        UrankExample.Criteria criteria=urankExample.createCriteria();
        criteria.andUnameEqualTo(Date);

        return urankMapper.selectByExample(urankExample);
    }
    @Override
    public String getMedal(String Date, String uname) {
        CalendarExample calendarExample=new CalendarExample();
        CalendarExample.Criteria criteria1=calendarExample.createCriteria();
        criteria1.andUnameEqualTo(uname).andDateEqualTo(Date);
        return calendarMapper.selectByExample(calendarExample).get(0).getMedal();
    }
}
