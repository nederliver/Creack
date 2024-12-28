package net.nederliver.creack;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Sounds {
    public static final SoundEvent CREACK = registerSoundEvent("creack");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(Creack.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        Creack.LOGGER.info("Registering " + Creack.MOD_ID + " Sounds");
    }
}