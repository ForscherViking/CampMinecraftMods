package net.forscherfreunde.mod;

import net.fabricmc.api.ModInitializer;
import net.forscherfreunde.mod.block.ModBlocks;
import net.forscherfreunde.mod.item.ModItemGroups;
import net.forscherfreunde.mod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "forscherfreundemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}