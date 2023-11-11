package wordnet.genshin.utils;

public class TableWord {
    private Long id;
    private String word;
    private String definition;
    private String translation;

    public TableWord(){};

    public TableWord(Long id, String word, String definition, String translation) {
        this.id = id;
        this.word = word;
        this.definition = definition;
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "TableWord{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
