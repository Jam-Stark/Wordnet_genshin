package wordnet.genshin.service;

import wordnet.genshin.domain.Familiar;

import java.util.*;

public interface FamiliarService {

    public boolean addWord(String word,String uname);

    public boolean detectWord(String word,String uname);

    public boolean deleteWord(String word,String uname);

    public List<Familiar> selectByuser(String uname);

}
