package org.hareram.springboot.messaging_module.jms;

import org.hareram.springboot.messaging_module.bean.Email;

public interface MailService {

	public void sendEmail(Email email);
}
