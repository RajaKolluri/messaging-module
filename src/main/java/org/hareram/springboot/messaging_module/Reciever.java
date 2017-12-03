package org.hareram.springboot.messaging_module;

import org.hareram.springboot.messaging_module.bean.Email;
//import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

	//@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void recieveMessage(Email email) {
		System.out.println("Recieved < " + email + ">");
	}
}
