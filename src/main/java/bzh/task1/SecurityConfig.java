package bzh.task1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        SecurityFilterChain filterChain = http.authorizeHttpRequests()
                .requestMatchers("/post").authenticated()
                .and().formLogin().permitAll() //loginPage("/login").permitAll()
                .and().logout().logoutSuccessUrl("/start")
                .and().build();
        return filterChain;
    }
}
