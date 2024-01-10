package net.forscherfreunde.mod.entity.vorlagen;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

/*
 + BITTE GENAU LESEN!! +
 * Diese Klasse ist eine Beispielklasse zum Kopieren und Anpassen - alle genauen Schritte sind in der Doku [Tag 4] in
 * [Kapitel 4.2] zu finden. Bitte achtet genau auf die Doku, da ihr sonst eventuell Fehler einbaut, die schwer zu finden sind.
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

public class CustomMobVorlage extends ModMob{
    protected CustomMobVorlage(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        //hier werden die Basisattribute des Mobs gesetzt - hier könnt ihr diese also ganz einfach anpassen.
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1);
    }

    protected void initCustomGoals() {
        //hier dann custom Ziele des Mobs angeben - eigentlich sind hier keine nötig
    }
}
