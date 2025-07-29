package com.itheima.japanesedemo.service.impl;

import com.itheima.japanesedemo.mapper.WordMapper;
import com.itheima.japanesedemo.pojo.Word;
import com.itheima.japanesedemo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;

    @Override
    public void add(Word word) {
        wordMapper.add(word);
    }

    @Override
    public void update(Word word) {
        wordMapper.update(word);
    }
}