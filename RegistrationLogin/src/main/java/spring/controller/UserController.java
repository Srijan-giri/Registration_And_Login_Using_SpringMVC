package spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import spring.dao.UserDao;
import spring.model.UserRegistration;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(path="/home",method=RequestMethod.GET)
	public String home(Model m)
	{
		m.addAttribute("title","Registration Form");
		return "home";
	}
	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String viewLogin(Model m)
	{
		m.addAttribute("title","Login Form");
		return "login";
	}
	@RequestMapping(path="/processRegistration",method=RequestMethod.POST)
	public RedirectView processForm(@ModelAttribute("user") UserRegistration user,Model m , HttpServletRequest request)
	{
		System.out.println(user);
		RedirectView redirect = new RedirectView();
		this.userDao.createUser(user);
		redirect.setUrl(request.getContextPath()+"/login");
		return redirect;
	}
	
	@RequestMapping(path="/login-handle",method=RequestMethod.POST)
	public RedirectView processLogin(@RequestParam("email") String email,
			                         @RequestParam("password")String password,
			                         Model m,HttpServletRequest request
			)
	{
		System.out.println(email+":"+password);
		boolean found = this.userDao.loginUser(email, password);
		System.out.println(found);
		RedirectView redirect = new RedirectView();
		if(found==true)
		{
			System.out.println("Successfully Login");
			redirect.setUrl(request.getContextPath()+"/main");
		}
		else
		{
			System.out.println("Successfully Not Login");
			redirect.setUrl(request.getContextPath()+"/home");
		}
		return redirect;
	}
	
	
	@RequestMapping(path="/main",method=RequestMethod.GET)
	public String mainpage(Model m)
	{
		return "main";
	}
	
}
