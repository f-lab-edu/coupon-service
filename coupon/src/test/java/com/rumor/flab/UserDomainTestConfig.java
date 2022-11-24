package com.rumor.flab;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.rumor.flab.user")
@PropertySource("classpath:application.properties")
public class UserDomainTestConfig {
}
