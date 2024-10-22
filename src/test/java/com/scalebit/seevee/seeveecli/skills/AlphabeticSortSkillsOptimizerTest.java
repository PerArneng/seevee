package com.scalebit.seevee.seeveecli.skills;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticSortSkillsOptimizerTest {

    @Test
    void optimise_normal() {

        List<SkillGroup> skillGroups = List.of(
            new SkillGroup("1", "Java"),
            new SkillGroup("2", "Python")
        );

        List<Skill> skills = List.of(
            new Skill("1", "Spring", "1"),
            new Skill("2", "Hibernate", "1"),
            new Skill("3", "Django", "2")
        );

        Skills skillsObject = new Skills(skillGroups, skills);
        SkillsOptimisationStrategy alphabeticSortSkillsOptimizer = new AlphabeticSortSkillsOptimizer();
        Skills optimizedSkills = alphabeticSortSkillsOptimizer.optimise(skillsObject);

        assertEquals(2, optimizedSkills.skillGroups().size());
        assertEquals("Java", optimizedSkills.skillGroups().getFirst().name());
        assertEquals("Python", optimizedSkills.skillGroups().get(1).name());

        assertEquals(3, optimizedSkills.skills().size());
        assertEquals("Django", optimizedSkills.skills().getFirst().name());
        assertEquals("Hibernate", optimizedSkills.skills().get(1).name());
        assertEquals("Spring", optimizedSkills.skills().get(2).name());
    }

    @Test
    void optimise_empty_lists() {

        List<SkillGroup> skillGroups = List.of();

        List<Skill> skills = List.of();

        Skills skillsObject = new Skills(skillGroups, skills);
        SkillsOptimisationStrategy alphabeticSortSkillsOptimizer = new AlphabeticSortSkillsOptimizer();
        Skills optimizedSkills = alphabeticSortSkillsOptimizer.optimise(skillsObject);

        assertEquals(0, optimizedSkills.skillGroups().size());
        assertEquals(0, optimizedSkills.skills().size());
    }
}