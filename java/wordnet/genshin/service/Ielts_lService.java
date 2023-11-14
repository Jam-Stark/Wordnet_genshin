package wordnet.genshin.service;

import wordnet.genshin.domain.Ielts_l;

import java.util.List;

public interface Ielts_lService {

    public List<Ielts_l> selectOne(String word);

    public Ielts_l selectOne(int id);

    public List<Ielts_l> selectMuti(Integer from, Integer to,String uname);

}