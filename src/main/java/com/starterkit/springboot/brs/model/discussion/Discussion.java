package com.starterkit.springboot.brs.model.discussion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "discussion")
public class Discussion {
    @Id
    private String id;
    private String nickName;
    private String title;
    private String category;
    private String question;
}
