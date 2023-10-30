package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.gk;
import wordnet.genshin.domain.gkExample;

public interface gkMapper {
    long countByExample(gkExample example);

    int deleteByExample(gkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(gk record);

    int insertSelective(gk record);

    List<gk> selectByExample(gkExample example);

    gk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") gk record, @Param("example") gkExample example);

    int updateByExample(@Param("record") gk record, @Param("example") gkExample example);

    int updateByPrimaryKeySelective(gk record);

    int updateByPrimaryKey(gk record);
}