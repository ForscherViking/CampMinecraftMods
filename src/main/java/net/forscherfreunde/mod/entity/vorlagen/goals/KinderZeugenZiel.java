package net.forscherfreunde.mod.entity.vorlagen.goals;

import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.recipe.Ingredient;


public class KinderZeugenZiel extends Ziel {
    private Ingredient food;

    public KinderZeugenZiel(Ingredient futter) {
        this.food = futter;
    }

    public Ingredient getFood() { return this.food; }

    @Override
    public Goal create(Object instance) {
        return new AnimalMateGoal((AnimalEntity) instance, 1.0d);
    }
}
