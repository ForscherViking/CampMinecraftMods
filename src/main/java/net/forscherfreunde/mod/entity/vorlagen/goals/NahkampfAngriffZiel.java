package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;


public class NahkampfAngriffZiel extends Ziel {

    class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
            super(mob, speed, pauseWhenMobIdle);
        }

        @Override
        public void tick() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity != null) {
                super.tick();
            }
        }
    }

    private double speed_in;

    public NahkampfAngriffZiel(double geschw) {
        this.speed_in = geschw;
    }

    @Override
    public Goal create(Object instance) {
        return new AttackGoal((PathAwareEntity) instance, this.speed_in * ((PathAwareEntity) instance).getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED), true);
    }
}
