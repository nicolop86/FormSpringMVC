package it.ariadne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.ariadne.model.User;
import it.ariadne.model.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {


	private UserRepository userRepo;
	
	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	/*Model is to tell that once the form is filled in and the request forwarded,
	 * the system has to come here to this method.*/
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String performRegistration (User user) {
		userRepo.saveUser(user);
		return "redirect:/user/" + user.getUsername();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistration (Model model) {
		model.addAttribute(new User());
		return "registerForm";
	}
	
	@RequestMapping(value ="/{username}", method = RequestMethod.GET)
	public String showUserProfile (@PathVariable String username, Model model) {
		User user = userRepo.findByUsername(username);
		model.addAttribute(user);
		return "profile";
	}
}
