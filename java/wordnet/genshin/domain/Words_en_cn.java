package wordnet.genshin.domain;

public class Words_en_cn {
    private String word;

    private String phonetic;

    private String pos;

    private Integer collins;

    private Integer oxford;

    private String tag;

    private Integer bnc;

    private Integer frq;

    private String exchange;

    private String audio;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getCollins() {
        return collins;
    }

    public void setCollins(Integer collins) {
        this.collins = collins;
    }

    public Integer getOxford() {
        return oxford;
    }

    public void setOxford(Integer oxford) {
        this.oxford = oxford;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getBnc() {
        return bnc;
    }

    public void setBnc(Integer bnc) {
        this.bnc = bnc;
    }

    public Integer getFrq() {
        return frq;
    }

    public void setFrq(Integer frq) {
        this.frq = frq;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    ////////个人后续补充
//    private String definition;
//    private String translation;
//    public String getDefinition() {
//        return definition;
//    }
//
//    public void setDefinition(String definition) {
//        this.definition = definition;
//    }
//    public String getTranslation() {
//        return translation;
//    }
//
//    public void setTranslation(String translation) {
//        this.translation = translation;
//    }

}