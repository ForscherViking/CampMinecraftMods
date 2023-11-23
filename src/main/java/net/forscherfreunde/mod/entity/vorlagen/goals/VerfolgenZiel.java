package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;

import java.util.function.Predicate;


public class VerfolgenZiel<T extends LivingEntity> extends Ziel {
    private MobEntity target;

    public VerfolgenZiel(MobEntity mob) {
        this.target = mob;
    }

    @Override
    public Goal create(Object instance) {
        return new FollowMobGoal(
                this.target,
                0.125f,
                1f,
                12f
        );
    }
}
