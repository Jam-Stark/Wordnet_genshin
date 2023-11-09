package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Newbook;
import vip.epss.domain.NewbookExample;

public interface NewbookMapper {
    long countByExample(NewbookExample example);

    int deleteByExample(NewbookExample example);

    int deleteByPrimaryKey(Integer newid);

    int insert(Newbook record);

    int insertSelective(Newbook record);

    List<Newbook> selectByExample(NewbookExample example);

    Newbook selectByPrimaryKey(Integer newid);

    int updateByExampleSelective(@Param("record") Newbook record, @Param("example") NewbookExample example);

    int updateByExample(@Param("record") Newbook record, @Param("example") NewbookExample example);

    int updateByPrimaryKeySelective(Newbook record);

    int updateByPrimaryKey(Newbook record);
}