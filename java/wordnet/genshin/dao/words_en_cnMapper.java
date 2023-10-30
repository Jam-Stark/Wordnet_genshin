package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.words_en_cn;
import wordnet.genshin.domain.words_en_cnExample;
import wordnet.genshin.domain.words_en_cnWithBLOBs;

public interface words_en_cnMapper {
    long countByExample(words_en_cnExample example);

    int deleteByExample(words_en_cnExample example);

    int insert(words_en_cnWithBLOBs record);

    int insertSelective(words_en_cnWithBLOBs record);

    List<words_en_cnWithBLOBs> selectByExampleWithBLOBs(words_en_cnExample example);

    List<words_en_cn> selectByExample(words_en_cnExample example);

    int updateByExampleSelective(@Param("record") words_en_cnWithBLOBs record, @Param("example") words_en_cnExample example);

    int updateByExampleWithBLOBs(@Param("record") words_en_cnWithBLOBs record, @Param("example") words_en_cnExample example);

    int updateByExample(@Param("record") words_en_cn record, @Param("example") words_en_cnExample example);
}