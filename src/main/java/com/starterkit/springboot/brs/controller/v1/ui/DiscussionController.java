package com.starterkit.springboot.brs.controller.v1.ui;

import com.starterkit.springboot.brs.controller.v1.command.AdminSignupFormCommand;
import com.starterkit.springboot.brs.controller.v1.command.AnswerFormCommand;
import com.starterkit.springboot.brs.controller.v1.command.DiscussionFormCommand;
import com.starterkit.springboot.brs.dto.model.discussion.AnswerDto;
import com.starterkit.springboot.brs.dto.model.discussion.DiscussionDto;
import com.starterkit.springboot.brs.dto.model.user.UserDto;
import com.starterkit.springboot.brs.service.AnswerService;
import com.starterkit.springboot.brs.service.DiscussionService;
import com.starterkit.springboot.brs.service.UserService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DiscussionController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussionService discussionService;

    @Autowired
    private AnswerService answerService;

    @GetMapping(value="/create_discussion")
    public ModelAndView discussion(){
        ModelAndView modelAndView=new ModelAndView("create_discussion");
        modelAndView.addObject("discussionFormData", new DiscussionFormCommand());

        return modelAndView;
    }

    @PostMapping(value = "/create_discussion")
    public ModelAndView createNewQuestion(@Valid @ModelAttribute("discussionFormData") DiscussionFormCommand discussionFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("create_discussion");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            try {
                DiscussionDto newDiscussion = create_discussion(discussionFormCommand);
            } catch (Exception exception) {
                bindingResult.rejectValue("email", "error.discussionFormCommand", exception.getMessage());
                return modelAndView;
            }
        }
        return new ModelAndView("dashboard");
    }

    @PostMapping(value = "/create_answer")
    public ModelAndView createNewAnswer(@Valid @ModelAttribute("answerFormData") AnswerFormCommand answerFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("create_discussion");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            try {
                AnswerDto newAnswer = create_answer(answerFormCommand);
            } catch (Exception exception) {
                bindingResult.rejectValue("email", "error.discussionFormCommand", exception.getMessage());
                return modelAndView;
            }
        }
        return new ModelAndView("dashboard");
    }

    @GetMapping(value="/discussion/{id}")
    public ModelAndView discussionInfo(@PathVariable String id, Model model){
        ModelAndView modelAndView=new ModelAndView("discussion");
        modelAndView.addObject("discussion", discussionService.getDiscussionById(id));

        return modelAndView;
    }




    private DiscussionDto create_discussion(@Valid DiscussionFormCommand discussionFormRequest) {
        DiscussionDto discussionDto = new DiscussionDto()
                .setNickName(discussionFormRequest.getNickName())
                .setTitle(discussionFormRequest.getTitle())
                .setCategory(discussionFormRequest.getCategory())
                .setQuestion(discussionFormRequest.getQuestion());
        DiscussionDto discussion = discussionService.create(discussionDto); //register the admin
        return discussion;
    }

    private AnswerDto create_answer(@Valid AnswerFormCommand answerFormRequest) {
        AnswerDto answerDto = new AnswerDto()
                .setQuestion_id(answerFormRequest.getQuestion_id())
                .setAnswer(answerFormRequest.getAnswer());
        AnswerDto answer = answerService.create(answerDto); //register the admin
        return answer;
    }

}
