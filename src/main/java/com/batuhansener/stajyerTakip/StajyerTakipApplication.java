package com.batuhansener.stajyerTakip;

import com.batuhansener.stajyerTakip.model.Role;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class StajyerTakipApplication{
	public static void main(String[] args) {
		SpringApplication.run(StajyerTakipApplication.class, args);
	}
}
