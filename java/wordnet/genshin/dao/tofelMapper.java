package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.tofel;
import wordnet.genshin.domain.tofelExample;

public interface tofelMapper {
    long countByExample(tofelExample example);

    int deleteByExample(tofelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(tofel record);

    int insertSelective(tofel record);

    List<tofel> selectByExample(tofelExample example);

    tofel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") tofel record, @Param("example") tofelExample example);

    int updateByExample(@Param("record") tofel record, @Param("example") tofelExample example);

    int updateByPrimaryKeySelective(tofel record);

    int updateByPrimaryKey(tofel record);
}