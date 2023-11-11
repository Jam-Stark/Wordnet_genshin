package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wordnet.genshin.domain.Words_en_cn;
import wordnet.genshin.service.WordTestService;

import java.util.List;

@RestController
@RequestMapping(value = "singleTest")
public class SingleTestController {
    @Autowired
    private WordTestService wordTestService;
    @ResponseBody
    @RequestMapping(value = "/single",method = RequestMethod.GET)
    public boolean performTest(
            @RequestParam(value = "i") int i,
            @RequestParam(value = "spelling") String spelling,
            @RequestParam(value = "List") List<Words_en_cn> List

    ) {

        boolean isValid = wordTestService.validateWord(List.get(i).getWord(), spelling);
        return isValid;
    }
}
