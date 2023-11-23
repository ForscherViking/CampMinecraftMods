package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;


public class FolgenZiel extends Ziel {
    private Class<? extends LivingEntity> target;
    private final float maxDistance;
    private final double speed_in;

    public FolgenZiel(Class<? extends LivingEntity> mob, float reichweite, double geschw) {
        this.target = mob;
        this.maxDistance = reichweite;
        this.speed_in = geschw;
    }

    @Override
    public Goal create(Object instance) {
        return new FollowMobGoal((MobEntity) instance, ((MobEntity) instance).getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * this.speed_in, 0.0f, this.maxDistance);
    }
}
