package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Familiar;
import wordnet.genshin.domain.FamiliarExample;

public interface FamiliarMapper {
    long countByExample(FamiliarExample example);

    int deleteByExample(FamiliarExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Familiar record);

    int insertSelective(Familiar record);

    List<Familiar> selectByExample(FamiliarExample example);

    Familiar selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Familiar record, @Param("example") FamiliarExample example);

    int updateByExample(@Param("record") Familiar record, @Param("example") FamiliarExample example);

    int updateByPrimaryKeySelective(Familiar record);

    int updateByPrimaryKey(Familiar record);
}