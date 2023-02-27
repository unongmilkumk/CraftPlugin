package com.unongmilk.crafting;

import com.unongmilk.crafting.command.PatternCraftingCommand;
import com.unongmilk.crafting.command.PotionCraftingCommand;
import com.unongmilk.crafting.command.WeaponCraftingCommand;
import com.unongmilk.crafting.gui.PatternCrafting;
import com.unongmilk.crafting.gui.PotionCrafting;
import com.unongmilk.crafting.gui.WeaponCrafting;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().info("Enable");

        getCommand("craftpotion").setExecutor(new PotionCraftingCommand());
        getCommand("craftweapon").setExecutor(new WeaponCraftingCommand());
        getCommand("craftpattern").setExecutor(new PatternCraftingCommand());

        getServer().getPluginManager().registerEvents(new PatternCrafting(), this);
        getServer().getPluginManager().registerEvents(new PotionCrafting(), this);
        getServer().getPluginManager().registerEvents(new WeaponCrafting(), this);
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("Disable");
    }
}
