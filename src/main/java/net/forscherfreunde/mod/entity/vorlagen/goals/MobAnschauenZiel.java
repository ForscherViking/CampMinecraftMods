package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.mob.MobEntity;


public class MobAnschauenZiel extends Ziel {
    private Class<? extends LivingEntity> target;
    private float range;

    public MobAnschauenZiel(Class<? extends LivingEntity> mob, float reichweite) {
        this.target = mob;
        this.range = reichweite;
    }

    @Override
    public Goal create(Object instance) {
        return new LookAtEntityGoal((MobEntity) instance, this.target, this.range);
    }
}
