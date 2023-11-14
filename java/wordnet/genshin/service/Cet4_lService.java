package wordnet.genshin.service;

import wordnet.genshin.domain.Cet4_l;

import java.util.List;

public interface Cet4_lService {

    public List<Cet4_l> selectOne(String word);

    public Cet4_l selectOne(int id);

    public List<Cet4_l> selectMuti(Integer from, Integer to,String uname);

}