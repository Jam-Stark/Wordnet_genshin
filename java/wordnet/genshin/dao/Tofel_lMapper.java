package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Tofel_l;
import wordnet.genshin.domain.Tofel_lExample;

public interface Tofel_lMapper {
    long countByExample(Tofel_lExample example);

    int deleteByExample(Tofel_lExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tofel_l record);

    int insertSelective(Tofel_l record);

    List<Tofel_l> selectByExample(Tofel_lExample example);

    Tofel_l selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tofel_l record, @Param("example") Tofel_lExample example);

    int updateByExample(@Param("record") Tofel_l record, @Param("example") Tofel_lExample example);

    int updateByPrimaryKeySelective(Tofel_l record);

    int updateByPrimaryKey(Tofel_l record);
}