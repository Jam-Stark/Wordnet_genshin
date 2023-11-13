package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.GRE_l;
import wordnet.genshin.domain.GRE_lExample;

public interface GRE_lMapper {
    long countByExample(GRE_lExample example);

    int deleteByExample(GRE_lExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GRE_l record);

    int insertSelective(GRE_l record);

    List<GRE_l> selectByExample(GRE_lExample example);

    GRE_l selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GRE_l record, @Param("example") GRE_lExample example);

    int updateByExample(@Param("record") GRE_l record, @Param("example") GRE_lExample example);

    int updateByPrimaryKeySelective(GRE_l record);

    int updateByPrimaryKey(GRE_l record);
}