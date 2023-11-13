package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Cet4_l;
import wordnet.genshin.domain.Cet4_lExample;

public interface Cet4_lMapper {
    long countByExample(Cet4_lExample example);

    int deleteByExample(Cet4_lExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cet4_l record);

    int insertSelective(Cet4_l record);

    List<Cet4_l> selectByExample(Cet4_lExample example);

    Cet4_l selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cet4_l record, @Param("example") Cet4_lExample example);

    int updateByExample(@Param("record") Cet4_l record, @Param("example") Cet4_lExample example);

    int updateByPrimaryKeySelective(Cet4_l record);

    int updateByPrimaryKey(Cet4_l record);
}