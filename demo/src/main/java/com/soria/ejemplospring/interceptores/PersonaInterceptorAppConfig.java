package com.soria.ejemplospring.interceptores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class PersonaInterceptorAppConfig implements WebMvcConfigurer{
	@Autowired
	private PersonaInterceptor interceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registro) {
		registro.addInterceptor(interceptor);
	}
}
