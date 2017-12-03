package org.hareram.springboot.messaging_module.controller;

import org.hareram.springboot.messaging_module.bean.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class InvoiceMessagingService {

	@Autowired
	JmsTemplate template;

	public void sendEmail(Email email) {
		template.convertAndSend("mailbox", email);
	}
}
