package com.example.anubis;

import com.example.anubis.gui.AnubisClickGui;
import com.example.anubis.module.Module;
import com.example.anubis.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AnubisClient implements ClientModInitializer {
    public static final ModuleManager MODULE_MANAGER = new ModuleManager();
    private static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.anubis.menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.anubis.general"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            while (openGuiKey.wasPressed()) {
                client.setScreen(new AnubisClickGui());
            }

            for (Module module : MODULE_MANAGER.getModules()) {
                if (module.isEnabled()) {
                    module.onTick(client);
                }
            }
        });

        HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
            MODULE_MANAGER.onRenderHud(drawContext);
        });
    }
}
