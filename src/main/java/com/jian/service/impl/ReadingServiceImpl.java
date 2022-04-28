package com.jian.service.impl;

import com.jian.dto.ReadingDto;
import com.jian.entity.Reading;
import com.jian.mapper.ReadingMapper;
import com.jian.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingMapper readingMapper;


    @Override
    public void add(Reading reading) {
        readingMapper.add(reading);
    }

    @Override
    public void update(Reading reading) {
        readingMapper.update(reading);
    }

    @Override
    public void deleteByReadId(String readId) {
        readingMapper.deleteByReadId(readId);
    }

    @Override
    public void deleteAll(String reader) {
        readingMapper.deleteAll(reader);
    }

    @Override
    public List<Reading> findAll(String reader) {
        return readingMapper.findAll(reader);
    }

    @Override
    public Reading findBySidAndReader(ReadingDto readingDto) {
        return readingMapper.findBySidAndReader(readingDto);
    }
}
