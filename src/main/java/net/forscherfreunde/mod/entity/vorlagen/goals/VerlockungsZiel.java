package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.recipe.Ingredient;


public class VerlockungsZiel extends Ziel {
    private double speed_in;
    private Ingredient food;

    public VerlockungsZiel(double geschw, Ingredient items) {
        this.speed_in = geschw;
        this.food = items;
    }

    public Ingredient getFood() { return this.food; }

    @Override
    public Goal create(Object instance) {
        return new TemptGoal((PathAwareEntity) instance, ((PathAwareEntity) instance).getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * this.speed_in, this.food, false);
    }
}
