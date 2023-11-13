package wordnet.genshin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wordnet.genshin.domain.Book_images;
import wordnet.genshin.domain.Book_imagesExample;

public interface Book_imagesMapper {
    long countByExample(Book_imagesExample example);

    int deleteByExample(Book_imagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Book_images record);

    int insertSelective(Book_images record);

    List<Book_images> selectByExampleWithBLOBs(Book_imagesExample example);

    List<Book_images> selectByExample(Book_imagesExample example);

    Book_images selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Book_images record, @Param("example") Book_imagesExample example);

    int updateByExampleWithBLOBs(@Param("record") Book_images record, @Param("example") Book_imagesExample example);

    int updateByExample(@Param("record") Book_images record, @Param("example") Book_imagesExample example);

    int updateByPrimaryKeySelective(Book_images record);

    int updateByPrimaryKeyWithBLOBs(Book_images record);

    int updateByPrimaryKey(Book_images record);
}