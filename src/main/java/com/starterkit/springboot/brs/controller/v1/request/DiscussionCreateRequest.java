package com.starterkit.springboot.brs.controller.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscussionCreateRequest {
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String nickName;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String title;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String category;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String question;
}
