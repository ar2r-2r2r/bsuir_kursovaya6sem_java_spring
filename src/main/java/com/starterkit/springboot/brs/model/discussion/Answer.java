package com.starterkit.springboot.brs.model.discussion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "answer")
public class Answer {
    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String answer;

    private String question_id;
}
