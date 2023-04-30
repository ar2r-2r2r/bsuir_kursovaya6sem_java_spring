package com.starterkit.springboot.brs.dto.mapper;

import com.starterkit.springboot.brs.dto.model.discussion.DiscussionDto;
import com.starterkit.springboot.brs.model.discussion.Discussion;
import org.springframework.stereotype.Component;

@Component
public class DiscussionMapper {

    public static DiscussionDto toDiscussionDto(Discussion discussion){
        return new DiscussionDto()
                .setTitle(discussion.getTitle())
                .setCategory(discussion.getCategory())
                .setNickName(discussion.getNickName())
                .setQuestion(discussion.getQuestion());
    }
}
