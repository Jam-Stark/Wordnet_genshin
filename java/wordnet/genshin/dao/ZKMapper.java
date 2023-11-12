package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.ZK;
import wordnet.genshin.domain.ZKExample;

public interface ZKMapper {
    long countByExample(ZKExample example);

    int deleteByExample(ZKExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZK record);

    int insertSelective(ZK record);

    List<ZK> selectByExample(ZKExample example);

    ZK selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZK record, @Param("example") ZKExample example);

    int updateByExample(@Param("record") ZK record, @Param("example") ZKExample example);

    int updateByPrimaryKeySelective(ZK record);

    int updateByPrimaryKey(ZK record);
}