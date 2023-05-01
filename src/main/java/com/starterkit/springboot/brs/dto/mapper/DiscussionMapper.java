package com.starterkit.springboot.brs.dto.mapper;

import com.starterkit.springboot.brs.dto.model.discussion.AnswerDto;
import com.starterkit.springboot.brs.dto.model.discussion.DiscussionDto;
import com.starterkit.springboot.brs.dto.model.user.RoleDto;
import com.starterkit.springboot.brs.model.discussion.Discussion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class DiscussionMapper {

    public static DiscussionDto toDiscussionDto(Discussion discussion){
        return new DiscussionDto()
                .setTitle(discussion.getTitle())
                .setCategory(discussion.getCategory())
                .setNickName(discussion.getNickName())
                .setQuestion(discussion.getQuestion())
                .setAnswers(new HashSet<AnswerDto>(discussion
                        .getAnswers()
                        .stream()
                        .map(role -> new ModelMapper().map(role, AnswerDto.class))
                        .collect(Collectors.toSet())));
    }
}
