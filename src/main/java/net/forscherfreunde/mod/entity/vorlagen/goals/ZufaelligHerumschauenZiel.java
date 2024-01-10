package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.mob.MobEntity;


public class ZufaelligHerumschauenZiel extends Ziel {
    @Override
    public Goal create(Object instance) {
        return new LookAroundGoal((MobEntity) instance);
    }
}
