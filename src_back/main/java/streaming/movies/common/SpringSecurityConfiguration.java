package streaming.movies.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/");
  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // loginとlogoutを設定する。基本的な設定なので詳細は割愛
    http
      .authorizeRequests()
      .antMatchers("/css/**","/js/**","/fonts/**","/images/**","/","/api/**").permitAll()
      .antMatchers("/login**").permitAll()
      .antMatchers("/admin","/admin/").access("hasRole('ROLE_ADMIN')")
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .defaultSuccessUrl("/admin")
      .permitAll()
      .and()
      .logout()
      //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
      //.logoutSuccessUrl("/")
      .permitAll();

    http.exceptionHandling()

      /*
        // returns 401 to access to '/ api / **' in unauthenticated state
        .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED), new AntPathRequestMatcher("/api/**"))
      // Access to unauthenticated state other than the above path is changed to '/ login' with 302 redirect
        .defaultAuthenticationEntryPointFor(new LoginUrlAuthenticationEntryPoint("/login"), AnyRequestMatcher.INSTANCE);

       */
      // returns 401 to access to '/ api / **' in unauthenticated state
        .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED), new AntPathRequestMatcher("/admin/api/**"))
      // Access to unauthenticated state other than the above path is changed to '/ login' with 302 redirect
        .defaultAuthenticationEntryPointFor(new LoginUrlAuthenticationEntryPoint("/login"), AnyRequestMatcher.INSTANCE);

    CookieCsrfTokenRepository cookieCsrfTokenRepository = new CookieCsrfTokenRepository(); // ajaxでcsrf tokenを利用するのでcookieに出力する
    cookieCsrfTokenRepository.setCookieHttpOnly(false); // ajaxでも利用するため、httpOnlyはfalseにしておく
    http.csrf().csrfTokenRepository(cookieCsrfTokenRepository);

    //When publishing RESTful API, it is easy to be attacked, so set cors
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
    corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
    corsConfiguration.addAllowedOrigin("http://localhost:3000"); // Actually, the domain should change for each environment, so you can change it dynamically in the settings and charge it
    UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
    corsSource.registerCorsConfiguration("/**", corsConfiguration); // すべてのパスを対象にする
    http.cors().configurationSource(corsSource);
  }

  // デモ用設定
  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    UserDetails user =
      User.withDefaultPasswordEncoder()
          .username("user")
          .password("password")
          .roles("ADMIN")
          .build();

    return new InMemoryUserDetailsManager(user);
  }
}
