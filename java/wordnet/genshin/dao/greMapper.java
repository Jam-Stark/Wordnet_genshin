package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.gre;
import wordnet.genshin.domain.greExample;

public interface greMapper {
    long countByExample(greExample example);

    int deleteByExample(greExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(gre record);

    int insertSelective(gre record);

    List<gre> selectByExample(greExample example);

    gre selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") gre record, @Param("example") greExample example);

    int updateByExample(@Param("record") gre record, @Param("example") greExample example);

    int updateByPrimaryKeySelective(gre record);

    int updateByPrimaryKey(gre record);
}