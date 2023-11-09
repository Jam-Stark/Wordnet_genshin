package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Dict;
import vip.epss.domain.DictExample;
import vip.epss.domain.DictWithBLOBs;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int insert(DictWithBLOBs record);

    int insertSelective(DictWithBLOBs record);

    List<DictWithBLOBs> selectByExampleWithBLOBs(DictExample example);

    List<Dict> selectByExample(DictExample example);

    int updateByExampleSelective(@Param("record") DictWithBLOBs record, @Param("example") DictExample example);

    int updateByExampleWithBLOBs(@Param("record") DictWithBLOBs record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);
}