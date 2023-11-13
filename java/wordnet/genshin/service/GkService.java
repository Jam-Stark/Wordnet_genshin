package wordnet.genshin.service;

import wordnet.genshin.domain.Gk;

import java.util.List;

public interface GkService {

    public List<Gk> selectOne(String word);

    public Gk selectOne(int id);

    public List<Gk> selectMuti(Integer from, Integer to);

}
