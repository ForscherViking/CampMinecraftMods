package net.forscherfreunde.mod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.forscherfreunde.mod.TestMod;
import net.forscherfreunde.mod.entity.custom.PorcupineEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModEntities {

    public static HashMap<String, EntityType> ModEntitiesMap = new HashMap<>();
//    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
//            new Identifier(TestMod.MOD_ID, "porcupine"),
//            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new)
//                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static void PutModEntities (String name, EntityType entityType){
        ModEntitiesMap.put(name, entityType);
    }
}
