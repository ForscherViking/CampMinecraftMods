package net.forscherfreunde.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.entity.client.PorcupineModel;
import net.forscherfreunde.mod.entity.client.PorcupineRenderer;
import net.forscherfreunde.mod.registry.Mod;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import static net.forscherfreunde.mod.entity.client.ModModelLayers.EntityModels;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //Zeilen kopieren und Namen ändern vom .get Aufruf

        EntityModelLayerRegistry.registerModelLayer(EntityModels.get("porcupine_model"), PorcupineModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ModEntitiesMap.get("porcupine"), PorcupineRenderer::new);



        //Nicht anfassen - Transparente Blöcke registrieren
        for (Block transparentBlock : Mod.GetAllTransparentBlocks()) {
            BlockRenderLayerMap.INSTANCE.putBlock(transparentBlock, RenderLayer.getCutout());
        }

    }
}
