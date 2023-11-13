package wordnet.genshin.service;

import wordnet.genshin.domain.Newbook;

import java.util.Date;
import java.util.List;

public interface NewbookService {
    public boolean InsertOne(String word,String uname);
    public boolean DeleteOne(String word,String uname);
    public Newbook selectOne(String word);
    public List<Newbook> selectByuser(String uname);
}
