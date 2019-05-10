package watchlist.watchlist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class holds all password encoder beans
 *
 * @author Belinda Schühle
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	/**
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder pwEncoder() {
		return new BCryptPasswordEncoder();
	}

}
