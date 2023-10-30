package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.cet6;
import wordnet.genshin.domain.cet6Example;

public interface cet6Mapper {
    long countByExample(cet6Example example);

    int deleteByExample(cet6Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(cet6 record);

    int insertSelective(cet6 record);

    List<cet6> selectByExample(cet6Example example);

    cet6 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") cet6 record, @Param("example") cet6Example example);

    int updateByExample(@Param("record") cet6 record, @Param("example") cet6Example example);

    int updateByPrimaryKeySelective(cet6 record);

    int updateByPrimaryKey(cet6 record);
}