package org.hareram.springboot.messaging_module;

import org.hareram.springboot.messaging_module.bean.Email;
import org.hareram.springboot.messaging_module.jms.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

	@Autowired
	private MailService mailService;
	
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void recieveMessage(Email email) {
		System.out.println("Recieved < " + email + ">");
		
        mailService.sendEmail(email);
	}
}
