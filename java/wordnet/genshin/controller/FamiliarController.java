package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wordnet.genshin.domain.Familiar;
import wordnet.genshin.service.FamiliarService;
import wordnet.genshin.utils.MessageAndData;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "Familiar")
public class FamiliarController {

    @Autowired
    private FamiliarService familiarService;

    @ResponseBody
    @RequestMapping("show")
    public MessageAndData showByUser(HttpSession httpSession){

        String uname=(String) httpSession.getAttribute("UserName");

        List<Familiar> dataList=familiarService.selectByuser(uname);

        return MessageAndData.success().add("datalist",dataList);
    }

    @ResponseBody
    @RequestMapping("add")
    public MessageAndData addNew(
            @RequestParam(value = "word")String word,
            HttpSession httpSession){

        String uname=(String) httpSession.getAttribute("UserName");

        familiarService.addWord(word,uname);

        return MessageAndData.success().setMessage(word +"加入熟词本成功！");
    }

    @ResponseBody
    @RequestMapping("remove")
    public MessageAndData removeWord(
            @RequestParam(value = "word")String word,
            HttpSession httpSession
    ){
        String uname=(String) httpSession.getAttribute("UserName");

        familiarService.deleteWord(word,uname);

        return MessageAndData.success().setMessage(word +"去除熟词本成功！");
    }

}
