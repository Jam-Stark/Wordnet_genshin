package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Tofel;
import wordnet.genshin.domain.TofelExample;

public interface TofelMapper {
    long countByExample(TofelExample example);

    int deleteByExample(TofelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tofel record);

    int insertSelective(Tofel record);

    List<Tofel> selectByExample(TofelExample example);

    Tofel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tofel record, @Param("example") TofelExample example);

    int updateByExample(@Param("record") Tofel record, @Param("example") TofelExample example);

    int updateByPrimaryKeySelective(Tofel record);

    int updateByPrimaryKey(Tofel record);
}