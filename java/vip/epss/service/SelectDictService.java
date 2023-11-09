package vip.epss.service;

import vip.epss.domain.Dict;
import vip.epss.domain.DictWithBLOBs;
import vip.epss.utils.WordInfoDTO;

import java.util.List;

public interface SelectDictService {
    public List<Dict> selectDictWord(String spelling);
    public List<DictWithBLOBs> selectDictWordWithBLOBs(String spelling);
    public Integer selectDictWordWithBLOBs_Nums(String spelling);
    public List<Dict> selectDictWordWithSYNO(Integer synsetid,String spelling);
    public Integer selectDictWord_NumsSYNO(Integer synsetid,String spelling);
}
