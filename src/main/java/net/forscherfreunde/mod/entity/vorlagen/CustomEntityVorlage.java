package net.forscherfreunde.mod.entity.vorlagen;

import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.registry.Mod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/*
 + BITTE GENAU LESEN!! +
 * Diese Klasse ist eine Beispielklasse zum Kopieren und Anpassen - alle genauen Schritte sind in der Doku auf Seite ...
 * zu finden. Bitte achtet genau auf die Doku, da ihr sonst eventuell Fehler einbaut, die schwer zu finden sind.
 * Bei Rot unterstrichenen Fehlern wie hier - Alle - bitte euren Teamer fragen, dass er sich den Fehler im Code
 * einmal anschauen kann. Diese Fehler führen dazu, dass das Programm gar nicht erst ausgeführt werden kann. Ihr bekommt
 * dann auch direkt einen Fehler in der Konsole ausgespuckt. Vermutlich liegt es dann an einem Rechtschreibfehler oder
 * Syntaxfehler. Meistens gibt euch IntelliJ auch schon Vorschläge, jedoch bitte nicht einfach die Vorschläge
 * ausführen, da das manchmal auch zu noch mehr Fehlern führen kann.
 *
 * Viel Spaß mit der Klasse.
 * @Author
 * Matthias Mendler
 */



public class CustomEntityVorlage extends ModEntity{
    protected CustomEntityVorlage(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.ModEntitiesMap.get("name_von_custom_entity").create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Mod.HoleItem("name_von_Item_zum_Paaren"));
    }

    @Override
    protected void initGoals() {
        // Hier dann neue Ziele von Liste -- Bitte mit Priorität: 2 Anfangen (Also einfach 2, setzeZiel("..."))

        this.goalSelector.add(2, setzeZiele("name_von_Ziel_von_Liste"));
    }
}
