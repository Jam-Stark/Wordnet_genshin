package wordnet.genshin.service;

import wordnet.genshin.domain.Book_images;
import wordnet.genshin.domain.Images;

public interface ImageService {
    public Images getSculpture(String dataName);

    public Book_images getBookImage(String dataName);

    public Images getSculptureByUname(String uname);

    public void setUserSculpture(String uname,String dataName);

}
