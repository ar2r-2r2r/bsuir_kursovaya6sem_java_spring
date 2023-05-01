package com.starterkit.springboot.brs.repository.discussion;

import com.starterkit.springboot.brs.model.discussion.Answer;
import com.starterkit.springboot.brs.model.discussion.Discussion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, String>  {
}
