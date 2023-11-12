package wordnet.genshin.service;


import wordnet.genshin.domain.Urank;

import java.util.List;

public interface UrankService {
    public List<Urank> selectUserRank(String uname);

    public boolean awardMedal(String Date);

    public boolean addRank(String Date,Integer number,String uname);
}