package wordnet.genshin.service;

import wordnet.genshin.domain.Book_images;
import wordnet.genshin.domain.Images;

import java.util.List;

public interface ImageService {
    public Images getSculpture(String dataName);

    public Book_images getBookImage(String dataName);

    public Images getSculptureByUname(String uname);

    public boolean setUserSculpture(String uname,String dataName);

    public List<Book_images> getAllBook();

    public List<Images> getAllSculpture();

}
