package com.scalebit.seevee.seeveecli.skills;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SkillsIO {

    public static Skills readSkillsFromFile(Path filePath) throws IOException {
        byte[] jsonData = Files.readAllBytes(filePath);
        return JsonSkills.deserialize(new String(jsonData, StandardCharsets.UTF_8));
    }

    public static void writeSkillsToFile(Skills skills, Path filePath) throws IOException {
        String json = JsonSkills.serialize(skills);
        Files.writeString(filePath, json);
    }
}
