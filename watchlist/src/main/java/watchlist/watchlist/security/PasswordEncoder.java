package watchlist.watchlist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class holds all password encoder beans
 *
 * @author Belinda Schühle
 */
@Configuration
public class PasswordEncoder {

	@Bean
	public BCryptPasswordEncoder pwEncoder() {
		return new BCryptPasswordEncoder();
	}

}
