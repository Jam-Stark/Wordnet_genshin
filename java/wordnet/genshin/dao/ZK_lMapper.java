package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.ZK_l;
import wordnet.genshin.domain.ZK_lExample;

public interface ZK_lMapper {
    long countByExample(ZK_lExample example);

    int deleteByExample(ZK_lExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZK_l record);

    int insertSelective(ZK_l record);

    List<ZK_l> selectByExample(ZK_lExample example);

    ZK_l selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZK_l record, @Param("example") ZK_lExample example);

    int updateByExample(@Param("record") ZK_l record, @Param("example") ZK_lExample example);

    int updateByPrimaryKeySelective(ZK_l record);

    int updateByPrimaryKey(ZK_l record);
}