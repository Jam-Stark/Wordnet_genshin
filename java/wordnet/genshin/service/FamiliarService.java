package wordnet.genshin.service;

import wordnet.genshin.domain.Familiar;

import java.util.*;

public interface FamiliarService {

public boolean detectWord(String word,String uname);

public List<Familiar> selectAll();

}
