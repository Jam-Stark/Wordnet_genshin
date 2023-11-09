package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.Words_en_cnMapper;
import vip.epss.domain.Words_en_cn;
import vip.epss.service.WordTestService;

import java.util.Collections;
import java.util.List;

@Service(value ="wordTestService")
public class WordTestServiceImpl implements WordTestService {
    @Autowired
    private Words_en_cnMapper words_en_cnMapper;
    private Words_en_cn words_en_cn;
    @Override
    public List<Words_en_cn> getRandomWords(int count) {
        List<Words_en_cn> words = words_en_cnMapper.findAllWords();
        Collections.shuffle(words);
        return words.subList(0, Math.min(count, words.size()));
    }
    @Override
    public boolean validateWord(String word, String userInput) {
        // Validate if user's input matches the correct word
        return word.equals(userInput);
    }
    @Override
    public int calculateScore(int previousScore) {
        // Perform scoring logic and return the new score
        return previousScore + 1;
    }
}
