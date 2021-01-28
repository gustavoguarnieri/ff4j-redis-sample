package com.example.ff4jredissample.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
@Order(1)
class FF4jSecurityConfig(
    @Value("\${feature-flag.ff4j.user}")
    private val user: String,
    @Value("\${feature-flag.ff4j.password}")
    private val password: String,
    @Value("\${feature-flag.ff4j.role}")
    private val role: String,
): WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(user)
            .password("{noop}${password}")
            .roles(role)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/ff4j-web-console/**")
            .hasRole("ADMIN")
            .and()
            .httpBasic()
    }
}