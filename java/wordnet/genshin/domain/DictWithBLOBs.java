package wordnet.genshin.domain;

public class DictWithBLOBs extends Dict {
    private String definition;

    private String sampleset;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSampleset() {
        return sampleset;
    }

    public void setSampleset(String sampleset) {
        this.sampleset = sampleset;
    }
}