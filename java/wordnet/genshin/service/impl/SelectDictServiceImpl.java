package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.DictMapper;
import wordnet.genshin.domain.DictWithBLOBs;
import wordnet.genshin.service.SelectDictService;
import wordnet.genshin.domain.Dict;
import wordnet.genshin.domain.DictExample;

import java.util.List;

@Service(value ="selectDictService")
public class SelectDictServiceImpl implements SelectDictService{
    @Autowired
    private DictMapper dictMapper;
    public List<Dict> selectDictWord(String spelling){
        DictExample example= new DictExample();
        example.createCriteria().andLemmaEqualTo(spelling);
        List<Dict> dictwords = dictMapper.selectByExample(example);
        return dictwords;
    }

    public List<DictWithBLOBs> selectDictWordWithBLOBs(String spelling){
        DictExample example= new DictExample();
        example.createCriteria().andLemmaEqualTo(spelling);
        List<DictWithBLOBs> dictwords = dictMapper.selectByExampleWithBLOBs(example);
        return dictwords;
    }

    public Integer selectDictWordWithBLOBs_Nums(String spelling){
        DictExample example= new DictExample();
        example.createCriteria().andLemmaEqualTo(spelling);
        List<DictWithBLOBs> dictwords = dictMapper.selectByExampleWithBLOBs(example);
        Integer nums = dictwords.size();
        return nums;
    }

    public List<Dict> selectDictWordWithSYNO(Integer synsetid,String spelling){
        DictExample example= new DictExample();
        //example.createCriteria().andSynsetidEqualTo(synsetid).andLemmaNotLike("%"+spelling+"%");
        example.createCriteria().andSynsetidEqualTo(synsetid).andLemmaNotEqualTo((spelling));
        List<Dict> dictwords = dictMapper.selectByExample(example);
        return dictwords;
    }
    public Integer selectDictWord_NumsSYNO(Integer synsetid,String spelling){
        DictExample example= new DictExample();
        example.createCriteria().andLemmaNotEqualTo(spelling).andSynsetidEqualTo(synsetid);
        List<DictWithBLOBs> dictwords = dictMapper.selectByExampleWithBLOBs(example);
        Integer numsSyno = dictwords.size();
        return numsSyno;
    }
}
