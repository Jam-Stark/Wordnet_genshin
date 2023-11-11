package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Ielts;
import wordnet.genshin.domain.IeltsExample;

public interface IeltsMapper {
    long countByExample(IeltsExample example);

    int deleteByExample(IeltsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ielts record);

    int insertSelective(Ielts record);

    List<Ielts> selectByExample(IeltsExample example);

    Ielts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ielts record, @Param("example") IeltsExample example);

    int updateByExample(@Param("record") Ielts record, @Param("example") IeltsExample example);

    int updateByPrimaryKeySelective(Ielts record);

    int updateByPrimaryKey(Ielts record);
}