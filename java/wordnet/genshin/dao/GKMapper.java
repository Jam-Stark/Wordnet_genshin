package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.GK;
import wordnet.genshin.domain.GKExample;

public interface GKMapper {
    long countByExample(GKExample example);

    int deleteByExample(GKExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GK record);

    int insertSelective(GK record);

    List<GK> selectByExample(GKExample example);

    GK selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GK record, @Param("example") GKExample example);

    int updateByExample(@Param("record") GK record, @Param("example") GKExample example);

    int updateByPrimaryKeySelective(GK record);

    int updateByPrimaryKey(GK record);
}