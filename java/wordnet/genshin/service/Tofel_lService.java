package wordnet.genshin.service;

import wordnet.genshin.domain.Tofel_l;

import java.util.List;

public interface Tofel_lService {

    public List<Tofel_l> selectOne(String word);

    public Tofel_l selectOne(int id);

    public List<Tofel_l> selectMuti(Integer from, Integer to,String uname);

}