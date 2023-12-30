package net.forscherfreunde.mod.entity.custom;

import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.entity.vorlagen.CustomEntityVorlage;
import net.forscherfreunde.mod.registry.Mod;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

/*
 + BITTE GENAU LESEN!! +
 * Dies ist die Entity Klasse der Custom Entity "Porcupine", die hier zur Vorschau dient.
 * Bitte lest die Klasse "CustomEntityVorlage" genau durch - und die Doku auf Seite [...]
 */



public class PorcupineEntity extends CustomEntityVorlage {

    public PorcupineEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    // Anpassen vom .get("custom_entity_name")
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return (PassiveEntity) ModEntities.ModEntitiesMap.get("porcupine").create(world);
    }

    @Override
    // Anpassen des Paarungs-Essens
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack.isOf(Mod.HoleItem("tomato"));
    }

    @Override
    protected void initCustomGoals() {

        //Custom Goals anpassen - Schlüsselwörter in Doku
        this.goalSelector.add(3, setzeZiele("Verführen_Ziel", this));
        this.goalSelector.add(4, setzeZiele("Folge_Eltern_Ziel", this));
        this.goalSelector.add(4, setzeZiele("Herumlaufen_Ziel", this));
        this.goalSelector.add(5, setzeZiele("Anschauen_Ziel", this));
        this.goalSelector.add(6, setzeZiele("Herumschauen_Ziel", this));
        this.goalSelector.add(7, setzeZiele("Grasen_Ziel", this));
    }

    //Anpassen des VerfuehrungsItems
    @Override
    public ItemConvertible setzeVerfuehrungsItem() {
        VerfuehrungsItem = ModItems.GetItem("tomato");
        return VerfuehrungsItem;
    }
}
