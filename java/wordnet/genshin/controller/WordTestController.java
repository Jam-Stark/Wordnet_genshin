package wordnet.genshin.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wordnet.genshin.domain.*;
import wordnet.genshin.service.*;
import wordnet.genshin.utils.WordInfoDTO;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "testResult")
public class WordTestController {
    private static final int WORDS_COUNT = 10; // Number of words to be fetched for the quiz
//    @Autowired
//    private SingleTestController singleTestController;
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
    @Autowired
    private GreService greService;
    @Autowired
    private IeltsService ieltsService;
    @Autowired
    private ZkService zkService;
    @Autowired
    private GkService gkService;
    @Autowired
    private Cet4Service cet4Service;
    @Autowired
    private Cet6Service cet6Service;


    @ResponseBody
    @RequestMapping(value = "/getRandom", method = RequestMethod.GET)
    public List<Words_en_cn> getWordQuiz() {
        return wordTestService.getRandomWords(WORDS_COUNT);
    }

    @ResponseBody
    @RequestMapping(value = "/tonow", method = RequestMethod.GET)
    public List<WordInfoDTO> selectToNow(HttpSession httpSession) {
        Integer todayFinal = (Integer) httpSession.getAttribute("TodayFinal");
        String username = (String) httpSession.getAttribute("UserName");
        //Long finalword=guserService.getUfinalword(username);
        String booktype = null;
        if (guserService.checkBook(username)) {
            booktype = guserService.getWordnet(username);
        }
        //搜索当前单词本全部已学内容
        //List<?> dataList = null; // 声明一个模板列表，初始为null
        List<Words_en_cn> wordsList = new ArrayList<Words_en_cn>();//原代码为初始化大小为dataList.size()，需要测试当前写法下wordsList是否为空
        List<Words_en_cnWithBLOBs> wordsListWithBLOBs = new ArrayList<Words_en_cnWithBLOBs>();//问题同上
        List<WordInfoDTO> wordInfoDTO = new ArrayList<WordInfoDTO>();//问题同上
        //匹配单词本
        if (
                Objects.equals(booktype, "tofel")
        ) {
//            List<Tofel> dataList = tofelService.selectMuti(1, todayFinal+1);//比实际索引值+1
            List<Tofel> dataList = tofelService.selectMuti(1, todayFinal+1,username);
            List<Tofel> finalList;
            if (dataList.size() > 10) {
                Collections.shuffle(dataList); // 打乱顺序
                finalList = dataList.subList(0, 10); // 获取前15个元素
            } else {
                finalList = new ArrayList<>(dataList); // 复制元素到新的List
                Collections.shuffle(finalList); // 打乱顺序
            }
            for (int i = 0; i < finalList.size(); i++) {
                wordsList.add(i, selectservice.selectWord(finalList.get(i).getWord()));
                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(finalList.get(i).getWord()));
                //设置返回类的属性
                WordInfoDTO wordDTO = new WordInfoDTO();
                wordDTO.setSpelling(wordsList.get(i).getWord());
                wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
                //wordDTO.setTag(wordsList.get(i).getTag());
                //wordDTO.setExchange(wordsList.get(i).getExchange());
                wordInfoDTO.add(i, wordDTO);
            }
//        } else if (Objects.equals(booktype, "gre")) {
//            List<Gre> dataList = greService.selectMuti(1, todayFinal+1);
//            List<Gre> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "ielts")) {
//            List<Ielts> dataList = ieltsService.selectMuti(1, todayFinal+1);
//            List<Ielts> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "zk")) {
//            List<Zk> dataList = zkService.selectMuti(1, todayFinal+1);
//            List<Zk> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "gk")) {
//            List<Gk> dataList = gkService.selectMuti(1, todayFinal+1);
//            List<Gk> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "cet4")) {
//            List<Cet4> dataList = cet4Service.selectMuti(1, todayFinal+1);
//            List<Cet4> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "cet6")) {
//            List<Cet6> dataList = cet6Service.selectMuti(1, todayFinal+1);
//            List<Cet6> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
        }
//        //加入到words_en_cn
//        List<Words_en_cn> wordsList =new ArrayList<Words_en_cn>();
//        for(int i=0;i<dataList.size();i++){
//            wordsList.add(i,selectservice.selectWord(dataList.get(i).));
//        }
            //
            //String username = "caobaoquan";
            //检查单词是否在熟词本中
            for (int i = 0; i < wordInfoDTO.size(); i++) {
                if (familiarService.detectWord(wordInfoDTO.get(i).getSpelling(), username)) {
                    wordInfoDTO.remove(i);
                }
            }


//        List<Words_en_cn> wordsList =new ArrayList<Words_en_cn>(tofelList.size());
//        for(int i=0;i<tofelList.size();i++){
//            wordsList.set(i,selectservice.selectWord(tofelList.get(i).getWord()));
//        }
            return wordInfoDTO;
        }
    @ResponseBody
    @RequestMapping(value = "/today", method = RequestMethod.GET)
    public List<WordInfoDTO> selectToday(HttpSession httpSession) {
        Integer todayFinal=(Integer) httpSession.getAttribute("TodayFinal");
        String username = (String) httpSession.getAttribute("UserName");
        Long finalwordLong= guserService.getUfinalword(username);
        Integer finalword = finalwordLong.intValue();
        String booktype = null;
        if(guserService.checkBook(username)) {
            booktype = guserService.getWordnet(username);
        }
        //搜索当前单词本全部已学内容
        //List<?> dataList = null; // 声明一个模板列表，初始为null
        List<Words_en_cn> wordsList = new ArrayList<Words_en_cn>();//原代码为初始化大小为dataList.size()，需要测试当前写法下wordsList是否为空
        List<Words_en_cnWithBLOBs> wordsListWithBLOBs = new ArrayList<Words_en_cnWithBLOBs>();//问题同上
        List<WordInfoDTO> wordInfoDTO = new ArrayList<WordInfoDTO>();//问题同上
        //匹配单词本
        if (
                Objects.equals(booktype, "tofel")
        ) {
            List<Tofel> dataList = tofelService.selectMuti(finalword, todayFinal+1,username);//比实际索引值+1
            List<Tofel> finalList;
            if (dataList.size() > 10) {
                Collections.shuffle(dataList); // 打乱顺序
                finalList = dataList.subList(0, 10); // 获取前15个元素
            } else {
                finalList = new ArrayList<>(dataList); // 复制元素到新的List
                Collections.shuffle(finalList); // 打乱顺序
            }
            for (int i = 0; i < dataList.size(); i++) {
                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
                //设置返回类的属性
                WordInfoDTO wordDTO = new WordInfoDTO();
                wordDTO.setSpelling(wordsList.get(i).getWord());
                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
                //wordDTO.setTag(wordsList.get(i).getTag());
                //wordDTO.setExchange(wordsList.get(i).getExchange());
                wordInfoDTO.add(i, wordDTO);
            }
//        } else if (Objects.equals(booktype, "gre")) {
//            List<Gre> dataList = greService.selectMuti(finalword, todayFinal+1);
//            List<Gre> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "ielts")) {
//            List<Ielts> dataList = ieltsService.selectMuti(finalword, todayFinal+1);
//            List<Ielts> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "zk")) {
//            List<Zk> dataList = zkService.selectMuti(finalword, todayFinal+1);
//            List<Zk> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "gk")) {
//            List<Gk> dataList = gkService.selectMuti(finalword, todayFinal+1);
//            List<Gk> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "cet4")) {
//            List<Cet4> dataList = cet4Service.selectMuti(finalword, todayFinal+1);
//            List<Cet4> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
//        } else if (Objects.equals(booktype, "cet6")) {
//            List<Cet6> dataList = cet6Service.selectMuti(finalword, todayFinal+1);
//            List<Cet6> finalList;
//            if (dataList.size() > 10) {
//                Collections.shuffle(dataList); // 打乱顺序
//                finalList = dataList.subList(0, 10); // 获取前15个元素
//            } else {
//                finalList = new ArrayList<>(dataList); // 复制元素到新的List
//                Collections.shuffle(finalList); // 打乱顺序
//            }
//            for (int i = 0; i < dataList.size(); i++) {
//                wordsList.add(i, selectservice.selectWord(dataList.get(i).getWord()));
//                wordsListWithBLOBs.add(i, selectservice.selectWordWithBLOBs(dataList.get(i).getWord()));
//                //设置返回类的属性
//                WordInfoDTO wordDTO = new WordInfoDTO();
//                wordDTO.setSpelling(wordsList.get(i).getWord());
//                //wordDTO.setPhonetic(wordsList.get(i).getPhonetic());
//                //wordDTO.setDefinition(wordsListWithBLOBs.get(i).getDefinition());
//                wordDTO.setTranslation(wordsListWithBLOBs.get(i).getTranslation());
//                //wordDTO.setTag(wordsList.get(i).getTag());
//                //wordDTO.setExchange(wordsList.get(i).getExchange());
//                wordInfoDTO.add(i, wordDTO);
//            }
        }
//        //加入到words_en_cn
//        List<Words_en_cn> wordsList =new ArrayList<Words_en_cn>();
//        for(int i=0;i<dataList.size();i++){
//            wordsList.add(i,selectservice.selectWord(dataList.get(i).));
//        }
        //
        //String username = "caobaoquan";
        //检查单词是否在熟词本中
        for (int i = 0; i < wordInfoDTO.size(); i++) {
            if (familiarService.detectWord(wordInfoDTO.get(i).getSpelling(), username)) {
                wordInfoDTO.remove(i);
            }
        }


//        List<Words_en_cn> wordsList =new ArrayList<Words_en_cn>(tofelList.size());
//        for(int i=0;i<tofelList.size();i++){
//            wordsList.set(i,selectservice.selectWord(tofelList.get(i).getWord()));
//        }
        return wordInfoDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/single", method = RequestMethod.GET)
    public boolean performTest(
            @RequestParam(value = "i") int i,
            @RequestParam(value = "spelling") String spelling,
            @RequestParam(value = "List") String listParam
    ) {
        List<WordInfoDTO> list = new ArrayList<>();

        try {
            // 将接收到的字符串转换为 List<WordInfoDTO> 对象
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(listParam, new TypeReference<List<WordInfoDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            // 处理转换异常
        }

        boolean isValid = wordTestService.validateWord(list.get(i).getSpelling(), spelling);
        return isValid;
    }
}
