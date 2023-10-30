package wordnet.genshin.domain;

public class Score {
    private Integer scId;

    private String cname;

    private Integer scValue;

    private Integer stId;

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getScValue() {
        return scValue;
    }

    public void setScValue(Integer scValue) {
        this.scValue = scValue;
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }
}