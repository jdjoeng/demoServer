package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * CommonDateEntity의 Auditing 활성화를 위해 @EnableJpaAuditing 추가
 * @author JD
 *
 */

@EnableJpaAuditing
@SpringBootApplication
@EnableScheduling
public class MydataApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MydataApplication.class, args);
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
