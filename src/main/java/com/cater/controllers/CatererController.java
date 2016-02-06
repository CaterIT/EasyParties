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

	protected Logger logger = LoggerFactory.getLogger(CatererController.class);
	

	@RequestMapping(value = "/caterer/ValidateOTP", method = RequestMethod.GET)
	public ModelAndView validateOTP(@RequestParam String userName) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("ValidateOTP");
		modelAndView.addObject("userName", userName);
		return modelAndView;
	}
	/**
	 * Validate otp entered by the user
	 * @param email
	 * @param otp
	 * @return
	 */
	@RequestMapping(value = "/caterer/CaterOTP", method = RequestMethod.POST)
	public boolean catererOTPValidation(@RequestParam String userName,@RequestParam String otp) {
		logger.info("Validating otp for username - "+userName);
		if(userName!=null){
			Caterer caterer=catererService.getCatererByUsernameAndOTP(userName, otp);
			if(caterer!=null){
				caterer.setIsDeleted(false);
				catererService.saveCaterer(caterer);
				return true;
			}
		}
		return false;
	}
	/**
	 * Validate otp entered by the user
	 * @param email
	 * @param otp
	 * @return
	 */
	@RequestMapping(value = "/caterer/CatererAddressAdd", method = RequestMethod.POST)
	public boolean addAddress(@RequestParam CatererAddress address,@RequestParam Caterer c) {
		logger.info("Validating otp");
		if(c!=null){
			//Caterer c=catererService.getCatererByUserNameNOTP(userName,otp);
			if(c!=null){
				c.setIsDeleted(false);
				//catererService.saveCaterer(c, otp);
				return true;
			}
		}
		return false;
	}
}
