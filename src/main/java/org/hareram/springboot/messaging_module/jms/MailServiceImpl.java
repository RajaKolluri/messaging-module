package org.hareram.springboot.messaging_module.jms;

import org.hareram.springboot.messaging_module.bean.Email;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

	JavaMailSender mailSender;
	
	public void sendEmail(Email email) {
		// TODO Auto-generated method stub
		
	}

}
