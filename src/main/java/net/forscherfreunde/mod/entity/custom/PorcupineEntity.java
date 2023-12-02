package net.forscherfreunde.mod.entity.custom;

import net.forscherfreunde.mod.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class PorcupineEntity extends ModEntity {

    public PorcupineEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.ModEntitiesMap.get("porcupine").create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack.isOf(Items.BEETROOT);
    }

    @Override
    protected void initGoals() {

        //Custom Goals anpassen -
        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.APPLE), false));

        this.goalSelector.add(3, new FollowParentGoal(this, 1.15D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.15D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(7, new EatGrassGoal(this));
    }
}
