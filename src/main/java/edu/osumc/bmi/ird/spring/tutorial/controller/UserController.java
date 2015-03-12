package edu.osumc.bmi.ird.spring.tutorial.controller;

import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;
import edu.osumc.bmi.ird.spring.tutorial.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by swang on 3/4/2015.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * rest web service
     *
     * @return
     */
    @RequestMapping(value = "json", method = RequestMethod.GET, produces = MediaType
            .APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> findAll() {
        return userService.getAll();
    }

    /**
     * return ModelAndView with users
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        logger.debug("display user list");
        ModelAndView mv = new ModelAndView("userList");
        mv.addObject("usersModel", userService.getAll());
        return mv;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType
            .APPLICATION_JSON_VALUE)
    @ResponseBody
    public User findUser(@PathVariable("id") int id) {
        return userService.get(new Long(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType
            .APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.create(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType
            .APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User savedUser = userService.update(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType
            .APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        userService.delete(new Long(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
