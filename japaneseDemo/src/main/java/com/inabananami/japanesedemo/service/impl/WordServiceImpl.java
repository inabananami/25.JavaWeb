package com.inabananami.japanesedemo.service.impl;

import com.inabananami.japanesedemo.dao.mapper.ReviewMapper;
import com.inabananami.japanesedemo.dao.mapper.WordMapper;
import com.inabananami.japanesedemo.dao.pojo.ReviewLog;
import com.inabananami.japanesedemo.dao.pojo.Word;
import com.inabananami.japanesedemo.service.WordService;
import com.inabananami.japanesedemo.utils.ThreadLocalUtil;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.vo.WordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public Result add(Word word) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        word.setCreateUser(userId);
        wordMapper.add(word);
        reviewMapper.defaultAdd(ReviewLog.defaultSet(word));
        return Result.success(null);
    }

    @Override
    public Result update(Word word) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        System.out.println(word.getId());
        Word newWord = wordMapper.findWordById(word.getId());
        if(!newWord.getCreateUser().equals(userId)){
            return Result.fail(409, "此单词不是您的单词");
        }
        wordMapper.update(word);
        return Result.success(null);
    }

    @Override
    public Result delete(Integer id) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        Word word = wordMapper.findWordById(id);
        if(word == null){
            return Result.fail(410, "此单词不存在");
        }
        ReviewLog reviewLog = reviewMapper.findReviewByWordId(word.getId());
        if (word.getCreateUser() != userId) {
            return Result.fail(409, "此单词不是您的单词");
        }
        reviewMapper.deleteReviewLog(reviewLog.getId());
        wordMapper.delete(id);
        return Result.success(null);
    }

    @Override
    public Result search(String keyWord) {
        List<WordVo> wordVoList = wordMapper.search(keyWord)
                .stream()
                .map(word -> word.toVo())
                .collect(Collectors.toList());
        return Result.success(wordVoList);
    }

    @Override
    public Word findWordById(Integer id) {
        return wordMapper.findWordById(id);
    }

    @Override
    public Result listAllWords() {
        List<WordVo> wordList = wordMapper.listAll();
        return Result.success(wordList);
    }
}