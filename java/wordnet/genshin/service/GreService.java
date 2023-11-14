package wordnet.genshin.service;

import wordnet.genshin.domain.GRE;
import wordnet.genshin.domain.Tofel;

import java.util.List;

public interface GreService {

    public List<GRE> selectOne(String word);

    public GRE selectOne(int id);

    public List<GRE> selectMuti(Integer from, Integer to,String uname);

}
