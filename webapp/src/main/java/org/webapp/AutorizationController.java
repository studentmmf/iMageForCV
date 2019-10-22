package org.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.models.BaseDAOImpl;
import org.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="")

@SessionAttributes(value = "userAuth")
public class AutorizationController extends HttpServlet {

	@ModelAttribute("userAuth")
	public User createUser() {
	        return new User();
	}
	
	/*@RequestMapping(value="showAuth", method = RequestMethod.GET)
	public String showAuth(Model m) {
		User user = new User();
		m.addAttribute("userJSP", user);
		return "index";		
	}
	
    @RequestMapping(value = "login", method =  RequestMethod.GET)   
    public ModelAndView login(ModelMap m, @ModelAttribute(value="userJSP") User user, @ModelAttribute(value="userAuth") User userAuth) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index");   
    	
    	BaseDAOImpl base = new BaseDAOImpl();
    	if(base.userExists(user.getLogin()) && user.getPassword().equals(base.findPasswordByLogin(user.getLogin()))) {
    		m.addAttribute("message", "Вы успешно авторизовались");
    		userAuth = user;
    		m.addAttribute("userAuth", userAuth);
    	}
    	
    	else if(!base.userExists(user.getLogin())) {
    		m.addAttribute("message", "Пользователь с данным логином не существует");
    		
    	}
    	
    	else if(base.userExists(user.getLogin()) && !user.getPassword().equals(base.findPasswordByLogin(user.getLogin()))) {
    		m.addAttribute("message", "Вы ввели неверный пароль");
    	}
        return modelAndView;
    }*/
	
	 @RequestMapping(value = "login", method =  RequestMethod.GET)   
	    public ModelAndView login(ModelMap m, HttpServletRequest request, @ModelAttribute(value="userAuth") User userAuth) {
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("index");   
	    	User user = new User();
	    	user.setLogin(request.getParameter("login"));
	    	user.setPassword(request.getParameter("password"));
	    	//String login = user.getLogin();
	    	//String password = user.getPassword();
	    	//System.out.println(login + " " + password);
	    	BaseDAOImpl base = new BaseDAOImpl();
	    	if(base.userExists(user.getLogin()) && user.getPassword().equals(base.findPasswordByLogin(user.getLogin()))) {
	    	//if(base.userExists(login) && password.equals(base.findPasswordByLogin(login))) {
	    		m.addAttribute("message", "Вы успешно авторизовались");
	    		userAuth = user;
	    		m.addAttribute("userAuth", userAuth);
	    	}
	    	
	    	else if(!base.userExists(user.getLogin())) {
	    		m.addAttribute("message", "Пользователь с данным логином не существует");
	    		
	    	}
	    	
	    	else if(base.userExists(user.getLogin()) && !user.getPassword().equals(base.findPasswordByLogin(user.getLogin()))) {
	    		m.addAttribute("message", "Вы ввели неверный пароль");
	    	}
	        return modelAndView;
	    }
    
    @RequestMapping(value="showReg")
	public String showReg(Model m) {
		User user = new User();
		m.addAttribute("userReg", user);
		return "reg";		
	}

    @RequestMapping(value="registration", method =  RequestMethod.GET)
    public ModelAndView registration(ModelMap m, @ModelAttribute(value="userReg") User user, @ModelAttribute(value="userAuth") User userAuth) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("reg");
    	BaseDAOImpl base = new BaseDAOImpl();
    	if(base.userExists(user.getLogin())) {
    		m.addAttribute("message", "Пользователь с данным логином уже существует");
    	}
    	else if(user.getLogin() != "" && user.getPassword() != ""){
    		base.save(user);
    		m.addAttribute("message", "Вы успешно зарегистрировались");
    		userAuth = user;
    		m.addAttribute("userAuth", userAuth);
    	}
    	else {
    		m.addAttribute("message", "Вы не ввели логин или пароль");
    	}
        return modelAndView;
    }

    @RequestMapping("forget")
    public String forgetPassword(ModelMap m) {
        return "index";
    }
    
    @RequestMapping("mainProc")
    public String mainProc(ModelMap m, @ModelAttribute(value="userAuth") User userAuth) {
    	if(userAuth.getLogin() == null || userAuth.getLogin() == "") {
    		m.addAttribute("message", "Вы вошли как не зарегистрированный пользователь");
    	}
    	else {
    		m.addAttribute("message", "Здравствуйте " + userAuth.getLogin() + "!");
    	}
    	
    	return "main";
    }
    
    
}
