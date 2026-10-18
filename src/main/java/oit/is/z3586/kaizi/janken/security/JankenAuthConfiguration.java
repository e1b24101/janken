package oit.is.z3586.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class JankenAuthConfiguration {

  // 認可処理
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)
      throws Exception {

    http.formLogin(login -> login.permitAll())
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/"))
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/janken", "/janken/**")
            .authenticated()
            .anyRequest().permitAll());

    return http.build();
  }

  // 認証処理
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    // isdevをbcryptでハッシュ化した値
    String password = "{bcrypt}$2y$10$0LY0DL3kbFPTDdXdOLg50eSnrJrLwoYKyOVr8JWR0EoWONv5vyGIG";

    UserDetails user1 = User.withUsername("user1")
        .password(password)
        .roles("USER")
        .build();

    UserDetails user2 = User.withUsername("user2")
        .password(password)
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(user1, user2);
  }
}
