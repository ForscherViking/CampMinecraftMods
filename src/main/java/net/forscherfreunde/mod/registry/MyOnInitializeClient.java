package net.forscherfreunde.mod.registry;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;


public class MyOnInitializeClient implements ClientModInitializer {

    public void onInitializeClient(){
        for (Block transparentBlock : Mod.GetAllTransparentBlocks()) {
            BlockRenderLayerMap.INSTANCE.putBlock(transparentBlock, RenderLayer.getCutout());
        }

    }
}
