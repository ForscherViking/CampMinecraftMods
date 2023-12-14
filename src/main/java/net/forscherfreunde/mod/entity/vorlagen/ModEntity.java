package net.forscherfreunde.mod.entity.vorlagen;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/*
 * Dies ist die GrundKlasse für eure CustomEntities. Bitte gründlich das Kapitel [...] der Doku lesen.
 * Die einzelnen Zeilen Code sind genauer mit Kommentaren wie diesem erklärt, da findet ihr dann auch genauere Hinweise
 * in der Doku in Kapitel [...]
 */


public abstract class ModEntity extends AnimalEntity {
    protected ModEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else
            --this.idleAnimationTimeout;
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {

        // Standard Goals für jede Custom Mob - Vererbung und Schwimmen
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));

    }

    public static DefaultAttributeContainer.Builder createModEntityAttributes() {
        return MobEntity.createMobAttributes()

                // Attribute für alle Mobs - können angepasst werden mit custom Methoden
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.02f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }

    // zum Anpassen des Paarungs-Items, bitte in der jeweiligen Entity Klasse anpassen - Siehe ModEntity.java
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }


    // Sounds - können durch custom Methode angepasst werden - @Override SoundEvent "name_vom_soundevent"
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_HISS;
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    public Goal setzeZiele(String goal) {

        // Custom Ziele auf Deutsch als Switch - genauere Beschreibung in der Doku
        Goal neuesZiel = null;
        switch (goal) {
            case "Verführen_Ziel": neuesZiel = new TemptGoal(this, 1.15D, Ingredient.ofItems(Items.APPLE), false);
            case "Folge_Eltern_Ziel": neuesZiel = new FollowParentGoal(this, 1.15D);
            case "Herumlaufen_Ziel": neuesZiel = new WanderAroundFarGoal(this, 1.15D);
            case "Anschauen_Ziel": neuesZiel = new LookAtEntityGoal(this, PlayerEntity.class, 4f);
            case "Herumschauen_Ziel": neuesZiel = new LookAroundGoal(this);
            case "Grasen_Ziel": neuesZiel = new EatGrassGoal(this);
            case "Ausser_Sonne_Ziel": neuesZiel = new AvoidSunlightGoal(this);
            case "Atme_Ziel": neuesZiel = new BreatheAirGoal(this);
        }
        return neuesZiel;
    }
}
