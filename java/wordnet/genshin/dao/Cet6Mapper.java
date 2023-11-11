package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Cet6;
import wordnet.genshin.domain.Cet6Example;

public interface Cet6Mapper {
    long countByExample(Cet6Example example);

    int deleteByExample(Cet6Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cet6 record);

    int insertSelective(Cet6 record);

    List<Cet6> selectByExample(Cet6Example example);

    Cet6 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cet6 record, @Param("example") Cet6Example example);

    int updateByExample(@Param("record") Cet6 record, @Param("example") Cet6Example example);

    int updateByPrimaryKeySelective(Cet6 record);

    int updateByPrimaryKey(Cet6 record);
}