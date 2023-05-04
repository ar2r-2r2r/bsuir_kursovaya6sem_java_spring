package com.starterkit.springboot.brs.dto.mapper;

import com.starterkit.springboot.brs.dto.model.discussion.AnswerDto;
import com.starterkit.springboot.brs.dto.model.discussion.DiscussionDto;
import com.starterkit.springboot.brs.model.discussion.Answer;
import com.starterkit.springboot.brs.model.discussion.Discussion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class AnswerMapper {
    public static AnswerDto toAnswerDto(Answer answer){
        return new AnswerDto()
                .setAnswer(answer.getAnswer())
                .setQid(answer.getQid());
    }
}
