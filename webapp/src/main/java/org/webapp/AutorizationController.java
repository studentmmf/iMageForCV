package org.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutorizationController {


    @RequestMapping("login")
    public String login(ModelMap m ) {
        return "index";
    }

    @RequestMapping("registration")
    public String registration(ModelMap m) {
        return "index";
    }

    @RequestMapping("forget")
    public String forgetPassword(ModelMap m) {
        return "index";
    }
}
