package net.forscherfreunde.mod.entity.vorlagen;

import net.forscherfreunde.mod.entity.CustomModEntities;
import net.forscherfreunde.mod.entity.vorlagen.goals.Ziel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import net.forscherfreunde.mod.entity.vorlagen.goals.Ziel;


public abstract class MonsterVorlage extends HostileEntity {
    protected String name;

    protected MonsterVorlage(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.gebeName();
        int i = 0;
        for (Ziel ziel : CustomModEntities.MONSTER.get(this.name.toLowerCase()).verhalten) {
            this.goalSelector.add(i, ziel.create(this));
            i++;
        }
    }

    public abstract void gebeName();
}
