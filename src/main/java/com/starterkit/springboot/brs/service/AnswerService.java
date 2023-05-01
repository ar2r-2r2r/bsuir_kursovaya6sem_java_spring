package com.starterkit.springboot.brs.service;

import com.starterkit.springboot.brs.dto.model.discussion.AnswerDto;
import com.starterkit.springboot.brs.dto.model.discussion.DiscussionDto;
import com.starterkit.springboot.brs.model.discussion.Discussion;

import java.util.List;

public interface AnswerService {
    AnswerDto create(AnswerDto answerDto);

//    List<Discussion> getAllDiscussions();

    AnswerDto getAnswerById(String id);
}
