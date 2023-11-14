package wordnet.genshin.service;

import wordnet.genshin.domain.Cet6_l;

import java.util.List;

public interface Cet6_lService {

    public List<Cet6_l> selectOne(String word);

    public Cet6_l selectOne(int id);

    public List<Cet6_l> selectMuti(Integer from, Integer to,String uname);

}