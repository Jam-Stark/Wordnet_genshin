package wordnet.genshin.service;

import wordnet.genshin.domain.Dict;
import wordnet.genshin.domain.DictWithBLOBs;

import java.util.List;

public interface SelectDictService {
    public List<Dict> selectDictWord(String spelling);
    public List<DictWithBLOBs> selectDictWordWithBLOBs(String spelling);
    public Integer selectDictWordWithBLOBs_Nums(String spelling);
    public List<Dict> selectDictWordWithSYNO(Integer synsetid,String spelling);
    public Integer selectDictWord_NumsSYNO(Integer synsetid,String spelling);
}
