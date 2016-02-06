package com.cater.utils;

import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	protected Logger logger = LoggerFactory.getLogger(MailUtil.class);

	@Value("${mail.smtp.hostname}")
	private String	hostName;
	@Value("${mail.smtp.username}")
	private String	userName;
	@Value("${mail.smtp.port}")
	private String	port;
	@Value("${mail.smtp.password}")
	private String	password;
	@Value("${mail.cater.message.activate}")
	private String	act_msg;
	@Value("${mail.cater.message.otp}")
	private String	otp_msg;

	/**
	 * Construct mail sender depending on deployment environment
	 * 
	 * @return
	 */
	private JavaMailSenderImpl constructMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(hostName);
		mailSender.setPort(Integer.parseInt(port));
		mailSender.setUsername(userName);
		mailSender.setPassword(password);
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(props);

		logger.info(mailSender.getHost() + " - " + mailSender.getUsername() + " - " + mailSender.getPort() + " - ");
		return mailSender;
	}

	/**
	 * Send email with report attachment
	 * 
	 * @param email
	 * @param name
	 * @param bytes
	 * @param fileName
	 * @return
	 */
	public boolean sendActivationEmail(String email, String name) {
		try {
			JavaMailSenderImpl mailSender = constructMailSender();
			MimeMessage message = mailSender.createMimeMessage();
			logger.info(hostName + " - " + userName + " - " + port + " - " + port);
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setTo(email == null ? "armaankohli91@gmail.com" : email);
			helper.setBcc("armaankohli91@gmail.com");
			helper.setText(MessageFormat.format(act_msg, name), true);
			helper.setFrom(mailSender.getUsername());
			helper.setSubject("Welcome - " + name);
			mailSender.send(message);
			return true;
		} catch (Exception ex) {
			logger.error(null, ex);
			return false;
		}
	}

	public boolean sendOTPEmail(String name, String otp,String userName, String... email) {
		try {
			JavaMailSenderImpl mailSender = constructMailSender();
			MimeMessage message = mailSender.createMimeMessage();
			logger.info(hostName + " - " + userName + " - " + port + " - " + port);
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			for (String to : email)
				helper.addTo(to);
			helper.setBcc("armaankohli91@gmail.com");
			helper.setText(MessageFormat.format(otp_msg, name, otp,userName), true);
			helper.setFrom(mailSender.getUsername());
			helper.setSubject("Welcome - " + name);
			mailSender.send(message);
			return true;
		} catch (Exception ex) {
			logger.error(null, ex);
			return false;
		}
	}

}
