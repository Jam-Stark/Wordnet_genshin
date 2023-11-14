package wordnet.genshin.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wordnet.genshin.domain.Book_images;
import wordnet.genshin.domain.Calendar;
import wordnet.genshin.domain.Images;
import wordnet.genshin.service.CalendarService;
import wordnet.genshin.service.GuserService;
import wordnet.genshin.service.ImageService;
import wordnet.genshin.service.UrankService;
import wordnet.genshin.utils.Image;
import wordnet.genshin.utils.MessageAndData;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping(value = "/Calendar")
public class CalendarController {
    @Autowired
    CalendarService calendarService;
    @Autowired
    GuserService guserService;
    @Autowired
    UrankService urankService;

    @Autowired
    ImageService imageService;
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

    @ResponseBody
    @RequestMapping("getbookimages")
    public List<Image> getAllBookImages(){
        List<Image> dataList=new ArrayList<>();
        List<Book_images> bookImages=imageService.getAllBook();

        for(Book_images item:bookImages){
            Image image=new Image(item.getName(),Base64.getEncoder().encodeToString(item.getData()));
            dataList.add(image);
        }
        return dataList;
    }

    @ResponseBody
    @RequestMapping("getAllSculpture")
    public List<Image> getAllSculpture(){
        List<Image> dataList=new ArrayList<>();
        List<Images> imagesList=imageService.getAllSculpture();

        for(Images item:imagesList){
            Image image=new Image(item.getName(),Base64.getEncoder().encodeToString(item.getData()));
            dataList.add(image);
        }
        return dataList;
    }

    @RequestMapping("setSculpture")
    public boolean setSculpture(
            @RequestParam(value ="fname" )String fname,
            HttpSession httpSession
    ){
        String username = (String) httpSession.getAttribute("UserName");
        imageService.setUserSculpture(username,fname);
        return true;
    }
}
