package com.scalebit.seevee.seeveecli.skills;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Skill(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("group_id") String groupId
) {

    public static Skill clone(Skill original) {
        return new Skill(original.id(), original.name(), original.groupId());
    }
}
