package net.forscherfreunde.mod.entity.custom;

import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.entity.vorlagen.ModEntity;
import net.forscherfreunde.mod.registry.Mod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

/*
 + BITTE GENAU LESEN!! +
 * Dies ist die Entity Klasse der Custom Entity "Porcupine", die hier zur Vorschau dient.
 * Bitte lest die Klasse "CustomEntityVorlage" genau durch - und die Doku auf Seite [...]
 */



public class PorcupineEntity extends ModEntity {

    public PorcupineEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    // Anpassen vom .get("custom_entity_name")
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.ModEntitiesMap.get("porcupine").create(world);
    }

    @Override
    // Anpassen des Paarungs-Essens
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack.isOf(Mod.HoleItem("tomato"));
    }

    @Override
    protected void initGoals() {

        //Custom Goals anpassen - Schlüsselwörter in Doku

        this.goalSelector.add(2, setzeZiele("Verführen_Ziel"));
        this.goalSelector.add(3, setzeZiele("Folge_Eltern_Ziel"));
        this.goalSelector.add(4, setzeZiele("Herumlaufen_Ziel"));
        this.goalSelector.add(5, setzeZiele("Anschauen_Ziel"));
        this.goalSelector.add(6, setzeZiele("Herumschauen_Ziel"));
        this.goalSelector.add(7, setzeZiele("Grasen_Ziel"));
        this.goalSelector.add(8, setzeZiele("Atme_Ziel"));
    }
}
