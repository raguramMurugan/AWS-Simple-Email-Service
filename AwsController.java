package com.hubino.aws.SimpleEmailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.aws.SimpleEmailService.service.AwsService;



@RestController
public class AwsController {

	@Autowired
	private AwsService awsService;
	
	@PostMapping("/sendMail")
	public String sendMessage(@RequestParam String fromEmail,@RequestParam String toEmail,@RequestParam String subject,@RequestParam String body) 
	{
		SimpleMailMessage simplemail=new SimpleMailMessage();
		simplemail.setFrom(fromEmail);
		simplemail.setTo(toEmail);
		simplemail.setSubject(subject);
		simplemail.setText(body);
		awsService.sendMessage(simplemail);
		
		return "Mail Sent Successfully";
	}
	
	
	
	
}
