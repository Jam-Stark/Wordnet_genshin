package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.epss.service.NewbookService;
import vip.epss.utils.MessageAndData;

import java.util.Date;

@RestController
@RequestMapping(value = "newbook")
public class NewbookController {
    @Autowired
    private NewbookService newbookService;

    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public MessageAndData optInsert(
            @RequestParam(value = "word") String word
    ){
            Date date= new Date();
            boolean b=newbookService.InsertOne(word,date);
            if(b!=true) {
                return MessageAndData.error().setMessage("生词本插入单词失败(该单词已加入生词本)");
            }else{
                return MessageAndData.success().add("word",word).add("date",date);
            }
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public MessageAndData optDelete(
            @RequestParam(value = "word") String word
    ){
        boolean b=newbookService.DeleteOne(word);
        if(b!=true) {
            return MessageAndData.error().setMessage("从生词本删除单词失败(生词本中不存在该单词)");
        }else{
            return MessageAndData.success().add("word",word);
        }


    }
}
