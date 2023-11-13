package wordnet.genshin.service;

import wordnet.genshin.domain.Zk;

import java.util.List;

public interface ZkService {

    public List<Zk> selectOne(String word);

    public Zk selectOne(int id);

    public List<Zk> selectMuti(Integer from, Integer to);

}