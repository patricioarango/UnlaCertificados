package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import helpers.ViewRouterHelper;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@GetMapping("/")
	public ModelAndView index(Authentication auth, HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView(ViewRouterHelper.HOME);
        return mv;
	}
	@GetMapping("/home")
	public ModelAndView home(Authentication auth, HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView(ViewRouterHelper.HOME);
        return mv;
	}
	
}
