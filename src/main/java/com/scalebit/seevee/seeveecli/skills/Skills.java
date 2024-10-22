package com.scalebit.seevee.seeveecli.skills;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Skills(
    @JsonProperty("groups") List<SkillGroup> skillGroups,
    @JsonProperty("skills") List<Skill> skills
) {
}
