package net.forscherfreunde.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.forscherfreunde.mod.registry.Mod;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

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

        //Nicht anfassen - Transparente Blöcke registrieren
        for (Block transparentBlock : Mod.GetAllTransparentBlocks()) {
            BlockRenderLayerMap.INSTANCE.putBlock(transparentBlock, RenderLayer.getCutout());
        }

    }
}
