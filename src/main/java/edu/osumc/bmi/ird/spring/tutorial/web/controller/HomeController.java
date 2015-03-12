package edu.osumc.bmi.ird.spring.tutorial.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by swang on 3/11/2015.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("welcome");
        return mv;
    }
}
