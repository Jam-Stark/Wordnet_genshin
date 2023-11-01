package wordnet.genshin.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wordnet.genshin.utils.MessageAndData;
import wordnet.genshin.domain.Tofel;
import wordnet.genshin.service.TofelService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/TOEFL")
public class TofelContoller {
    @Autowired
    private TofelService tofelService;

    @RequestMapping(value="/search/{num}",method = RequestMethod.GET)
    public MessageAndData search(@PathVariable(value = "num") int id){
        Tofel tofel = tofelService.selectOne(id);
        //MessageAndData messageAndData = new MessageAndData();
        if (tofel == null){
            return MessageAndData.error().setMessage("单词获取失败");
        }else{
            return MessageAndData.success().add("TOEFL",tofel);
        }
        //return messageAndData;
    }

    @RequestMapping(value = "/search/{from}/{to}", method = RequestMethod.GET)
    public MessageAndData searchInRange(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        if (from < 0 || to < 0 || from > to) {
            return MessageAndData.error().setMessage("无效的ID范围");
        }

        List<Tofel> tofelsInRange = tofelService.selectMuti(from, to);
        if (tofelsInRange.isEmpty()) {
            return MessageAndData.error().setMessage("未找到匹配的数据");
        } else {
            return MessageAndData.success().add("TOEFL", tofelsInRange);
        }
    }

    @RequestMapping(value="tablet")
    @ResponseBody
    public MessageAndData tablet(
            @RequestParam(value="from",defaultValue="1")int from,
            @RequestParam(value="to",defaultValue="30")int to
    ){
        List<Tofel> tofelList = tofelService.selectMuti(from, to);
        PageHelper.startPage(from, to);  //左闭右开 [from,to)
        PageInfo pageInfo = new PageInfo(tofelList, 0);
        return MessageAndData.success().add("pageInfo",pageInfo);
    }


//    @PostMapping("/search")
//    public MessageAndData searchFromJson(@RequestBody TOEFL_search jsonRequest) {
//        // 在这里执行处理 JSON 数据的逻辑
//        int id = jsonRequest.getId(); // 假设 JSON 数据中包含一个名为 "id" 的字段
//        Tofel tofel = tofelService.selectOne(id);
//
//        if (tofel == null) {
//            return MessageAndData.error().setMessage("单词获取失败");
//        } else {
//            return MessageAndData.success().add("TOFEL", tofel);
//        }
//    }
}
