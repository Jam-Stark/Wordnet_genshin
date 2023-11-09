package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Dict;
import wordnet.genshin.domain.DictExample;
import wordnet.genshin.domain.DictWithBLOBs;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int insert(DictWithBLOBs record);

    int insertSelective(DictWithBLOBs record);

    List<DictWithBLOBs> selectByExampleWithBLOBs(DictExample example);

    List<Dict> selectByExample(DictExample example);

    int updateByExampleSelective(@Param("record") DictWithBLOBs record, @Param("example") DictExample example);

    int updateByExampleWithBLOBs(@Param("record") DictWithBLOBs record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);
}