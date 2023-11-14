package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.Book_imagesMapper;
import wordnet.genshin.dao.ImagesMapper;
import wordnet.genshin.dao.UserImageMapper;
import wordnet.genshin.domain.*;
import wordnet.genshin.service.ImageService;

import java.util.List;

@Service(value = "ImageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImagesMapper imagesMapper;

    @Autowired
    private Book_imagesMapper bookImagesMapper;

    @Autowired
    private UserImageMapper userImageMapper;

    @Override
    public Images getSculpture(String dataName) {
        ImagesExample imagesExample=new ImagesExample();
        ImagesExample.Criteria criteria=imagesExample.createCriteria();
        criteria.andNameEqualTo(dataName);
        return imagesMapper.selectByExampleWithBLOBs(imagesExample).get(0);
    }

    @Override
    public Book_images getBookImage(String dataName) {
        Book_imagesExample bookImagesExample = new Book_imagesExample();
        Book_imagesExample.Criteria criteria = bookImagesExample.createCriteria();
        criteria.andNameEqualTo(dataName);
        List<Book_images> imagesList = bookImagesMapper.selectByExampleWithBLOBs(bookImagesExample);

        if (imagesList.isEmpty()) {
            // 如果结果为空，可以抛出异常或者返回默认值
            System.out.println("没找到二进制文件");
            // 或者返回默认的 Book_images 对象
            // return new Book_images();
        }

        return imagesList.get(0);
    }


    @Override
    public Images getSculptureByUname(String uname) {
        UserImageExample userImageExample=new UserImageExample();
        UserImageExample.Criteria criteria=userImageExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        ImagesExample imagesExample=new ImagesExample();
        ImagesExample.Criteria criteria1=imagesExample.createCriteria();
        criteria1.andNameEqualTo(userImageMapper.selectByExample(userImageExample).get(0).getFname());

        return imagesMapper.selectByExampleWithBLOBs(imagesExample).get(0);
    }

    @Override
    public boolean setUserSculpture(String uname, String dataName) {
        UserImageExample userImageExample=new UserImageExample();
        UserImageExample.Criteria criteria=userImageExample.createCriteria();
        criteria.andUnameEqualTo(uname);
        System.out.println("Final jpg: "+dataName);
        System.out.println("Username:  "+uname);
        UserImage item=new UserImage();
        item.setFname(dataName);
        item.setUname(uname);
        userImageMapper.updateByExample(item,userImageExample);
        return true;
    }

    @Override
    public List<Book_images> getAllBook() {

        Book_imagesExample bookImagesExample=new Book_imagesExample();
        Book_imagesExample.Criteria criteria=bookImagesExample.createCriteria();
        criteria.andIdIsNotNull();

        return bookImagesMapper.selectByExampleWithBLOBs(bookImagesExample);
    }

    @Override
    public List<Images> getAllSculpture() {
        ImagesExample imagesExample=new ImagesExample();
        ImagesExample.Criteria criteria=imagesExample.createCriteria();
        criteria.andIdIsNotNull();

        return imagesMapper.selectByExampleWithBLOBs(imagesExample);
    }

}
