package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wordnet.genshin.domain.Newbook;
import wordnet.genshin.service.NewbookService;
import wordnet.genshin.utils.MessageAndData;

import java.util.Date;

@RestController
@RequestMapping(value = "newbook")
public class NewbookController {
    @Autowired
    private NewbookService newbookService;

    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public MessageAndData optInsert(
            @RequestParam(value = "word") String word
    ) {
        Date date = new Date();
        boolean b = newbookService.InsertOne(word, date);
        if (b != true) {
            return MessageAndData.error().setMessage("生词本插入单词失败(该单词已加入生词本)");
        } else {
            return MessageAndData.success().add("word", word).add("date", date);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public MessageAndData optDelete(
            @RequestParam(value = "word") String word
    ) {
        boolean b = newbookService.DeleteOne(word);
        if (b != true) {
            return MessageAndData.error().setMessage("从生词本删除单词失败(生词本中不存在该单词)");
        } else {
            return MessageAndData.success().add("word", word);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String optSearch(
            @PathVariable(value = "word") String word
    ) {
        Newbook newbook = newbookService.selectOne(word);
        //MessageAndData messageAndData = new MessageAndData();
        if (newbook == null) {
            return null;
        } else {
            return newbook.getNewword();
        }
    }
}
