package watchlist.watchlist.loggin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * This class holds all configurations for the Logger
 *
 * @author Belinda Schühle
 */
@Configuration
public class LoggerConfig {
	
	/**
	 * @return rootLogger
	 */
	@Bean(name = "rootLogger")
	public Logger rootLogger() {
		return LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
	}
	
	/**
	 * @return web_error_logger
	 */
	@Bean(name = "webErrorLogger")
	public Logger webErrorLogger() {
		return LoggerFactory.getLogger("web_error_logger");
	}
	
	/**
	 * @param injectionPoint
	 * @return injectionPoint declaringclass
	 */
	@Primary
	@Bean(name = "localLogger")
	@Scope("prototype")
	public Logger localLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
	}
	
}
