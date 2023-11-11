package wordnet.genshin.domain;

import java.util.Date;

public class Newbook {
    private Integer newid;

    private String newword;

    private Date newdata;

    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    public String getNewword() {
        return newword;
    }

    public void setNewword(String newword) {
        this.newword = newword;
    }

    public Date getNewdata() {
        return newdata;
    }

    public void setNewdata(Date newdata) {
        this.newdata = newdata;
    }
}