package com.starterkit.springboot.brs.service;

import com.starterkit.springboot.brs.dto.model.discussion.DiscussionDto;
import com.starterkit.springboot.brs.model.discussion.Answer;
import com.starterkit.springboot.brs.model.discussion.Discussion;

import java.util.List;

public interface DiscussionService {

    /**
     * Create a new discussion
     *
     * @param discussionDto
     * @return
     */
    DiscussionDto create(DiscussionDto discussionDto);

    List<Discussion> getAllDiscussions();

    DiscussionDto getDiscussionById(String id);

    List<Answer> getAnswersByQuestionId(String id);
}
