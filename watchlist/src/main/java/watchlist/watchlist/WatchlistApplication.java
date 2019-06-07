package watchlist.watchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


@SpringBootApplication
public class WatchlistApplication extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WatchlistApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(WatchlistApplication.class, args);
	}
//	@Bean
//	public ClassLoaderTemplateResolver yourTemplateResolver() {
//	        ClassLoaderTemplateResolver yourTemplateResolver = new ClassLoaderTemplateResolver();
//	        yourTemplateResolver.setPrefix(".component.html");
//		   return yourTemplateResolver;
//	    }
}
