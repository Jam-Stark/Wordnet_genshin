package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Zk;
import wordnet.genshin.domain.ZkExample;

public interface ZkMapper {
    long countByExample(ZkExample example);

    int deleteByExample(ZkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zk record);

    int insertSelective(Zk record);

    List<Zk> selectByExample(ZkExample example);

    Zk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zk record, @Param("example") ZkExample example);

    int updateByExample(@Param("record") Zk record, @Param("example") ZkExample example);

    int updateByPrimaryKeySelective(Zk record);

    int updateByPrimaryKey(Zk record);
}