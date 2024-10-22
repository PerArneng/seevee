package com.scalebit.seevee.seeveecli.skills;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSkills {

    public static String serialize(Skills skills) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(skills);
    }

    public static Skills deserialize(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Skills.class);
    }

}
