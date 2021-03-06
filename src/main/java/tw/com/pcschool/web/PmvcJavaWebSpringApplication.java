package tw.com.pcschool.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class PmvcJavaWebSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmvcJavaWebSpringApplication.class, args);
	}

}
