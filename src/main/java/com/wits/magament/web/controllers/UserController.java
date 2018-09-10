package com.wits.magament.web.controllers;

import com.wits.magament.web.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @GetMapping (value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }
    @GetMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("user",new UserDTO());

            return mav;
        }
        @PostMapping(value = "/login-process")
    public ModelAndView loginProcess(UserDTO user, HttpSession session){
        System.out.println(user);
        session.setAttribute("user", user);
        ModelAndView mav =new ModelAndView();
        mav.setViewName("redirect:/");

         return mav;
        }
    }
