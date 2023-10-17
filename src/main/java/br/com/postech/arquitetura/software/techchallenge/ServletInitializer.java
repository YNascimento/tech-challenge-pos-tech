package br.com.postech.arquitetura.software.techchallenge;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import br.com.postech.arquitetura.software.techchallenge.configuration.ParameterConfig;


@Controller
@EnableAutoConfiguration
@EntityScan(basePackages = { ParameterConfig.PACKAGE_MODEL })
@EnableJpaRepositories(basePackages = { ParameterConfig.PACKAGE_REPOSITORY })
@ComponentScan(basePackages = {ParameterConfig.PACKAGE_CONTROLLERS,
							   ParameterConfig.PACKAGE_SECURITY,
							   ParameterConfig.PACKAGE_CONFIGURATION,
							   ParameterConfig.PACKAGE_SERVICE,
							   ParameterConfig.PACKAGE_VALIDATION,
							   ParameterConfig.PACKAGE_REPOSITORY_JDBC})
public class ServletInitializer extends SpringBootServletInitializer {

	
	public ServletInitializer() {
		super();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
