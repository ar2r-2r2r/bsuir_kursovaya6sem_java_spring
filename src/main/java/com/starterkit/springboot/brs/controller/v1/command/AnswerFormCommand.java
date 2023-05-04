package com.starterkit.springboot.brs.controller.v1.command;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class AnswerFormCommand {
    @NotBlank
    private String qid;

    @NotBlank
    @Size(min = 2)
    private String answer;
}
