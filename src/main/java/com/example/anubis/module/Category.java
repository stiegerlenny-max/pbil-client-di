package com.example.anubis.module;

public enum Category {
    MOVEMENT("Movement"),
    RENDER("Render"),
    HUD("HUD");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
