package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.dict;
import wordnet.genshin.domain.dictExample;
import wordnet.genshin.domain.dictWithBLOBs;

public interface dictMapper {
    long countByExample(dictExample example);

    int deleteByExample(dictExample example);

    int insert(dictWithBLOBs record);

    int insertSelective(dictWithBLOBs record);

    List<dictWithBLOBs> selectByExampleWithBLOBs(dictExample example);

    List<dict> selectByExample(dictExample example);

    int updateByExampleSelective(@Param("record") dictWithBLOBs record, @Param("example") dictExample example);

    int updateByExampleWithBLOBs(@Param("record") dictWithBLOBs record, @Param("example") dictExample example);

    int updateByExample(@Param("record") dict record, @Param("example") dictExample example);
}