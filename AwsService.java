package com.hubino.aws.SimpleEmailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class AwsService {
	
	@Autowired
	private MailSender mailsender;

	public void sendMessage(SimpleMailMessage mailmessage)
	{
		this.mailsender.send(mailmessage);
	}

}
