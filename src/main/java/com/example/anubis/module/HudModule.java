package com.example.anubis.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new SprintModule());
        modules.add(new FullbrightModule());
        modules.add(new HudModule());
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getByCategory(Category category) {
        return modules.stream().filter(m -> m.getCategory() == category).toList();
    }

    public void onRenderHud(DrawContext context) {
        MinecraftClient client = MinecraftClient.getInstance();
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onRenderHud(context, client);
            }
        }
    }
}
