package net.forscherfreunde.mod.entity.client;

import net.forscherfreunde.mod.TestMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(TestMod.MOD_ID, "porcupine"), "main");
}
