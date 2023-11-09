package vip.epss.domain;

import java.util.Date;

public class Wrongbook {
    private Integer wrongid;

    private String word;

    private Date wrongdata;

    public Integer getWrongid() {
        return wrongid;
    }

    public void setWrongid(Integer wrongid) {
        this.wrongid = wrongid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getWrongdata() {
        return wrongdata;
    }

    public void setWrongdata(Date wrongdata) {
        this.wrongdata = wrongdata;
    }
}