package in.snm.personal_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;

import in.snm.personal_service.user.Role;
import in.snm.personal_service.user.User;
import in.snm.personal_service.user.UserRepository;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAsync
public class PersonalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            return args -> {

				if (userRepository.findByEmail("admin@snm.personal").isEmpty()) {
					var adminUser = User.builder()
					.firstname("Shahid")
					.lastname("Nazir Z")
					.email("admin@snm.personal")
					.password(passwordEncoder.encode("passPersonalService"))
					.role(Role.ADMIN)
					.build();
					
					userRepository.save(adminUser);
				}
	};

}
}