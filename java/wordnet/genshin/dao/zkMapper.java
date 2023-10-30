package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.zk;
import wordnet.genshin.domain.zkExample;

public interface zkMapper {
    long countByExample(zkExample example);

    int deleteByExample(zkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(zk record);

    int insertSelective(zk record);

    List<zk> selectByExample(zkExample example);

    zk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") zk record, @Param("example") zkExample example);

    int updateByExample(@Param("record") zk record, @Param("example") zkExample example);

    int updateByPrimaryKeySelective(zk record);

    int updateByPrimaryKey(zk record);
}