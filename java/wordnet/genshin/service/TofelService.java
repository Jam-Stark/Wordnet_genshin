package wordnet.genshin.service;

import wordnet.genshin.domain.Tofel;

import java.util.List;

public interface TofelService {

    public List<Tofel> selectOne(String word);

    public Tofel selectOne(int id);

    public List<Tofel> selectMuti(Integer from, Integer to);

}
