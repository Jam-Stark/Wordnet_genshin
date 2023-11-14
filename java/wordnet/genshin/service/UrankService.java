package wordnet.genshin.service;


import wordnet.genshin.domain.Urank;
import wordnet.genshin.utils.MyPair;

import java.util.List;

public interface UrankService {
    public List<Urank> selectUserRank(String uname);

    public List<MyPair> awardMedal(String Date);

    public boolean addRank(String Date,String uname);

    public List<Urank> selectAllbyDay(String Date);
    public String getMedal(String Date,String uname);
}