package com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Configs;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.ActorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ImSckSecutiryConfig extends WebSecurityConfigurerAdapter {
  private ActorDetailService actorDetailService;

  public ImSckSecutiryConfig(@Autowired ActorDetailService actorDetailService) {
    this.actorDetailService = actorDetailService;
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Override
  protected void configure(HttpSecurity httpSecurity)throws Exception {
    httpSecurity.authorizeHttpRequests()
        .antMatchers("/*").authenticated()
        .and()
        .antMatcher("api/clients/v1/RegisterNewClient").anonymous()
        .and()
        .formLogin()
        .and()
        .logout().logoutSuccessUrl("/");
  }
  @Bean
  public DaoAuthenticationProvider DAOAuthProvider(){
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    authenticationProvider.setUserDetailsService(actorDetailService);
    return authenticationProvider;
  }
}
