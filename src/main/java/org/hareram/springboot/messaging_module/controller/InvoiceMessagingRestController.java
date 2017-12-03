package org.hareram.springboot.messaging_module.controller;

import org.hareram.springboot.messaging_module.bean.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendEmail")
public class InvoiceMessagingRestController {
	
	@Autowired
	InvoiceMessagingService invoiceMsgService;

	@RequestMapping(value="/{to}/{text}")
	public void sendInvoiceOverEmail(@PathVariable String to, @PathVariable String text) {
		System.out.println("To: " + to + "Body: " + text);
		
		String newline = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer()
        			.append("Hello Raja!")
        			.append(newline)
        			.append("this is sample Email!")
        			.append(newline)
        			.append("Thanks Raja");
        
        Email email = new Email();
        email.setTo(to);
        email.setBody(text);
        
        invoiceMsgService.sendEmail(email);
	}
	
}
