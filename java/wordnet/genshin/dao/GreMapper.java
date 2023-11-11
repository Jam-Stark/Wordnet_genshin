package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Gre;
import wordnet.genshin.domain.GreExample;

public interface GreMapper {
    long countByExample(GreExample example);

    int deleteByExample(GreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gre record);

    int insertSelective(Gre record);

    List<Gre> selectByExample(GreExample example);

    Gre selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gre record, @Param("example") GreExample example);

    int updateByExample(@Param("record") Gre record, @Param("example") GreExample example);

    int updateByPrimaryKeySelective(Gre record);

    int updateByPrimaryKey(Gre record);
}