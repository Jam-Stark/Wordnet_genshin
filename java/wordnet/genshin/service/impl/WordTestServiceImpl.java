package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.Words_en_cnMapper;
import wordnet.genshin.domain.Words_en_cn;
import wordnet.genshin.domain.Words_en_cnExample;
import wordnet.genshin.service.WordTestService;

import java.util.Collections;
import java.util.List;

@Service(value ="wordTestService")
public class WordTestServiceImpl implements WordTestService {
    @Autowired
    private Words_en_cnMapper words_en_cnMapper;
    private Words_en_cn words_en_cn;
    @Override
    public List<Words_en_cn> getRandomWords(int count) {
//        if (words_en_cnMapper == null) {
//            // 处理空指针异常，返回空列表或其他默认值
//            return Collections.emptyList();
//        }
        //
        Words_en_cnExample example= new Words_en_cnExample();
        example.createCriteria().andWordGreaterThan("");
        List<Words_en_cn> words = words_en_cnMapper.selectByExample(example);
        //List<Words_en_cn> words = words_en_cnMapper.findAllWords();
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
