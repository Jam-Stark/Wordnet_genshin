package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Words_en_cn;
import wordnet.genshin.domain.Words_en_cnExample;
import wordnet.genshin.domain.Words_en_cnWithBLOBs;

public interface Words_en_cnMapper {
    long countByExample(Words_en_cnExample example);

    int deleteByExample(Words_en_cnExample example);

    int insert(Words_en_cnWithBLOBs record);

    int insertSelective(Words_en_cnWithBLOBs record);

    List<Words_en_cnWithBLOBs> selectByExampleWithBLOBs(Words_en_cnExample example);

    List<Words_en_cn> selectByExample(Words_en_cnExample example);

    int updateByExampleSelective(@Param("record") Words_en_cnWithBLOBs record, @Param("example") Words_en_cnExample example);

    int updateByExampleWithBLOBs(@Param("record") Words_en_cnWithBLOBs record, @Param("example") Words_en_cnExample example);

    int updateByExample(@Param("record") Words_en_cn record, @Param("example") Words_en_cnExample example);
}