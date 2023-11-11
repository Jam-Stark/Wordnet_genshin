package wordnet.genshin.service;

import wordnet.genshin.domain.Wrongbook;

import java.util.Date;

public interface WrongbookService {
    public boolean InsertOne(String word, Date date);
    public boolean DeleteOne(String word);
    public Wrongbook selectOne(String word);
}
