package com.scalebit.seevee.seeveecli.spring;

import com.scalebit.seevee.seeveecli.skills.JsonSkills;
import com.scalebit.seevee.seeveecli.skills.Skills;
import com.scalebit.seevee.seeveecli.skills.SkillsIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.command.CommandContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SkillCommands {

    private static final Logger logger = LoggerFactory.getLogger(SkillCommands.class);

    public static void optimize(CommandContext commandContext) {
        String skillFilePath = commandContext.getOptionValue("skill-file");
        Path skillFile = Paths.get(skillFilePath);

        String outputFilePath = commandContext.getOptionValue("output-file");
        Path outputFile = Paths.get(outputFilePath);

        if (!Files.exists(outputFile.getParent())) {
            logger.error("Parent directory {} does not exist.", outputFile.getParent().toString());
            throw new RuntimeException("Parent directory does not exist.");
        }

        if (!Files.exists(skillFile)) {
            logger.error("File {} does not exist.", skillFile.toString());
            return;
        }

        if (!skillFile.toString().endsWith(".json")) {
            System.out.println("File is not a JSON file.");
            return;
        }

        try {
            Skills skills = SkillsIO.readSkillsFromFile(skillFile);
            String json = JsonSkills.serialize(skills);
            System.out.println(json);
        } catch (IOException e) {
            logger.error("error reading the file!", e);
        }
    }


}