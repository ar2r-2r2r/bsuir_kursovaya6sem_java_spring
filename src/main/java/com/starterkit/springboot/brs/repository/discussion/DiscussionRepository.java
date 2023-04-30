package com.starterkit.springboot.brs.repository.discussion;

import com.starterkit.springboot.brs.model.discussion.Discussion;
import com.starterkit.springboot.brs.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscussionRepository extends MongoRepository<Discussion, String> {

}
