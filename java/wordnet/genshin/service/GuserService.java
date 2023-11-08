package wordnet.genshin.service;

import wordnet.genshin.domain.Guser;

public interface GuserService {
    public Integer getUid(String name);

    public String getUname(Integer id);

    public Long getUfinalword(String name);

    public Integer getUdaily(String name);

    public String getWordnet(String uname);

    public boolean addUser(String name,String password,String mail);

    public boolean resetPass(String name,String password);

    public  boolean loginCheck(Guser user) ;

    public boolean loginCheck_(String name,String password);

    public boolean setWordbook(String book,String uname,Integer daily);

    public boolean wordRecord(Long id,String uname);

    public boolean checkBook(String uname);
}
