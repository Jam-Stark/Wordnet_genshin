package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.ielts;
import wordnet.genshin.domain.ieltsExample;

public interface ieltsMapper {
    long countByExample(ieltsExample example);

    int deleteByExample(ieltsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ielts record);

    int insertSelective(ielts record);

    List<ielts> selectByExample(ieltsExample example);

    ielts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ielts record, @Param("example") ieltsExample example);

    int updateByExample(@Param("record") ielts record, @Param("example") ieltsExample example);

    int updateByPrimaryKeySelective(ielts record);

    int updateByPrimaryKey(ielts record);
}