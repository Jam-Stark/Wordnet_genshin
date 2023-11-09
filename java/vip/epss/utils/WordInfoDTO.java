package vip.epss.utils;

import vip.epss.domain.DictWithBLOBs;

import java.util.*;

public class WordInfoDTO {
    public WordInfoDTO() {
        this.sampleset = new ArrayList<>() ;
        this.SynonymWords=new ArrayList<>();
        this.wordLike=new ArrayList<>();
    }

    private String spelling;
    private String phonetic;
    private String definition;
    private String translation;
    private String tag;
    private String exchange;//根据“/”划分输出
    private List<String> exchangeEvery;

    public List<String> getExchangeEvery() {
        return exchangeEvery;
    }

    public void setExchangeEvery(List<String> exchangeEvery) {
        this.exchangeEvery = exchangeEvery;
    }

    private List<String> sampleset;

    public void setSampleset(List<String> sampleset) {
        this.sampleset = sampleset;
    }

    public List<String> getSampleset() {
        return sampleset;
    }

    private String lemma;

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }
    //用不到position，只在controller里作判断条件
    private char position;

    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    private List<String> SynonymWords;

    public List<String> getSynonymWords() {
        return SynonymWords;
    }

    public void setSynonymWords(List<String> synonymWords) {
        SynonymWords = synonymWords;
    }

    private List<String> wordLike;

    public List<String> getWordLike() {
        return wordLike;
    }

    public void setWordLike(List<String> wordLike) {
        this.wordLike = wordLike;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }
    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSpelling() {
        return spelling;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public String getDefinition() {
        return definition;
    }

    public String getTranslation() {
        return translation;
    }

    public String getTag() {
        return tag;
    }

    public String getExchange() {
        return exchange;
    }

}

