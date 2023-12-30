package net.forscherfreunde.mod.entity.vorlagen;

import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.registry.Mod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
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
        return (PassiveEntity) ModEntities.ModEntitiesMap.get("name_von_custom_entity").create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Mod.HoleItem("name_von_Item_zum_Paaren"));
    }

    @Override
    protected void initGoals() {

        //Diese Ziele nicht anpassen!
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));

        // Hier dann neue Ziele von Liste -- Bitte mit Priorität: 3 Anfangen (Also einfach 3, setzeZiel("..."))

        this.goalSelector.add(3, setzeZiele("name_von_Ziel_von_Liste", this));
    }
}
