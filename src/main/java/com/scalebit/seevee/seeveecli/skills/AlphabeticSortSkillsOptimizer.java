package com.scalebit.seevee.seeveecli.skills;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabeticSortSkillsOptimizer implements SkillsOptimisationStrategy {

    @Override
    public Skills optimise(Skills skills) {

        List<SkillGroup> sortedGroups = skills.skillGroups().stream()
            .map(SkillGroup::clone)
            .sorted(Comparator.comparing(SkillGroup::name))
            .toList();

        List<Skill> sortedSkills = skills.skills().stream()
            .map(Skill::clone)
            .sorted(Comparator.comparing(Skill::name))
            .toList();

        return new Skills(sortedGroups, sortedSkills);
    }

}
