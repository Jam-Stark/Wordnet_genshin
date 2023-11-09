package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.Dict;
import vip.epss.domain.DictWithBLOBs;
import vip.epss.domain.Words_en_cn;
import vip.epss.domain.Words_en_cnWithBLOBs;
import vip.epss.service.SelectDictService;
import vip.epss.service.SelectService;
import vip.epss.utils.MessageAndData;
import vip.epss.utils.WordInfoDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "selectResult")
public class SelectController {
    @Autowired
    private SelectService selectservice;

    @Autowired
    private SelectDictService selectDictservice;//

    @ResponseBody
    @RequestMapping(value = "/word",method = RequestMethod.GET)
    public MessageAndData optSelect(
            @RequestParam(value = "spelling") String spelling
    ){
        Words_en_cn selectedWord=selectservice.selectWord(spelling);
        if(selectedWord!=null)
            return MessageAndData.success().setMessage("查找单词成功");
        else
            return MessageAndData.error().setMessage("查找单词失败");
    }
    @ResponseBody
    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public WordInfoDTO optSelectInfo(@RequestParam(value = "word_spelling") String word_spelling) {
        Words_en_cn selectedWord = selectservice.selectWord(word_spelling);
        Words_en_cnWithBLOBs selectedWordWithBLOBs=selectservice.selectWordWithBLOBs(word_spelling);
        List<DictWithBLOBs> selectedDictWordList=selectDictservice.selectDictWordWithBLOBs(word_spelling);
        Integer nums=selectDictservice.selectDictWordWithBLOBs_Nums(word_spelling);
        Integer Synsetid=selectedDictWordList.get(0).getSynsetid();
        List<Dict> selectedDictWordSyn=selectDictservice.selectDictWordWithSYNO(Synsetid,word_spelling);
        Integer numsSyno=selectDictservice.selectDictWord_NumsSYNO(Synsetid,word_spelling);

        if (selectedWord != null) {
            // 设置其他属性
            WordInfoDTO wordInfoDTO = new WordInfoDTO();
            wordInfoDTO.setSpelling(selectedWord.getWord());
            wordInfoDTO.setPhonetic(selectedWord.getPhonetic());
            //wordInfoDTO.setDefinition(selectedWordWithBLOBs.getDefinition());
            // 处理definition字段中的换行符
            String definition = selectedWordWithBLOBs.getDefinition();
            definition = definition.replace("\\n", "<br>");
            wordInfoDTO.setDefinition(definition);
            //wordInfoDTO.setTranslation(selectedWordWithBLOBs.getTranslation());
            // 处理translation字段中的换行符
            String translation = selectedWordWithBLOBs.getTranslation();
            translation = translation.replace("\\n", "<br>");
            wordInfoDTO.setTranslation(translation);
            wordInfoDTO.setTag(selectedWord.getTag());
            wordInfoDTO.setExchange(selectedWord.getExchange());
            wordInfoDTO.setLemma(selectedDictWordList.get(0).getLemma());
            //加入例句
            for(int i=0;i<nums;i++){
                if(Objects.equals(selectedDictWordList.get(i).getPos(), "v")){
                    wordInfoDTO.getSampleset().add(selectedDictWordList.get(i).getSampleset());
                }
            }
            //加入同义词
            for(int i=0;i<numsSyno;i++){
                wordInfoDTO.getSynonymWords().add(selectedDictWordSyn.get(i).getLemma());
            }

            //划分exchange:单词的各种变形
            String exchange = selectedWord.getExchange();
            if (exchange != null && !exchange.isEmpty()) {
                String[] exchangeParts = exchange.split("/");
                wordInfoDTO.setExchangeEvery(Arrays.asList(exchangeParts));
            } else {
                wordInfoDTO.setExchangeEvery(Collections.emptyList());
            }
//            //wordInfoDTO.setSampleset(selectedDictWordList.get(0).getSampleset());
//            //划分exchange
//            String getted_exchange=selectedWord.getExchange();
//            int size=0;
//            for( int i=0;i<getted_exchange.length();i++){
//                if(getted_exchange.charAt(i)=='/')
//                    size++;
//            }
//            String[] partexchange=new String[size+1];
//
//            //wordInfoDTO.getexchange();
//            //WordInfoDTO partexchange= getted_exchange();
//            int i=0,j=0,mark=0,sign=0;
//            for( i=0;i<getted_exchange.length();i++){
//                if(getted_exchange.charAt(i)!='/'&&mark==0){
//                    sign=i;
//                    mark=1;
//                }
//                if(getted_exchange.charAt(i)=='/'||i==getted_exchange.length()-1){
//                    partexchange[j]=getted_exchange.substring(sign,i-1);//√
//                    wordInfoDTO.setarray_partexchange(partexchange[j],j,size);
//                    j++;
//                    mark=0;
//              }
//            }
            return wordInfoDTO;
        } else {
            return null;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/searchMatch", method = RequestMethod.GET)
    public WordInfoDTO optSelectMatch(@RequestParam(value = "prefix") String prefix){
        List<Words_en_cn> selectedWordLike=selectservice.selectWordLike(prefix);
        Integer nums=selectservice.selectWordLike_nums(prefix);
        if(selectedWordLike!=null){
            WordInfoDTO wordInfoDTO = new WordInfoDTO();
            for(int i=0;i<nums;i++){
                wordInfoDTO.getWordLike().add(selectedWordLike.get(i).getWord());
            }
            return wordInfoDTO;
        }else{
            return null;
        }
    }


}
