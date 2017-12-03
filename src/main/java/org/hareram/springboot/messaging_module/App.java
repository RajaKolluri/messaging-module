package org.hareram.springboot.messaging_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 * Hello world!
 *
 */
@Configuration
@SpringBootApplication
@EnableJms
public class App 
{
	
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    }
    
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(App.class);
    }
}
