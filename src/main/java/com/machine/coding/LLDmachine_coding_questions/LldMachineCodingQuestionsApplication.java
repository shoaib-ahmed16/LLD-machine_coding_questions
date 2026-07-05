package com.machine.coding.LLDmachine_coding_questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LldMachineCodingQuestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LldMachineCodingQuestionsApplication.class, args);
	}

}
