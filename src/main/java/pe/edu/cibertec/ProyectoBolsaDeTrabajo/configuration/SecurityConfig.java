package pe.edu.cibertec.ProyectoBolsaDeTrabajo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.DetalleUsuarioService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	private final DetalleUsuarioService detalleUsuarioService;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests()
			.antMatchers("/auth/login",
					"/auth/registrar",
					"/auth/bolsa",
					"/auth/guardarUsuario",
					"/auth/frmBolsa",
					"/cv/frmcv",
					"/cv/registrarCv",
					"/cv/listarCv",
					"/resources/**",
					"/static/**",
					"/css/**",
					"/js/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().loginPage("/auth/login")
			.usernameParameter("txtidUsu")
			.passwordParameter("txtpassword")
			.defaultSuccessUrl("/auth/frmBolsa")
			.failureUrl("/auth/login?error=true")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/auth/login").and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied")
			.and()
			.authenticationProvider(AuthenticationProvider());
		return http.build();
	}
	
	@Bean
	public AuthenticationProvider AuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(detalleUsuarioService);
		authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authenticationProvider;
	} 

}
