package com.inabananami.japanesedemo.service.impl;

import com.inabananami.japanesedemo.dao.mapper.ReviewMapper;
import com.inabananami.japanesedemo.dao.mapper.WordMapper;
import com.inabananami.japanesedemo.dao.pojo.ReviewLog;
import com.inabananami.japanesedemo.dao.pojo.Word;
import com.inabananami.japanesedemo.service.WordService;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.vo.WordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public Result add(Word word) {
        wordMapper.add(word);
        reviewMapper.defaultAdd(ReviewLog.defaultSet(word));
        return Result.success(null);
    }

    @Override
    public Result update(Word word) {
        wordMapper.update(word);
        return Result.success(null);
    }

    @Override
    public Result delete(Integer id) {
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
}