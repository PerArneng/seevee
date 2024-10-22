package com.scalebit.seevee.seeveecli.skills;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SkillsIO {

    public static Skills readSkillsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), Skills.class);
    }

    public static void writeSkillsToFile(Skills skills, File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, skills);
    }
}
