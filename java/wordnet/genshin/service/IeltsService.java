package wordnet.genshin.service;

import wordnet.genshin.domain.Ielts;

import java.util.List;

public interface IeltsService {

    public List<Ielts> selectOne(String word);

    public Ielts selectOne(int id);

    public List<Ielts> selectMuti(Integer from, Integer to,String uname);

}
