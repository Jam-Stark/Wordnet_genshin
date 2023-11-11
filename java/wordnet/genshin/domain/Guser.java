package wordnet.genshin.domain;

public class Guser {
    private Integer uid;

    private String uname;

    private String upassword;

    private String umail;

    private String uwordnet;

    private Long ufinalword;

    private Integer udaily;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail;
    }

    public String getUwordnet() {
        return uwordnet;
    }

    public void setUwordnet(String uwordnet) {
        this.uwordnet = uwordnet;
    }

    public Long getUfinalword() {
        return ufinalword;
    }

    public void setUfinalword(Long ufinalword) {
        this.ufinalword = ufinalword;
    }

    public Integer getUdaily() {
        return udaily;
    }

    public void setUdaily(Integer udaily) {
        this.udaily = udaily;
    }
}