package com.travel.server.controller.view;

import com.travel.server.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private IMailService mailService;

    @GetMapping("/")
    public String index(Model model){
//        mailService.sendMail();
        return "index";
    }

}
