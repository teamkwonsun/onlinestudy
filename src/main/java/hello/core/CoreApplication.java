package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {



	public static void main(String[] args) {

		SpringApplication.run(CoreApplication.class, args);
	}

}
