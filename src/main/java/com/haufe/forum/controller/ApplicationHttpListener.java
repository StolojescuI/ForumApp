package com.haufe.forum.controller;
import com.haufe.forum.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.haufe.forum.model.Forum;
import com.haufe.forum.model.Thread;
import com.haufe.forum.repository.ForumRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class ApplicationHttpListener {

    @Autowired
    private ForumRepository forumRepository;

    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/forums";
    }

    @RequestMapping(path="/forums", method = RequestMethod.GET)
    public String forums(Model model) {
        model.addAttribute("forums", forumRepository.findAll());
        return "index";
    }

    @RequestMapping("/forums/{id}")
    public String forum(Model model, @PathVariable("id") String forumId) {
        Forum forum = forumRepository.findForumById(forumId);
        model.addAttribute("forum", forum);
        model.addAttribute("newThread", new Thread());
        return "forumTemplate";
    }

    @RequestMapping(path = "/forums/{id}/threads", method = RequestMethod.POST)
    public String createThread(Thread thread, @PathVariable("id") String forumId, Model model){
        //TODO find away to get the logged in user
        thread.setId(ObjectId.get().toHexString());
        thread.setAuthor(new User("bogususer@until.realuser.retrieved"));
        Forum forum = forumRepository.findForumById(forumId);
        forum.getThreads().add(thread);
        forumRepository.save(forum);
        model.addAttribute("forum", forum);
        model.addAttribute("newThread", new Thread());
        return "redirect:/forums/" + forumId;
    }
}
