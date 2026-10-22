package com.example.__spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.__spring_security.service.CustomUserDetailsService;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {

		http.authorizeHttpRequests(auth -> auth.requestMatchers("/register").permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()); // Enable HTTP Basic authentication
		// .formLogin(form->form.permitAll()); // Enable form login if needed

		return http.build();
	}

//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		PasswordEncoder passwordEncoder,
//		CustomUserDetailsService userDetailsService{
//			DaoAuthenticationProvider dao = DaoAuthenticationProvider(userDetailsService);
//			dao.setPasswordEncoder(passwordEncoder);
//			return dao;
//		}
//		
//		@Bean
//		public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
//			return configuration.getAuthenticationManager();
//		}
//		@Bean
//		public passwordEncoder passwordEncoder() {
//			return new BCryptPasswordEncoder();
//					
//		

	@Bean
	public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder,
			CustomUserDetailsService userDetailsService) {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider(userDetailsService);
		dao.setPasswordEncoder(passwordEncoder);
		return dao;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}