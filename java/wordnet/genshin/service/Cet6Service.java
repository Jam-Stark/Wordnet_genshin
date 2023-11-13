package wordnet.genshin.service;

import wordnet.genshin.domain.Cet6;

import java.util.List;

public interface Cet6Service {

    public List<Cet6> selectOne(String word);

    public Cet6 selectOne(int id);

    public List<Cet6> selectMuti(Integer from, Integer to);

}