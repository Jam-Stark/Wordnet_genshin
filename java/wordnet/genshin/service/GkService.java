package wordnet.genshin.service;

import wordnet.genshin.domain.GK;

import java.util.List;

public interface GkService {

    public List<GK> selectOne(String word);

    public GK selectOne(int id);

    public List<GK> selectMuti(Integer from, Integer to);

}
