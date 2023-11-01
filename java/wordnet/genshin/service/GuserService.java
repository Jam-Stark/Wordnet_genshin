package wordnet.genshin.service;

public interface GuserService {
    public Integer getUid(String name);

    public String getUname(int id);

    public boolean addUser(String name,String password,String mail);
}
