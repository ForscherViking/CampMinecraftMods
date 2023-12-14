package net.forscherfreunde.mod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.forscherfreunde.mod.TestMod;
import net.forscherfreunde.mod.entity.client.ModModelLayers;
import net.forscherfreunde.mod.entity.vorlagen.ModEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModEntities {


    //Clean - nicht mehr anpassen!
    public static HashMap<String, EntityType<? extends AnimalEntity>> ModEntitiesMap = new HashMap<>();

    public static void createCustomEntity(String name, EntityType.EntityFactory<ModEntity> entityType) {
        EntityType<ModEntity> entityType1 = Registry.register(Registries.ENTITY_TYPE,
                new Identifier(TestMod.MOD_ID, name),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, entityType)
                        .dimensions(EntityDimensions.fixed(1f, 1f)).build());
        ModEntitiesMap.put(name, entityType1);
        ModModelLayers.registerModelLayer(name);
    }
}
