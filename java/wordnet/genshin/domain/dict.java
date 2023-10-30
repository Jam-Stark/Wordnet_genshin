package wordnet.genshin.domain;

public class dict {
    private Integer synsetid;

    private Integer wordid;

    private Integer casedwordid;

    private String lemma;

    private Integer senseid;

    private Short sensenum;

    private Short lexid;

    private Integer tagcount;

    private String sensekey;

    private String cased;

    private String pos;

    private Short lexdomainid;

    public Integer getSynsetid() {
        return synsetid;
    }

    public void setSynsetid(Integer synsetid) {
        this.synsetid = synsetid;
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }

    public Integer getCasedwordid() {
        return casedwordid;
    }

    public void setCasedwordid(Integer casedwordid) {
        this.casedwordid = casedwordid;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public Integer getSenseid() {
        return senseid;
    }

    public void setSenseid(Integer senseid) {
        this.senseid = senseid;
    }

    public Short getSensenum() {
        return sensenum;
    }

    public void setSensenum(Short sensenum) {
        this.sensenum = sensenum;
    }

    public Short getLexid() {
        return lexid;
    }

    public void setLexid(Short lexid) {
        this.lexid = lexid;
    }

    public Integer getTagcount() {
        return tagcount;
    }

    public void setTagcount(Integer tagcount) {
        this.tagcount = tagcount;
    }

    public String getSensekey() {
        return sensekey;
    }

    public void setSensekey(String sensekey) {
        this.sensekey = sensekey;
    }

    public String getCased() {
        return cased;
    }

    public void setCased(String cased) {
        this.cased = cased;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Short getLexdomainid() {
        return lexdomainid;
    }

    public void setLexdomainid(Short lexdomainid) {
        this.lexdomainid = lexdomainid;
    }
}