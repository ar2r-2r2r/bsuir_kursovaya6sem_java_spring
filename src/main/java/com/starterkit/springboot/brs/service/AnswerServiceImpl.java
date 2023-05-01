package com.starterkit.springboot.brs.service;

import com.starterkit.springboot.brs.dto.mapper.AnswerMapper;
import com.starterkit.springboot.brs.dto.mapper.DiscussionMapper;
import com.starterkit.springboot.brs.dto.model.discussion.AnswerDto;
import com.starterkit.springboot.brs.dto.model.discussion.DiscussionDto;
import com.starterkit.springboot.brs.model.discussion.Answer;
import com.starterkit.springboot.brs.model.discussion.Discussion;
import com.starterkit.springboot.brs.repository.discussion.AnswerRepository;
import com.starterkit.springboot.brs.repository.discussion.DiscussionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public AnswerDto create(AnswerDto answerDto) {
        Answer answer=new Answer()
                .setAnswer(answerDto.getAnswer())
                .setQuestion_id(answerDto.getQuestion_id());
        return AnswerMapper.toAnswerDto(answerRepository.save(answer));
    }

    @Override
    public AnswerDto getAnswerById(String id) {
        return null;
    }
}
