package org.hareram.springboot.messaging_module;

import org.hareram.springboot.messaging_module.bean.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJms
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        JmsTemplate template = context.getBean(JmsTemplate.class);
        //sending an email message
        System.out.println("sending email message");
        template.convertAndSend("mailbox", new Email("raja.rao.kolluri@gmail.com", "Hello"));
    }
}
