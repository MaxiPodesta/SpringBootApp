package ar.com.mp.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {
  @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
     /* @Bean //with this version of SpringSecurity the method is deprecated, I'm still working in a proper version of it, because is the one that allows me to show functions depending if is user or admin
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((authz) -> authz
                .antMatchers("/edit/**", "/add/**", "/delete").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
            )
            .formLogin((formLogin) -> formLogin
                .loginPage("/login")
            )
            .exceptionHandling((exceptionHandling) -> exceptionHandling
                .accessDeniedPage("/errors/errors")
            );
        return http.build();
    }*/
}
