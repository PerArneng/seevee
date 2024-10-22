package com.scalebit.seevee.seeveecli.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.command.CommandContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SkillCommands {

    private static final Logger logger = LoggerFactory.getLogger(SkillCommands.class);

    public static void optimize(CommandContext commandContext) {
        File skillFile = commandContext.getOptionValue("skill-file");

        if (!skillFile.exists()) {
            logger.error("File {} does not exist.", skillFile.getPath());
            return;
        }

        if (!skillFile.getName().endsWith(".json")) {
            System.out.println("File is not a JSON file.");
            return;
        }

        try {
            String content = new String(Files.readAllBytes(Paths.get(skillFile.getPath())));
            // Add your JSON processing logic here
            System.out.println("File is valid and ready for processing.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }


}