package org.webapp;

import org.models.BaseDAOImpl;
import org.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@SessionAttributes(value = "userJSP")
public class AutorizationController {


    @RequestMapping(value = "login", method =  RequestMethod.GET)   
    public ModelAndView login(ModelMap m, @ModelAttribute(value="userJSP") User user ) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index");   	
    	BaseDAOImpl base = new BaseDAOImpl();
    	if(base.userExists(user.getLogin()) && user.getPassword().equals(base.findPasswordByLogin(user.getLogin()))) {
    		m.addAttribute("message", "Вы успешно авторизовались");
    	}
    	
    	else if(!base.userExists(user.getLogin())) {
    		m.addAttribute("message", "Пользователь с данным логином не существует");
    		m.addAttribute("debug", user.toString());
    	}
    	
    	else if(base.userExists(user.getLogin()) && !user.getPassword().equals(base.findPasswordByLogin(user.getLogin()))) {
    		m.addAttribute("message", "Вы ввели неверный пароль");
    	}
        return modelAndView;
    }

    @RequestMapping(value="registration", method =  RequestMethod.GET)
    public ModelAndView registration(ModelMap m, @ModelAttribute(value="userJSP") User user) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("reg");
    	BaseDAOImpl base = new BaseDAOImpl();
    	if(base.userExists(user.getLogin())) {
    		m.addAttribute("message", "Пользователь с данным логином уже существует");
    	}
    	else {
    		base.save(user);
    		m.addAttribute("message", "Вы успешно зарегистрировались");
    	}
        return modelAndView;
    }

    @RequestMapping("forget")
    public String forgetPassword(ModelMap m) {
        return "index";
    }
}
