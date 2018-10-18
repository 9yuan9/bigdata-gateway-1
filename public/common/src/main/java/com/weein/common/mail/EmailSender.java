package com.weein.common.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Component
public class EmailSender {

//	@Resource
	private JavaMailSenderImpl mailSender;
	
	public void sendMail( String[] to,
			String subject, String content) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailSender.getUsername());// 接收者.
		message.setTo(to);// 接收者.
		message.setSubject(subject);// 邮件主题.
		message.setText(content);// 邮件内容.
		// 发送
		mailSender.send(message);
	}
}
