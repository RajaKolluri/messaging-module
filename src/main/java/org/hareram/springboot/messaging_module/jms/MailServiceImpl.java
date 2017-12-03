package org.hareram.springboot.messaging_module.jms;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
//import org.springframework.mail.SimpleMailMessage;
import javax.mail.internet.MimeMessage;

import org.hareram.springboot.messaging_module.bean.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
@Configuration
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSenderImpl;
	
	public void sendEmail(Email email) {
		MimeMessage message = mailSenderImpl.createMimeMessage();

		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			
			helper.setTo(email.getTo());
			helper.setSubject("Test Message");
			//"text/html; charset=utf-8"
			helper.setText(email.getBody());
			
			/*FileSystemResource file = new FileSystemResource(
					new File("H:/temp/HDL-LDL.pdf"));
			helper.addAttachment("Sugar", file);*/
			mailSenderImpl.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("raja.rao.kolluri@gmail.com");
		mailSender.setPassword("mi$$uteju");
		
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		return mailSender;
	}

}
