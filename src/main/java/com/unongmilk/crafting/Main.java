package com.unongmilk.crafting;

import com.unongmilk.crafting.command.PatternCraftingCommand;
import com.unongmilk.crafting.command.PotionCraftingCommand;
import com.unongmilk.crafting.command.WeaponCraftingCommand;
import com.unongmilk.crafting.gui.PatternCrafting;
import com.unongmilk.crafting.gui.PotionCrafting;
import com.unongmilk.crafting.gui.WeaponCrafting;
import com.unongmilk.crafting.recipe.PatternRecipe;
import com.unongmilk.crafting.recipe.PotionRecipe;
import com.unongmilk.crafting.recipe.WeaponRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

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

        if (getConfig().contains("data")) {
            getConfig().getConfigurationSection("data").getKeys(false).forEach(key -> {
                List<WeaponRecipe> content = (List<WeaponRecipe>)getConfig().get("data." + key);
                WeaponCrafting.weaponRecipe.addAll(content);
            });
        }
        if (getConfig().contains("data1")) {
            getConfig().getConfigurationSection("data1").getKeys(false).forEach(key -> {
                List<PotionRecipe> content = (List<PotionRecipe>)getConfig().get("data1." + key);
                PotionCrafting.potionRecipe.addAll(content);
            });
        }
        if (getConfig().contains("data2")) {
            getConfig().getConfigurationSection("data2").getKeys(false).forEach(key -> {
                List<PatternRecipe> content = (List<PatternRecipe>)getConfig().get("data2." + key);
                PatternCrafting.patternRecipe.addAll(content);
            });
        }
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("Disable");
    }
}
