package com.unongmilk.crafting.recipe;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PotionRecipe {
    public ArrayList<ItemStack> recipe;
    public ItemStack result;
    public int percentage;
    public String name;

    public PotionRecipe(ArrayList<ItemStack> recipe, ItemStack result, int percentage, String name) {
        this.recipe = recipe;
        this.result = result;
        this.percentage = percentage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ItemStack getResult() {
        return result;
    }

    public int getPercentage() {
        return percentage;
    }

    public ArrayList<ItemStack> getRecipe() {
        return recipe;
    }
}
