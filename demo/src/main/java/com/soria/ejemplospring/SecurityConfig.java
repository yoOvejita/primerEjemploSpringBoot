package com.soria.ejemplospring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableJpaRepositories("com.soria.ejemplospring.*")
@ComponentScan(basePackages= {"com.soria.ejemplospring.*"})
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.requiresChannel(channel -> channel.anyRequest().requiresSecure())
				.authorizeRequests(authorize -> authorize.anyRequest().permitAll())
				.build();
	}
}
