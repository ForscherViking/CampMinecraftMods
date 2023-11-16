package net.forscherfreunde.mod.entity.client;

import net.forscherfreunde.mod.TestMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModModelLayers {

    public static HashMap<String, EntityModelLayer> EntityModels = new HashMap();

//    public static final EntityModelLayer PORCUPINE =
//            new EntityModelLayer(new Identifier(TestMod.MOD_ID, "porcupine"), "main");

    public static EntityModelLayer createEntityModelLayer(String name, String path) {
        EntityModelLayer entityModelLayer = new EntityModelLayer(new Identifier(TestMod.MOD_ID, path), "main");
        EntityModels.put(name, entityModelLayer);
        return entityModelLayer;
    }
}
