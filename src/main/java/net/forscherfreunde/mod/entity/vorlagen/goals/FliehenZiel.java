package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;

public class FliehenZiel extends Ziel {
    private Class<? extends LivingEntity> mob;
    private float distance;
    private double fast_speed;

    public FliehenZiel(Class<? extends LivingEntity> mob, float reichweite, double geschw) {
        this.mob = mob;
        this.distance = reichweite;
        this.fast_speed = geschw;
    }

    @Override
    public Goal create(Object instance) {
        double speed = this.fast_speed * ((PathAwareEntity) instance).getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * this.fast_speed;
        return new FleeEntityGoal((PathAwareEntity) instance, this.mob, this.distance, speed, speed);
    }
}
