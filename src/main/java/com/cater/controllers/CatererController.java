package com.cater.controllers;
/**
 * @author armaank
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.cater.tos.beans.AddressDetails;
import com.cater.tos.beans.Caterer;
import com.cater.tos.beans.CatererAddress;
import com.cater.tos.beans.CatererLineContact;
import com.cater.tos.beans.User;
import com.cater.services.CatererService;
import com.cater.services.UserService;
import com.cater.utils.GeneralUtils;
import com.cater.utils.MailUtil;

/**
 * @author armaank
 *
 */
@Controller
public class CatererController {

	@Autowired
	UserService userservice;
	@Autowired
	CatererService catererService;
	@Autowired
	MailUtil mailUtil;

	@Autowired
	HttpSession httpSession;

	protected Logger logger = LoggerFactory.getLogger(CatererController.class);
	

	@RequestMapping(value = "/caterer/ValidateOTP", method = RequestMethod.GET)
	public ModelAndView validateOTP(@RequestParam String userName) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("caterer/ValidateOTP");
		modelAndView.addObject("userName", userName);
		return modelAndView;
	}
	/**
	 * Validate otp entered by the user
	 * @param email
	 * @param otp
	 * @return
	 */
	@RequestMapping(value = "/caterer/CaterOTP", method = RequestMethod.GET)
	public @ResponseBody String catererOTPValidation(@RequestParam String userName,@RequestParam String otp) {
		logger.info("Validating otp for username - "+userName);
		if(userName!=null){
			Caterer caterer=catererService.getCatererByUsernameAndOTP(userName, otp);
			if(caterer!=null){
				caterer.setIsDeleted(false);
				catererService.saveCaterer(caterer);
				return "true";
			}
		}
		return "false";
	}
	/**
	 * @return
	 */
	@RequestMapping(value = "/caterer/AddCatererAddress", method = RequestMethod.GET)
	public ModelAndView AddCatererAddress() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("caterer/AddCatererAddress");
		CatererAddress addressDetails=new CatererAddress();
		modelAndView.addObject("catererAddress", addressDetails);
		modelAndView.addObject("caterer",(Caterer) httpSession.getAttribute("caterer"));
		return modelAndView;
	}

	/**
	 * Add address
	 * @param email
	 * @param otp
	 * @return
	 */
	@RequestMapping(value = "/caterer/CatererAddressAdd", method = RequestMethod.POST)
	public @ResponseBody String addAddress(@ModelAttribute("catererAddress") CatererAddress catererAddress) {
		logger.info("Adding address");
		catererAddress.setCaterer((Caterer) httpSession.getAttribute("caterer"));
		catererService.addCatererAddress(catererAddress);
		return "true";
	}

	/**
	 * Login page
	 */
	@RequestMapping(value = "/caterer/CatererLogin", method = RequestMethod.GET)
	public ModelAndView login() {
		Caterer caterer=new Caterer();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("caterer", caterer);
		modelAndView.setViewName("caterer/Login");
		return modelAndView;
	}
	/**
	 * Login action
	 */
	@RequestMapping(value = "/caterer/Login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("caterer")Caterer caterer) {
		logger.info("logging in");
		ModelAndView modelAndView=new ModelAndView();
		if(caterer!=null){
			caterer=catererService.getCatererByUsernameAndPassword(caterer);
			if(caterer!=null){
				httpSession.setAttribute("caterer", caterer);
				modelAndView.setViewName("caterer/Profile");
			}else{
				modelAndView.setViewName("forward:/caterer/CatererLogin");
			}
		}
		modelAndView.addObject("caterer", caterer);
		return modelAndView;
	}

	/**
	 * Logout action
	 */
	@RequestMapping(value = "/caterer/Logout", method = RequestMethod.GET)
	public String logout() {
		logger.info("logging in");
		httpSession.invalidate();
		return "forward:/caterer/CatererLogin";
	}
	/**
	 * Profile page
	 */
	@RequestMapping(value = "/caterer/Profile", method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView modelAndView=new ModelAndView();
		if(httpSession.getAttribute("Caterer")!=null){
			modelAndView.addObject("caterer", httpSession.getAttribute("Caterer"));		
			modelAndView.setViewName("caterer/Profile");	
		}else{
			modelAndView.setViewName("forward:/caterer/CatererLogin");	
		}
		return modelAndView;
	}

}
