package watchlist.watchlist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This class is the main security context
 *
 * @author Belinda Schühle
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private WebMvcConfig webmvcConf;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest()
				.authenticated().and().csrf().disable()
				.logout().permitAll()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				// SuccessURL is only temporary, until the frontend is developed
				.logoutSuccessUrl("/register").and() 
				.exceptionHandling().accessDeniedPage("/access-denied") // TODO: implement access-denied and Error pages
				.and().formLogin()
				.loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
					@Override
					// Redirection after successful login
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						// SuccessURL is only temporary, until the frontend is developed
						redirectStrategy.sendRedirect(request, response, "/register");
					}
				});

	}

	/**
	 * @return
	 * @throws Exception
	 */
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

	/**
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(webmvcConf.pwEncoder());
	}

}