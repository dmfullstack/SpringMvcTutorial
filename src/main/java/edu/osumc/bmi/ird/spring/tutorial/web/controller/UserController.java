package edu.osumc.bmi.ird.spring.tutorial.web.controller;

import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;
import edu.osumc.bmi.ird.spring.tutorial.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by swang on 3/4/2015.
 */
@Controller
@Scope("request")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        logger.debug("redirect to home page");
        return new ModelAndView("home");
    }

    /**
     * rest web service
     *
     * @return
     */
    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    @ResponseBody
    public List<User> usersList() {
        logger.debug("get json user list");
        return userService.getAll();
    }

    /**
     * return ModelAndView with users
     *
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        logger.debug("display user list");
        ModelAndView mv = new ModelAndView("usersView");
        mv.addObject("usersModel", userService.getAll());
        return mv;
    }
}
