package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.GK_l;
import wordnet.genshin.domain.GK_lExample;

public interface GK_lMapper {
    long countByExample(GK_lExample example);

    int deleteByExample(GK_lExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GK_l record);

    int insertSelective(GK_l record);

    List<GK_l> selectByExample(GK_lExample example);

    GK_l selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GK_l record, @Param("example") GK_lExample example);

    int updateByExample(@Param("record") GK_l record, @Param("example") GK_lExample example);

    int updateByPrimaryKeySelective(GK_l record);

    int updateByPrimaryKey(GK_l record);
}