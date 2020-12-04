package com.neusoft.springbootsell.controller;

import com.google.gson.Gson;
import com.neusoft.springbootsell.dataobject.UserInfo;
import com.neusoft.springbootsell.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Gson gson = new Gson();
    @Autowired
    private UserInfoService userInfoService;
//    @GetMapping("/sell/")
//    public boolean login(@RequestParam("username") String username,
//                         @RequestParam("password") String password){
//        return userInfoService.userInfo(username,password);
//    }

    @RequestMapping("/judge")
    @ResponseBody
    public String loginJudge(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserInfo userInfo = null;
        if (username != null && password != null) {
            userInfo = userInfoService.findByUsernameAndPassword(username, password);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        if (userInfo != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userInfo",userInfo);
            map.put("userRole", userInfo.getUserStatus());
            map.put("result", true);
        }else {
            map.put("result", false);
        }
        return gson.toJson(map);
    }

    @GetMapping("/")
    public ModelAndView login(){
        return new ModelAndView("/common/login");
    }

}
