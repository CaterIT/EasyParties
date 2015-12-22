package com.cater.controllers;
/**
 * @author armaank
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cater.services.UserService;
import com.cater.tos.beans.User;
import com.cater.utils.MailUtil;

@Controller
public class MainController {

	@Autowired
	UserService userservice;
	@Autowired
	MailUtil mailUtil;

	protected Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// opens up demo.jsp
	@RequestMapping(value = "/template/demo", method = RequestMethod.GET)
	public ModelAndView demo(@RequestParam("name") String name) {
		ModelAndView model = new ModelAndView();
		User u=userservice.getUser();
		u.setFirstName(name);
		model.setViewName("Demo");
		model.addObject("user", u);
		logger.info("Logger working..");
		return model;
	}

	// opens CatererRegistration page
	@RequestMapping(value = "/template/CatererRegistration", method = RequestMethod.GET)
	public String hello() {
		try{
		userservice.saveUser();
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
		}
		return "CatererRegistration";
	}
	// opens google search page
	@RequestMapping(value = "/template/GoogleSearch", method = RequestMethod.GET)
	public String gSearch() {
		return "sqlSearch";
	}
	@RequestMapping(value = "/GoogleQuerySearch", method = RequestMethod.GET)
	public @ResponseBody String querySearch() {
		try {
			return userservice.getCaterer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "sqlSearch";
		}
	}

	// check mail
	@RequestMapping(value = "/template/mail", method = RequestMethod.GET)
	public String checkMail() {
		mailUtil.sendEmail("armaankohli91@gmail.com", "Armaan");
		return "CatererRegistration";
	}
}
