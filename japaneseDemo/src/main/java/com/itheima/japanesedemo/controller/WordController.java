package com.itheima.japanesedemo.controller;

import com.itheima.japanesedemo.mapper.WordMapper;
import com.itheima.japanesedemo.pojo.Result;
import com.itheima.japanesedemo.pojo.Word;
import com.itheima.japanesedemo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping()
    public Result addWord(@RequestBody @Validated Word word) {
        wordService.add(word);
        return Result.success();
    }

    @PutMapping()
    public Result updateWord(@RequestBody @Validated(Word.Update.class) Word word) {
        wordService.update(word);
        return Result.success();
    }
}