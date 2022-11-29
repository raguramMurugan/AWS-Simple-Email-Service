package com.hubino.aws.SimpleEmailService.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.mail.simplemail.SimpleEmailServiceMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AwsConfig {
	
	@Value("${cloud.aws.accesskey}")
	private String accessKey;
	@Value("${cloud.aws.secretkey}")
	private String secretKey;
	@Value("${cloud.aws.region}")
	private String region;
	
	@Bean
	public MailSender mailSender(AmazonSimpleEmailService emailService)
	{
		return new SimpleEmailServiceMailSender(emailService);
	}
	
	@Bean
	public AmazonSimpleEmailService emailService()
	{
		BasicAWSCredentials credentials =new BasicAWSCredentials(accessKey, secretKey);
		
		return AmazonSimpleEmailServiceClientBuilder
				.standard()
				.withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
				
	}

}
