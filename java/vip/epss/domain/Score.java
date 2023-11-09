package vip.epss.domain;

public class Score {
    private Integer scid;

    private String cname;

    private Float cvalue;

    private Integer fstid;

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Float getCvalue() {
        return cvalue;
    }

    public void setCvalue(Float cvalue) {
        this.cvalue = cvalue;
    }

    public Integer getFstid() {
        return fstid;
    }

    public void setFstid(Integer fstid) {
        this.fstid = fstid;
    }
}