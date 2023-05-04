package com.starterkit.springboot.brs.model.discussion;

import com.starterkit.springboot.brs.model.user.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

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

//    @DBRef
//    private Set<Answer> answers;
}
