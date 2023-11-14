package wordnet.genshin.service;

import wordnet.genshin.domain.ZK_l;

import java.util.List;

public interface Zk_lService {

    public List<ZK_l> selectOne(String word);

    public ZK_l selectOne(int id);

    public List<ZK_l> selectMuti(Integer from, Integer to,String uname);

}