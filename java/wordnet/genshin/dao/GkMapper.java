package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Gk;
import wordnet.genshin.domain.GkExample;

public interface GkMapper {
    long countByExample(GkExample example);

    int deleteByExample(GkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gk record);

    int insertSelective(Gk record);

    List<Gk> selectByExample(GkExample example);

    Gk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gk record, @Param("example") GkExample example);

    int updateByExample(@Param("record") Gk record, @Param("example") GkExample example);

    int updateByPrimaryKeySelective(Gk record);

    int updateByPrimaryKey(Gk record);
}