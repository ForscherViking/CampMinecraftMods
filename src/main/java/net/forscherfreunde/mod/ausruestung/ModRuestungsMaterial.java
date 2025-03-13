package net.forscherfreunde.mod.ausruestung;

import net.forscherfreunde.mod.TestMod;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModRuestungsMaterial implements ArmorMaterial {

    RUBY("ruby", 25, new int[] {3, 8, 6, 3}, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f, 0.2f, ()-> Ingredient.ofItems(ModItems.GetItem("ruby")))
    ;



    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackbackResistence;
    private final Supplier<Ingredient> repairIngredient;

    public static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModRuestungsMaterial (String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
                          float toughness, float knockbackbackResistence, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this. equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackbackResistence = knockbackbackResistence;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return TestMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackbackResistence;
    }
}
