package net.forscherfreunde.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.entity.client.*;
import net.forscherfreunde.mod.registry.Mod;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import static net.forscherfreunde.mod.entity.client.ModModelLayers.EntityModels;

/*
 * Dies ist die Client Klasse - siehe Kapitel [...] in der Doku.
 * Diese Klasse erfordert wenig Änderungen, jedoch müsst ihr darauf achten, jede Zeile Code hier ordentlich zu schreiben
 * damit keine Fehler entstehen. Hier ist also viel Vorsicht und Konzentration gefordert.
 * Gelbe unterstrichene Zeilen Code - wie unten schon steht - ist kein Problem und kann ignoriert werden.
 * Bei rot unterstrichenen Zeilen Code bitte euren Teamer ansprechen!
 */


public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //Zeilen kopieren und Namen ändern vom .get Aufruf - .get("custom_entity_name"), und dem CustomModel::getTexturedModelData
        EntityModelLayerRegistry.registerModelLayer(EntityModels.get("porcupine_model"), PorcupineModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModels.get("cloudy_model"), CloudyModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModels.get("ffbear_model"), FFBearModel::getTexturedModelData);
        //Anpassen vom .get("custom_entity_name") und dem CustomEntityRenderer::new
        EntityRendererRegistry.register(((FabricEntityType) ModEntities.ModEntitiesMap.get("porcupine")), PorcupineRenderer::new);
        EntityRendererRegistry.register(((FabricEntityType) ModEntities.ModEntitiesMap.get("cloudy")), CloudyRenderer::new);
        EntityRendererRegistry.register(((FabricEntityType) ModEntities.ModEntitiesMap.get("ffbear")), FFBearRenderer::new);



        //Nicht anfassen - Transparente Blöcke registrieren
        for (Block transparentBlock : Mod.GetAllTransparentBlocks()) {
            BlockRenderLayerMap.INSTANCE.putBlock(transparentBlock, RenderLayer.getCutout());
        }

    }
}
