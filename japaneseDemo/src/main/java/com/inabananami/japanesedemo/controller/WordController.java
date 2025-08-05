package com.inabananami.japanesedemo.controller;

import com.inabananami.japanesedemo.dao.pojo.Word;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping("/add")
    public Result addWord(@RequestBody @Validated Word word) {
        return wordService.add(word);
    }
    @PutMapping()
    public Result updateWord(@RequestBody @Validated(Word.Update.class) Word word) {
        wordService.update(word);
        return Result.success(null);
    }
    @DeleteMapping()
    public Result deleteWord(Integer id) {
        wordService.delete(id);
        return Result.success(null);
    }
    @PostMapping("/search")
    public Result searchWord(String keyWord) {
        return wordService.search(keyWord);
    }
}