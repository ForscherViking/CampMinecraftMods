package net.forscherfreunde.mod;

import net.forscherfreunde.mod.ausruestung.AusruestungsMaterial;
import net.forscherfreunde.mod.registry.Mod;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

/*
 * Diese Klasse ist die Materialklasse der Vorschauitems "Rubin".
 * Hier seht ihr einmal alle wichtigen Werte implementiert, um eure eigene Klasse zu erstellen.
 * Lest dafür Kapitel [2] in der Doku [Tag 3] genau durch.
 */


public class RubinMaterial extends AusruestungsMaterial {

    @Override
    public int gebeHaltbarkeit() {
        return 3500;
    }

    @Override
    public float gebeAbbauGeschwindigkeitMultiplikator() {
        return 11.0f;
    }

    @Override
    public float gebeAngriffsSchaden() {
        return 0;
    }

    @Override
    public int gebeAbbauLevel() {
        return 5;
    }

    @Override
    public int gebeVerzaubarkeit() {
        return 15;
    }

    @Override
    public Item[] gebeReparaturZutat() {
        return new Item[]{
                Mod.HoleItem("ruby"),
                Items.DIAMOND
        };
    }
}
