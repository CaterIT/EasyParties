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
import org.springframework.web.servlet.ModelAndView;

import com.cater.services.UserService;
import com.cater.tos.beans.User;

@Controller
public class MainController {
	
	@Autowired
	UserService userservice;

	protected Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// opens up demo.jsp
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
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
	@RequestMapping(value = "/CatererRegistration", method = RequestMethod.GET)
	public String hello() {

		return "CatererRegistration";
	}

}
