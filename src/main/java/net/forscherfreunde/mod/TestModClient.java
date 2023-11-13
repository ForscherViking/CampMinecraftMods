package net.forscherfreunde.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.entity.client.ModModelLayers;
import net.forscherfreunde.mod.entity.client.PorcupineModel;
import net.forscherfreunde.mod.entity.client.PorcupineRenderer;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);

    }
}
