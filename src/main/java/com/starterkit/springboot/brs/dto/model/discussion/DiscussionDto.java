package com.starterkit.springboot.brs.dto.model.discussion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.starterkit.springboot.brs.dto.model.user.RoleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscussionDto {
    private String id;
    private String nickName;
    private String title;
    private String category;
    private String question;
    private Set<AnswerDto> answers;
}
