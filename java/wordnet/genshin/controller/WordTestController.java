package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wordnet.genshin.domain.Tofel;
import wordnet.genshin.domain.Words_en_cn;
import wordnet.genshin.domain.Words_en_cnWithBLOBs;
import wordnet.genshin.service.*;
import wordnet.genshin.utils.WordInfoDTO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "testResult")
public class WordTestController {
    private static final int WORDS_COUNT = 10; // Number of words to be fetched for the quiz
    @Autowired
    private SingleTestController singleTestController;
    @Autowired
    private WordTestService wordTestService;
    @Autowired
    private GuserService guserService;
    @Autowired
    private SelectService selectservice;

    @Autowired
    private FamiliarService familiarService;
    @Autowired
    private TofelService tofelService;

    @ResponseBody
    @RequestMapping(value = "/getRandom",method = RequestMethod.GET)
    public List<Words_en_cn> getWordQuiz() {
        return wordTestService.getRandomWords(WORDS_COUNT);
    }

    @ResponseBody
    @RequestMapping(value = "/selectIdArea",method = RequestMethod.GET)
    public List<WordInfoDTO> selectIdArea(HttpSession httpSession){
        Integer current=(Integer) httpSession.getAttribute("Current");
        String username = (String) httpSession.getAttribute("UserName");
        Long finalword=guserService.getUfinalword(username);
        //
        String booktype=null;
        if(guserService.checkBook(username)) {
            booktype = guserService.getWordnet(username);
        }
        //搜索当前单词本全部已学内容
       //List<?> dataList = null; // 声明一个模板列表，初始为null
        List<Words_en_cn> wordsList =new ArrayList<Words_en_cn>();//原代码为初始化大小为dataList.size()，需要测试当前写法下wordsList是否为空
        List<Words_en_cnWithBLOBs> wordsListWithBLOBs =new ArrayList<Words_en_cnWithBLOBs>();//问题同上
        List<WordInfoDTO> wordInfoDTO =new ArrayList<WordInfoDTO>();//问题同上
        //匹配单词本
        if (Objects.equals(booktype, "tofel")) {
            List<Tofel> dataList = tofelService.selectMuti(1, current);
            for (int i = 0; i < dataList.size(); i++) {
                wordsList.set(i, selectservice.selectWord(dataList.get(i).getWord()));
                wordsListWithBLOBs.set(i,selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
                //设置返回类的属性
                //WordInfoDTO wordInfoDTO = new WordInfoDTO();
                wordInfoDTO.get(i).setSpelling(wordsList.get(i).getWord());
                wordInfoDTO.get(i).setPhonetic(wordsList.get(i).getPhonetic());
                wordInfoDTO.get(i).setDefinition(wordsListWithBLOBs.get(i).getDefinition());
                wordInfoDTO.get(i).setTranslation(wordsListWithBLOBs.get(i).getTranslation());
                wordInfoDTO.get(i).setTag(wordsList.get(i).getTag());
                wordInfoDTO.get(i).setExchange(wordsList.get(i).getExchange());
            }
        }
//        } else if (Objects.equals(book, "gre")) {
//            dataList = greService.selectMuti(from, to);
//        } else if (Objects.equals(book, "zk")) {
//            dataList = zkService.selectMuti(from, to);
//        } else if (Objects.equals(book, "gk")) {
//            dataList = gkService.selectMuti(from, to);
//        } else if (Objects.equals(book, "ielts")) {
//            dataList = ieltsService.selectMuti(from, to);
//        } else if (Objects.equals(book, "cet4")) {
//            dataList = cet4Service.selectMuti(from, to);
//        } else if (Objects.equals(book, "cet6")) {
//            dataList = cet6Service.selectMuti(from, to);
        //}
        //加入到words_en_cn
//        List<Words_en_cn> wordsList =new ArrayList<Words_en_cn>(dataList.size());
//        for(int i=0;i<dataList.size();i++){
//            wordsList.set(i,selectservice.selectWord(dataList.get(i).));
//        }
        //检查单词是否在熟词本中
        for(int i=0;i<wordsList.size();i++){
            if(familiarService.detectWord(wordsList.get(i).getWord(),username)){
                wordsList.remove(i);
            }
        }
//        List<Words_en_cn> wordsList =new ArrayList<Words_en_cn>(tofelList.size());
//        for(int i=0;i<tofelList.size();i++){
//            wordsList.set(i,selectservice.selectWord(tofelList.get(i).getWord()));
//        }
        return wordInfoDTO;
    }



    @ResponseBody
    @RequestMapping(value = "/single",method = RequestMethod.GET)
    public boolean performTest(
            @RequestParam(value = "i") int i,
            @RequestParam(value = "spelling") String spelling,
            @RequestParam(value = "List") List<Words_en_cn> List

    ) {

        boolean isValid = wordTestService.validateWord(List.get(i).getWord(), spelling);
        return isValid;
    }
}
