package wordnet.genshin.service;

import wordnet.genshin.domain.Gre;
import wordnet.genshin.domain.Tofel;

import java.util.List;

public interface GreService {

    public List<Gre> selectOne(String word);

    public Gre selectOne(int id);

    public List<Gre> selectMuti(Integer from, Integer to);

}
