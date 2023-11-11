package wordnet.genshin.utils;

public class TableWord {
    private Long id;
    private String word;
    private String phonetic;
    private String translation;

    public TableWord(){};

    public TableWord(Long id, String word, String phonetic, String translation) {
        this.id = id;
        this.word = word;
        this.phonetic = phonetic;
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

    public String getphonetic() {
        return phonetic;
    }

    public void setphonetic(String phonetic) {
        this.phonetic = phonetic;
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
                ", phonetic='" + phonetic + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
