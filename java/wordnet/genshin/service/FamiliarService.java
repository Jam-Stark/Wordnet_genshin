package wordnet.genshin.service;

import wordnet.genshin.domain.Familiar;

import java.util.*;

public interface FamiliarService {

public boolean detectWord(String word);

public List<Familiar> selectAll();

}
