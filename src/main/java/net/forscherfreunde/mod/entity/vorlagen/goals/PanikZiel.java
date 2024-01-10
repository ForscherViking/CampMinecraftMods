package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;


public class PanikZiel extends Ziel {

    private double speed_in;

    public PanikZiel(double geschw) {
        this.speed_in = geschw;
    }

    @Override
    public Goal create(Object instance) {
        return new EscapeDangerGoal((PathAwareEntity) instance, this.speed_in * ((PathAwareEntity) instance).getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
    }
}
