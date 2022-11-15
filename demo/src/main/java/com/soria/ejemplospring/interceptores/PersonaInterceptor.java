package com.soria.ejemplospring.interceptores;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class PersonaInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws Exception{
		System.out.println(">>> Se llamó al método PreHandle");
		if(request.getMethod().equals("PUT"))
			System.out.println(">>>>>> Desde preHandle: Método de petición PUT");
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println(">>> Se llamó al método PostHandle");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{
		System.out.println(">>> Ciclo de peticfión&respuesta completado");
		
	}
}
