package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import wordnet.genshin.dao.GuserMapper;
import wordnet.genshin.domain.Calendar;
import wordnet.genshin.dao.CalendarMapper;
import wordnet.genshin.domain.CalendarExample;
import wordnet.genshin.domain.GuserExample;
import wordnet.genshin.service.CalendarService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service(value = "CalendarService")
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarMapper calendarMapper;

    @Autowired
    private GuserMapper guserMapper;

    @Override
    public boolean updateRecord( Integer number, String medal, String uname) {
        boolean flag=false;

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 日期格式
        String date = currentDate.format(dateFormatter);

        Calendar newRecord=new Calendar();
        newRecord.setDate(date);
        newRecord.setMedal(medal);
        newRecord.setUname(uname);
        newRecord.setNumber(number);

        CalendarExample calendarExample=new CalendarExample();
        CalendarExample.Criteria criteria=calendarExample.createCriteria();
        criteria.andDateEqualTo(date).andUnameEqualTo(uname);

        List<Calendar> calendarList=calendarMapper.selectByExample(calendarExample);

        if (calendarList.isEmpty()) {            //原来没数据直接插入
            calendarMapper.insert(newRecord);
        flag=true;
        }
        else {
            number+=calendarList.get(0).getNumber();    //原先有数据则number相加
            newRecord.setNumber(number);
            calendarMapper.insert(newRecord);
            flag=true;
        }

        //设置complete
        completed_(date,uname);

        return flag;
    }

    @Override
    public boolean completed_(String Date, String uname) {
        GuserExample guserExample=new GuserExample();
        GuserExample.Criteria criteria=guserExample.createCriteria();
        criteria.andUnameEqualTo(uname);
        Integer goal=guserMapper.selectByExample(guserExample).get(0).getUdaily();

        CalendarExample calendarExample=new CalendarExample();
        CalendarExample.Criteria criteria1=calendarExample.createCriteria();
        criteria1.andUnameEqualTo(uname).andDateEqualTo(Date);

        boolean flag = false;
        if(calendarMapper.selectByExample(calendarExample).get(0).getNumber().toString().isEmpty()) {
            flag = false;
            calendarMapper.selectByExample(calendarExample).get(0).setCompleted(false);
        }
        else {
            if(calendarMapper.selectByExample(calendarExample).get(0).getNumber()>goal) {
                flag = true;
                calendarMapper.selectByExample(calendarExample).get(0).setCompleted(true);
            }
            else {
                flag = false;
                calendarMapper.selectByExample(calendarExample).get(0).setCompleted(false);
            }
        }
        return flag;
    }

    @Override
    public List<Calendar> showByUser(String uname) {
        CalendarExample calendarExample=new CalendarExample();
        CalendarExample.Criteria criteria1=calendarExample.createCriteria();
        criteria1.andUnameEqualTo(uname);
        return calendarMapper.selectByExample(calendarExample);
    }




}
