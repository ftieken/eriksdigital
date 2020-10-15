package nl.fredtieken.eriksdigital.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
public class SpringSecurityConfig { //extends WebSecurityConfigurerAdapter {

    // Secure the endpoins with HTTP Basic authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                //HTTP Basic authentication
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/order/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/order").permitAll()
//                .antMatchers(HttpMethod.PUT, "/order/**").authenticated()
//                .antMatchers(HttpMethod.PATCH, "/order/**").authenticated()
//                .antMatchers(HttpMethod.DELETE, "/order/**").authenticated()
//                .antMatchers("/h2-console/**").permitAll();
//    }
}