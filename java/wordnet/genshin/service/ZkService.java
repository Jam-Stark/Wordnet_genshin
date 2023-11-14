package wordnet.genshin.service;

import wordnet.genshin.domain.ZK;

import java.util.List;

public interface ZkService {

    public List<ZK> selectOne(String word);

    public ZK selectOne(int id);

    public List<ZK> selectMuti(Integer from, Integer to,String uname);

}