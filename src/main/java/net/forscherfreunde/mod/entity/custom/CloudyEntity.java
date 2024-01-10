package net.forscherfreunde.mod.entity.custom;

import net.forscherfreunde.mod.entity.vorlagen.CustomMobVorlage;
import net.forscherfreunde.mod.entity.vorlagen.ModMob;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.World;

public class CloudyEntity extends ModMob {
    public CloudyEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        //hier werden die Basisattribute des Mobs gesetzt - hier könnt ihr diese also ganz einfach anpassen.
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1);
    }

    @Override
    protected void initCustomGoals() {
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PorcupineEntity.class, true));
    }

    @Override
    public int getXpToDrop() {
        if (this.isBaby()) {
            this.experiencePoints = (int)((double)this.experiencePoints * 2.5);
        }
        return super.getXpToDrop();
    }

}
