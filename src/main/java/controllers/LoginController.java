package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import helpers.ViewRouterHelper;
import models.UsuarioModel;
import services.implementations.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ModelAndView index(Authentication auth, HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView(ViewRouterHelper.HOME);
        return mv;
	}
}
