package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Cet6_l;
import wordnet.genshin.domain.Cet6_lExample;

public interface Cet6_lMapper {
    long countByExample(Cet6_lExample example);

    int deleteByExample(Cet6_lExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cet6_l record);

    int insertSelective(Cet6_l record);

    List<Cet6_l> selectByExample(Cet6_lExample example);

    Cet6_l selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cet6_l record, @Param("example") Cet6_lExample example);

    int updateByExample(@Param("record") Cet6_l record, @Param("example") Cet6_lExample example);

    int updateByPrimaryKeySelective(Cet6_l record);

    int updateByPrimaryKey(Cet6_l record);
}