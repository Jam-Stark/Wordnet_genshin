package wordnet.genshin.service;

import wordnet.genshin.domain.Guser;

public interface GuserService {
    public Integer getUid(String name);

    public String getUname(int id);

    public boolean addUser(String name,String password,String mail);

    public  boolean loginCheck(Guser user) ;
}
