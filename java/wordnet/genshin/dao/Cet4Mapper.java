package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Cet4;
import wordnet.genshin.domain.Cet4Example;

public interface Cet4Mapper {
    long countByExample(Cet4Example example);

    int deleteByExample(Cet4Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cet4 record);

    int insertSelective(Cet4 record);

    List<Cet4> selectByExample(Cet4Example example);

    Cet4 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cet4 record, @Param("example") Cet4Example example);

    int updateByExample(@Param("record") Cet4 record, @Param("example") Cet4Example example);

    int updateByPrimaryKeySelective(Cet4 record);

    int updateByPrimaryKey(Cet4 record);
}