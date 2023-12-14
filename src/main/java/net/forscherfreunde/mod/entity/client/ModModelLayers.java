package net.forscherfreunde.mod.entity.client;

import net.forscherfreunde.mod.TestMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModModelLayers {

    //soweit clean und müssen nicht mehr verändert werden

    public static HashMap<String, EntityModelLayer> EntityModels = new HashMap<>();

    public static EntityModelLayer createEntityModelLayer(String name) {
        return new EntityModelLayer(new Identifier(TestMod.MOD_ID, name), "main");
    }

    public static void registerModelLayer(String name) {
        EntityModels.put(name + "_model", createEntityModelLayer(name));
    }
}
