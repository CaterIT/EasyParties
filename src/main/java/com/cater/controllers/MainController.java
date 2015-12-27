package com.cater.controllers;
/**
 * @author armaank
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cater.tos.beans.Caterer;
import com.cater.tos.beans.CatererLineContact;
import com.cater.tos.beans.User;
import com.cater.services.CatererService;
import com.cater.services.UserService;
import com.cater.utils.GeneralUtils;
import com.cater.utils.MailUtil;

@Controller
public class MainController {

	@Autowired
	UserService userservice;
	@Autowired
	CatererService catererService;
	@Autowired
	MailUtil mailUtil;

	protected Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// opens up demo.jsp
//	@RequestMapping(value = "/template/demo", method = RequestMethod.GET)
//	public ModelAndView demo(@RequestParam("name") String name) {
//		ModelAndView model = new ModelAndView();
//		User u=userservice.getUser();
//		u.setFirstName(name);
//		model.setViewName("Demo");
//		model.addObject("user", u);
//		logger.info("Logger working..");
//		return model;
//	}

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
//		mailUtil.sendEmail("armaankohli91@gmail.com", "Armaan");
		return "CatererRegistration";
	}
	
	//Main flows

	@RequestMapping(value = "/caterer/Register", method = RequestMethod.GET)
	public ModelAndView newCatererRegistration() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("caterer/Registration");
		modelAndView.addObject("caterer", new Caterer());
		return modelAndView;
	}
	@RequestMapping(value = "/caterer/RegisterAndSaveCaterer", method = RequestMethod.POST)
	public String saveCatererDetailsAndRegister(@ModelAttribute("caterer")Caterer caterer) {
		logger.info("hello");
		if(caterer!=null){
			String otp=GeneralUtils.createOTP();
			logger.info(otp);
			List<String> emails=new ArrayList<String>();
			for(CatererLineContact contact:caterer.getCatererLineContacts()){
				if(contact.getType().equals("E")){
					emails.add(contact.getContact());
				}
			}
			catererService.saveCaterer(caterer,otp);
			mailUtil.sendOTPEmail(caterer.getName(),otp,emails.toArray(new String[0]));
		}
		return "CatererRegistration";
	}
}
