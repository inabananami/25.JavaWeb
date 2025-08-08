package com.inabananami.japanesedemo.controller;

import com.inabananami.japanesedemo.dao.pojo.Word;
import com.inabananami.japanesedemo.service.ReviewService;
import com.inabananami.japanesedemo.service.WordService;
import com.inabananami.japanesedemo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private WordService wordService;

    @PostMapping()
    public Result reviewWord(@RequestParam Integer id, int quality) {
        return reviewService.review(id, quality);
    }
    @GetMapping("/can-review")
    public Result getAllReview(@RequestParam Integer wordId) {
        Word word = wordService.findWordById(wordId);
        if(word == null) return Result.fail(404, "找不到单词");
        return reviewService.canReview(wordId);
    }
}