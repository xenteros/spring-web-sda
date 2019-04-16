package com.github.xenteros.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
class UserController {

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }

//    @GetMapping("/login")
//    public RedirectView redirectLogin() {
//        return new RedirectView("/login.html");
//    }
}
