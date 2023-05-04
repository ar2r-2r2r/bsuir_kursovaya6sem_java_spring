package com.starterkit.springboot.brs.repository.discussion;

import com.starterkit.springboot.brs.model.discussion.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnswerRepository extends MongoRepository<Answer, String>  {
    List<Answer> findAnswersByQid(String qid);
}
