package com.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.annotation.config.annotations.ConjurValue;
import com.annotation.config.annotations.ConjurValues;
import com.cyberark.conjur.sdk.ApiException;

@SpringBootApplication
@PropertySource("classpath:conjur.properties")
public class ConjurUser {

	@ConjurValue(key = "jenkins-app/mySql")
	public static String key;

	@ConjurValues(keys = { "jenkins-app/web_password", "jenkins-app/webPassword" })
	public static String keys;

	public static void main(String[] args) throws ApiException {

		SpringApplication.run(ConjurUser.class, args);

		System.out.println("Key-> " + key);
		System.out.println("Keys-> " + keys);

	}

}