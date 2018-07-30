package com.niche;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.niche.model.User;
// import com.niche.repository.UserRepository;

/**
 * Class : pghApplication
 * 
 * Default java file which is created during first launch of application 
 * and it help us to run the project.
 * using of annotation to auto-configure the application.  
 * 
 * @author nicheHands
 */
@SpringBootApplication
public class PghApplication implements CommandLineRunner{

	/*@Autowired
	private UserRepository userRepository;*/
	
	public static void main(String[] args) {
		SpringApplication.run(PghApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*userRepository.save(new User((long) 0, "First Name", "Last Name", "User Name", "Email Id", 
			(long) 0, (long) 0,(long) 0 , null, null)
		);*/
	}
}
