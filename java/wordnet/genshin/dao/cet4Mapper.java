package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.cet4;
import wordnet.genshin.domain.cet4Example;

public interface cet4Mapper {
    long countByExample(cet4Example example);

    int deleteByExample(cet4Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(cet4 record);

    int insertSelective(cet4 record);

    List<cet4> selectByExample(cet4Example example);

    cet4 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") cet4 record, @Param("example") cet4Example example);

    int updateByExample(@Param("record") cet4 record, @Param("example") cet4Example example);

    int updateByPrimaryKeySelective(cet4 record);

    int updateByPrimaryKey(cet4 record);
}