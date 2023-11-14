package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wordnet.genshin.domain.Calendar;
import wordnet.genshin.service.CalendarService;
import wordnet.genshin.service.GuserService;
import wordnet.genshin.service.UrankService;
import wordnet.genshin.utils.MessageAndData;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping(value = "/Calendar")
public class CalendarController {
    @Autowired
    CalendarService calendarService;
    @Autowired
    GuserService guserService;
    @Autowired
    UrankService urankService;
    @ResponseBody
    @RequestMapping("/show")
    public MessageAndData showByUser(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
      return MessageAndData.success().add("Calendarlist",calendarService.showByUser(uname)) ;
    }

    @RequestMapping("updateCalendar")
    public MessageAndData updateCalendar(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 日期格式
        String date = currentDate.format(dateFormatter);
        Integer number=0;
        if(!httpSession.getAttribute("TodayFinal").toString().isEmpty()) {
            number = (Integer) httpSession.getAttribute("TodayFinal") - guserService.getUfinalword(uname).intValue();
        }
        String medal=urankService.getMedal(date,uname);
        calendarService.updateRecord(number,medal,uname);
        return MessageAndData.success().setMessage("");
    }
}
