package com.scalebit.seevee.seeveecli;

import com.scalebit.seevee.seeveecli.spring.SkillCommands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.command.annotation.EnableCommand;

import java.io.File;
import java.nio.file.Path;

@SpringBootApplication
public class SeeVeeCliApplication {

	@Bean
	public CommandRegistration skillCommands() {
		return CommandRegistration.builder()
				.command("skills", "optimize")
				.description("manipulate skill files")
				.withTarget()
					.consumer(SkillCommands::optimize)
				.and()
				.withOption()
					.longNames("skill-file")
					.shortNames('f')
					.required()
					.description("the skill file to process")
					.type(String.class)
				.and()
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SeeVeeCliApplication.class, args);
	}

}
