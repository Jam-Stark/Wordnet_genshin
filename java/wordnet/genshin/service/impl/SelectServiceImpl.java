package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.Words_en_cnMapper;
import wordnet.genshin.domain.Words_en_cn;
import wordnet.genshin.domain.Words_en_cnExample;
import wordnet.genshin.domain.Words_en_cnWithBLOBs;
import wordnet.genshin.service.SelectService;

import java.util.List;

@Service(value ="selectService")
public class SelectServiceImpl implements SelectService {
    @Autowired
    private Words_en_cnMapper words_en_cnMapper;

    @Override
    public Words_en_cn selectWord(String spelling){
        Words_en_cnExample example= new Words_en_cnExample();
        example.createCriteria().andWordEqualTo(spelling);
        List<Words_en_cn> words = words_en_cnMapper.selectByExample(example);

        if (words.size() > 0) {
            return words.get(0);
        } else {
            return null;
        }
    };
    @Override
    public Words_en_cnWithBLOBs selectWordWithBLOBs(String spelling){
        Words_en_cnExample example= new Words_en_cnExample();
        example.createCriteria().andWordEqualTo(spelling);
        List<Words_en_cnWithBLOBs> words = words_en_cnMapper.selectByExampleWithBLOBs(example);

        if (words.size() > 0) {
            return words.get(0);
        } else {
            return null;
        }
    };
    //模糊搜索
    @Override
    public List<Words_en_cn> selectWordLike(String prefix){
        Words_en_cnExample example= new Words_en_cnExample();
        example.createCriteria().andWordLike(prefix+"%");
        List<Words_en_cn> words = words_en_cnMapper.selectByExample(example);
        return words;
    }
    public Integer selectWordLike_nums(String prefix){
        Words_en_cnExample example= new Words_en_cnExample();
        example.createCriteria().andWordLike(prefix+"%");
        List<Words_en_cn> words = words_en_cnMapper.selectByExample(example);
        return words.size();
    }

}
