package wordnet.genshin.service;

import wordnet.genshin.domain.GRE_l;

import java.util.List;

public interface Gre_lService {

    public List<GRE_l> selectOne(String word);

    public GRE_l selectOne(int id);

    public List<GRE_l> selectMuti(Integer from, Integer to,String uname);

}