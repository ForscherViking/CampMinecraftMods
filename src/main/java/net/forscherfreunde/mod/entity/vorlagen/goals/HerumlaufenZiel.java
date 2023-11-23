package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;


public class HerumlaufenZiel extends Ziel {
    private int chance;

    public HerumlaufenZiel(int chance) {
        this.chance = chance > 0 ? chance:120;
    }

    public class WanderAroundFarChanceGoal extends WanderAroundFarGoal {
        public WanderAroundFarChanceGoal(PathAwareEntity pathAwareEntity, double d, int chance) {
            super(pathAwareEntity, d);
            this.chance = chance;
        }
    }

    public Goal create(Object instance) {
        return new WanderAroundFarChanceGoal((PathAwareEntity)instance, ((PathAwareEntity) instance).getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED), chance);
    }
}
