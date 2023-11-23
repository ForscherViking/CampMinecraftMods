package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.mob.MobEntity;


public class SchwimmenZiel extends Ziel {

    public SchwimmenZiel() { }

    @Override
    public Goal create(Object instance) {
        return new SwimGoal((MobEntity) instance);
    }
}
