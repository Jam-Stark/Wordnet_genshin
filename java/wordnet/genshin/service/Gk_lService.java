package wordnet.genshin.service;

import wordnet.genshin.domain.GK_l;

import java.util.List;

public interface Gk_lService {

    public List<GK_l> selectOne(String word);

    public GK_l selectOne(int id);

    public List<GK_l> selectMuti(Integer from, Integer to,String uname);

}