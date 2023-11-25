package net.forscherfreunde.mod.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.forscherfreunde.mod.TestMod;
import net.forscherfreunde.mod.entity.client.ModModelLayers;
import net.forscherfreunde.mod.entity.client.PorcupineRenderer;
import net.forscherfreunde.mod.entity.custom.PorcupineEntity;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModEntities {

    public static HashMap<String, EntityType<PorcupineEntity>> ModEntitiesMap = new HashMap<>();

    public static void createModEntities (String name, EntityType.EntityFactory<PorcupineEntity> entityType){
        EntityType<PorcupineEntity> entityType1 =  Registry.register(Registries.ENTITY_TYPE,
                new Identifier(TestMod.MOD_ID, name),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, entityType)
                        .dimensions(EntityDimensions.fixed(1f, 1f)).build());
        ModEntitiesMap.put(name, entityType1);
        ModModelLayers.registerModelLayer(name);
    }
}
