package net.nederliver.creack;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.sound.PositionedSoundInstance;

public class CreackClient implements ClientModInitializer {

    private boolean hasPlayedSound = false;

    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof TitleScreen && !hasPlayedSound) {
                hasPlayedSound = true;
                playMenuSound();
            }
        });
    }

    private void playMenuSound() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.getSoundManager() != null) {
            client.getSoundManager().play(PositionedSoundInstance.master(Sounds.CREACK, 1.0F, 1.0F));
        }
    }
}
