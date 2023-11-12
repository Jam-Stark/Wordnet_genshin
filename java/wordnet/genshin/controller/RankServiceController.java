package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wordnet.genshin.service.UrankService;
import wordnet.genshin.utils.MessageAndData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping(value = "/Rank")
public class RankServiceController {

    @Autowired
    UrankService urankService;

    @ResponseBody
    @RequestMapping("awardMedal")
    public MessageAndData award(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 日期格式
        String date = currentDate.format(dateFormatter);

        return MessageAndData.success().setMessage(date);
    }
}
