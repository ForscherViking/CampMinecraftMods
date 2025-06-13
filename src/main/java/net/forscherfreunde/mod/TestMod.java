package net.forscherfreunde.mod;

import net.fabricmc.api.ModInitializer;
import net.forscherfreunde.mod.ausruestung.ModRuestungsMaterial;
import net.forscherfreunde.mod.registry.Mod;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.forscherfreunde.mod.registry.item.ModItemGroups;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.item.ArmorItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Willkommen bei Mods Programmierung V4 von ForscherFreunden - ich hoffe, ihr seid alle super angekommen und hattet
 * schon einen tollen ersten Tag mit euren Netten und Coolen Teamern. Im Namen aller Teamer und Beteiligten an diesem
 * Projekt - noch einmal Willkommen und eine tolle Zeit!
 *
 * Diese Klasse wird den großteil eurer Arbeit abnehmen
 *
 * @Author
 * Matthias Mendler
 * @Rechte
 * ForscherFreunde GmbH
 */


public class TestMod implements ModInitializer {
	public static final String MOD_ID = "forscherfreundemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		//TestBlöcke und Items - einfach Code kopieren und Namen anpassen. Nicht anpassen oder Löschen.
		Mod.ItemHinzufuegen("ruby");

		Mod.BlockHinzufuegen("ruby_block", 2.0f, 4);
		Mod.ErzBlockHinzufuegen("ruby_ore", 2.0f, 6);
		Mod.TransparentenBlockHinzufuegen("ruby_glass", 1.0f, 10);



		//TestWerkzeuge und Waffen
		Mod.SchwertHinzufuegen("ruby_sword", new RubinMaterial(), 14, 1.6f);
		Mod.AxtHinzufuegen("ruby_axe", new RubinMaterial(), 12, 1.0f);
		Mod.FeldhackeHinzufuegen("ruby_hoe", new RubinMaterial(), 5, 1.0f);
		Mod.SchaufelHinzufuegen("ruby_shovel", new RubinMaterial(), 2, 1.0f);
		Mod.SpitzhackeHinzufuegen("ruby_pickaxe", new RubinMaterial(), 7, 1.2f);


		//Test Custom Essen
		Mod.FoodItemHinzufuegen("tomato", 3, 0.25f);

		//Test Custom Rüstung
		Mod.RuestungHinzufuegen("ruby_helmet", ModRuestungsMaterial.RUBY, ArmorItem.Type.HELMET);
		Mod.RuestungHinzufuegen("ruby_chestplate", ModRuestungsMaterial.RUBY, ArmorItem.Type.CHESTPLATE);
		Mod.RuestungHinzufuegen("ruby_leggings", ModRuestungsMaterial.RUBY, ArmorItem.Type.LEGGINGS);
		Mod.RuestungHinzufuegen("ruby_boots", ModRuestungsMaterial.RUBY, ArmorItem.Type.BOOTS);


		// *********************************************************************************************************************************************

		//Nicht Verändern! Initialisierung der Mod...
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}