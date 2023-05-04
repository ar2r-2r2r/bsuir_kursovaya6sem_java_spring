package com.starterkit.springboot.brs.service;

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

import java.util.List;
import java.util.Optional;

import static com.starterkit.springboot.brs.exception.ExceptionType.ENTITY_NOT_FOUND;

@Component
public class DiscussionServiceImpl implements DiscussionService{

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DiscussionDto create(DiscussionDto discussionDto) {
        Discussion discussion=new Discussion()
                .setTitle(discussionDto.getTitle())
                .setCategory(discussionDto.getCategory())
                .setNickName(discussionDto.getNickName())
                .setQuestion(discussionDto.getQuestion());
        return DiscussionMapper.toDiscussionDto(discussionRepository.save(discussion));
    }

    @Override
    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }


    @Override
    public DiscussionDto getDiscussionById(String id) {
        Optional<Discussion> discussion = discussionRepository.findById(id);
        if (discussion.isPresent()) {
            return DiscussionMapper.toDiscussionDto(discussion.get());
        }
        return null;
    }

    @Override
    public List<Answer> getAnswersByQuestionId(String id){
         List<Answer> answer = answerRepository.findAnswersByQid(id);
        return answer;


    }
}
