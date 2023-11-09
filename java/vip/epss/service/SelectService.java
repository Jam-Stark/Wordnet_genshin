package vip.epss.service;

import vip.epss.domain.Words_en_cn;
import vip.epss.domain.Words_en_cnExample;
import vip.epss.domain.Words_en_cnWithBLOBs;

import java.util.List;

public interface SelectService {
    //public Words_en_cn selectWord(String str);
    Words_en_cn selectWord(String spelling);
    public Words_en_cnWithBLOBs selectWordWithBLOBs(String spelling);
    public List<Words_en_cn> selectWordLike(String prefix);
    public Integer selectWordLike_nums(String prefix);
}
