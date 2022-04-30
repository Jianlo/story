package com.jian.service.impl;

import com.jian.entity.Letter;
import com.jian.mapper.LetterMapper;
import com.jian.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LetterServiceImpl implements LetterService {


    @Autowired
    private LetterMapper letterMapper;

    @Override
    public void add(Letter letter) {
        letterMapper.add(letter);
    }

    @Override
    public List<Letter> findAll(String sender,String receiver) {
        return letterMapper.findAll(sender,receiver);
    }
}
