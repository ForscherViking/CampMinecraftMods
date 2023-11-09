package net.forscherfreunde.mod;

import net.fabricmc.api.ModInitializer;
import net.forscherfreunde.mod.registry.Mod;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.forscherfreunde.mod.registry.item.ModItemGroups;
import net.forscherfreunde.mod.registry.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "forscherfreundemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		//TestBlöcke und Items - einfach Code kopieren und Namen anpassen.
		Mod.BlockHinzufuegen("ruby_block", 2.0f, 10.0f, 4);
		Mod.ItemHinzufuegen("ruby");


		//TestWerkzeuge und Waffen - einfach Code kopieren und Namen und Attribute anpassen.




		//Nicht Verändern!! Initialisierung der Mod...
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}