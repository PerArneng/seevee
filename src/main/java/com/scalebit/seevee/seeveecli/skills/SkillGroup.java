package com.scalebit.seevee.seeveecli.skills;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SkillGroup(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name
) {

    public static SkillGroup clone(SkillGroup original) {
        return new SkillGroup(original.id(), original.name());
    }
}
