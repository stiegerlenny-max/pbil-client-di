package com.example.anubis.module;

import net.minecraft.client.MinecraftClient;

public class SprintModule extends Module {
    public SprintModule() {
        super("AutoSprint", Category.MOVEMENT);
    }

    @Override
    public void onTick(MinecraftClient client) {
        if (client.player != null && !client.player.isSneaking() && client.player.forwardSpeed > 0) {
            client.player.setSprinting(true);
        }
    }
}
