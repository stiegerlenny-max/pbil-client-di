package com.example.anubis.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class HudModule extends Module {
    public HudModule() {
        super("Coords HUD", Category.HUD);
    }

    @Override
    public void onRenderHud(DrawContext context, MinecraftClient client) {
        if (client.player == null) return;
        int x = (int) client.player.getX();
        int y = (int) client.player.getY();
        int z = (int) client.player.getZ();
        String text = "XYZ: " + x + " / " + y + " / " + z;
        context.fill(8, 8, 12 + client.textRenderer.getWidth(text), 22, 0x9012141A);
        context.drawText(client.textRenderer, text, 10, 11, 0xFF38BDF8, true);
    }
}
