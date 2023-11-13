package wordnet.genshin.service;

import wordnet.genshin.domain.Newbook;
import wordnet.genshin.domain.Wrongbook;

import java.util.Date;
import java.util.List;

public interface WrongbookService {
    public boolean InsertOne(String word,String uname);
    public boolean DeleteOne(String word,String uname);
    public Wrongbook selectOne(String word);
    public List<Wrongbook> selectByuser(String uname);
}
