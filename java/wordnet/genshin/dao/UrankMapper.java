package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Urank;
import wordnet.genshin.domain.UrankExample;

public interface UrankMapper {
    long countByExample(UrankExample example);

    int deleteByExample(UrankExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Urank record);

    int insertSelective(Urank record);

    List<Urank> selectByExample(UrankExample example);

    Urank selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Urank record, @Param("example") UrankExample example);

    int updateByExample(@Param("record") Urank record, @Param("example") UrankExample example);

    int updateByPrimaryKeySelective(Urank record);

    int updateByPrimaryKey(Urank record);
}