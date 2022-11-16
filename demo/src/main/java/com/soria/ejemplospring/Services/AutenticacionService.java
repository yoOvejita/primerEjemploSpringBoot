package com.soria.ejemplospring.Services;

import org.springframework.stereotype.Service;

@Service
public interface AutenticacionService {
	boolean autenticar(String usuario, String password);
}
