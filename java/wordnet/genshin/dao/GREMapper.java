package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.GRE;
import wordnet.genshin.domain.GREExample;

public interface GREMapper {
    long countByExample(GREExample example);

    int deleteByExample(GREExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GRE record);

    int insertSelective(GRE record);

    List<GRE> selectByExample(GREExample example);

    GRE selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GRE record, @Param("example") GREExample example);

    int updateByExample(@Param("record") GRE record, @Param("example") GREExample example);

    int updateByPrimaryKeySelective(GRE record);

    int updateByPrimaryKey(GRE record);
}