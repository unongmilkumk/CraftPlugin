package com.unongmilk.crafting;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().info("Enable");
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("Disable");
    }
}
