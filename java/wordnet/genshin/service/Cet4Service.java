package wordnet.genshin.service;

import wordnet.genshin.domain.Cet4;

import java.util.List;

public interface Cet4Service {

    public List<Cet4> selectOne(String word);

    public Cet4 selectOne(int id);

    public List<Cet4> selectMuti(Integer from, Integer to,String uname);

}
