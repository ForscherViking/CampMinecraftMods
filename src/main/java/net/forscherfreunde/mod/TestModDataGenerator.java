package net.forscherfreunde.mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.forscherfreunde.mod.datagen.ModBlockTagProvider;
import net.forscherfreunde.mod.datagen.ModItemTagProvider;
import net.forscherfreunde.mod.datagen.ModLootTableProvider;
import net.forscherfreunde.mod.datagen.ModModelsProvider;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);

	}
}
