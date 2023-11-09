package net.forscherfreunde.mod.ausruestung;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public abstract class AusruestungsMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return gebeHaltbarkeit();
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return gebeAbbauGeschwindigkeitMultiplikator();
    }

    @Override
    public float getAttackDamage() {
        return gebeAngriffsSchaden();
    }

    @Override
    public int getMiningLevel() {
        return gebeAbbauLevel();
    }

    @Override
    public int getEnchantability() {
        return gebeVerzaubarkeit();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(gebeReparaturZutat());
    }

    public abstract int gebeHaltbarkeit();
    public abstract float gebeAbbauGeschwindigkeitMultiplikator();
    public abstract float gebeAngriffsSchaden();
    public abstract int gebeAbbauLevel();
    public abstract int gebeVerzaubarkeit();
    public abstract Item[] gebeReparaturZutat();
}
