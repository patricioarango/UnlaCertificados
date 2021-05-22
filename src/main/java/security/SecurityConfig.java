package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import security.UserDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Necesario para evitar que la seguridad se aplique a los resources 
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
    
	@Autowired 
	UserDetailsServiceImplementation userDetailsService;
	
	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() 
        .antMatchers(resources).permitAll() 
        .antMatchers("/","/login").permitAll()
        .antMatchers("/user*").hasAnyRole("ADMINISTRADOR","AUDITOR")
        .antMatchers("/admin*").hasRole("ADMINISTRADOR") 
        .anyRequest().authenticated().and()
        .formLogin()
        .loginPage("/login") 
        .permitAll()
        .defaultSuccessUrl("/home")
        .failureUrl("/login?error=true")
        .usernameParameter("username")
        .passwordParameter("password") 
        .and()
        .logout()
        .permitAll()
        .logoutSuccessUrl("/login?logout");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}

}