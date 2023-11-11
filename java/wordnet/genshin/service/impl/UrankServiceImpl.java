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
        CalendarExample.Criteria criteria1=calendarExample.createCriteria();

        String First;
        String Second;
        String third;

        List<ConnectionUrlParser.Pair> rank=new ArrayList<>();

        for(Urank item:urankList){
            criteria1.andUnameEqualTo(item.getUname()).andDateEqualTo(Date);
            ConnectionUrlParser.Pair pair = new ConnectionUrlParser.Pair(item.getUname(), calendarMapper.selectByExample(calendarExample).get(0).getNumber());
            rank.add(pair);
        }
        Collections.sort(rank, new Comparator<ConnectionUrlParser.Pair>() {
            @Override
            public int compare(ConnectionUrlParser.Pair pair1, ConnectionUrlParser.Pair pair2) {
                // 从大到小排序
                return pair2.getNumber() - pair1.getNumber();
            }
        });


        return false;
    }

    @Override
    public boolean addRank(String Date, String uname) {
        return false;
    }
}
