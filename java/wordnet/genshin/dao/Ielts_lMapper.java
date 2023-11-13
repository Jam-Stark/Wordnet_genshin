package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Ielts_l;
import wordnet.genshin.domain.Ielts_lExample;

public interface Ielts_lMapper {
    long countByExample(Ielts_lExample example);

    int deleteByExample(Ielts_lExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ielts_l record);

    int insertSelective(Ielts_l record);

    List<Ielts_l> selectByExample(Ielts_lExample example);

    Ielts_l selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ielts_l record, @Param("example") Ielts_lExample example);

    int updateByExample(@Param("record") Ielts_l record, @Param("example") Ielts_lExample example);

    int updateByPrimaryKeySelective(Ielts_l record);

    int updateByPrimaryKey(Ielts_l record);
}