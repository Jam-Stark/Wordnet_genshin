package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wordnet.genshin.domain.Urank;
import wordnet.genshin.service.UrankService;
import wordnet.genshin.utils.MessageAndData;
import wordnet.genshin.utils.MyPair;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value = "/Rank")
public class RankServiceController {

    @Autowired
    UrankService urankService;

//    @ResponseBody
//    @RequestMapping("awardMedal")
//    public MessageAndData award(){
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 日期格式
//        String date = currentDate.format(dateFormatter);
//
//        return MessageAndData.success().setMessage(date);
//    }

    @RequestMapping("addRecord")
    public MessageAndData add(HttpSession httpSession) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 日期格式
        String date = currentDate.format(dateFormatter);

        String uname=(String) httpSession.getAttribute("UserName");
        urankService.addRank(date,uname);

        return MessageAndData.success().setMessage("");
    }

    @ResponseBody
    @RequestMapping("TodayRank")
    public MessageAndData todayRank(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 日期格式
        String date = currentDate.format(dateFormatter);
        System.out.println(date);

       List<MyPair> dataList=         urankService.awardMedal(date);;
       return MessageAndData.success().add("datalist",dataList);
    }


}
