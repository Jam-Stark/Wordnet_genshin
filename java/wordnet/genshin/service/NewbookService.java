package wordnet.genshin.service;

import wordnet.genshin.domain.Newbook;

import java.util.Date;

public interface NewbookService {
    public boolean InsertOne(String word, Date date);
    public boolean DeleteOne(String word);
    public Newbook selectOne(String word);
}
