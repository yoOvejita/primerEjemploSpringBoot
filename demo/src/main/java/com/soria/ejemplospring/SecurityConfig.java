package com.soria.ejemplospring;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableJpaRepositories("com.soria.ejemplospring.*")
@ComponentScan(basePackages= {"com.soria.ejemplospring.*"})
@EntityScan("com.soria.ejemplospring.*")
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();//Deshabilitamos CSRF
		return http
				.requiresChannel(channel -> channel.anyRequest().requiresSecure())
				.authorizeRequests(authorize -> authorize.anyRequest().permitAll())
				.build();
	}
}

/*
POST /transferencia HTTP/1.1
Host: www.bancocualquiera.bo
Cookie: JSESSIONID=randomid; Domain=www.bancocualquiera.bo;
Content-Type: application/x-www-form-urlencoded
cantidad=120.00&numeroRuta=1234&cuenta=5678&_csrf=<valor_aleatorio_seguro>


<form action="https://www.bancocualquiera.bo/transferencia" method="post">
	<input type="hidden" name="cantidad" value="100.00"/>
	<input type="hidden" name="numeroRuta" value="nroRutaDelEstafador"/>
	<input type="hidden" name="cuenta" value="nrocuentaDelEstafador"/>
	<input type="submit" value="Postula a una beca completa"/>
</form>



Ejemplo JSP:
<form action="${UrlLogout}" method="post">
	
	<input type="submit" value="Salir"/>
	<input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}"
	/>
</form>

 */