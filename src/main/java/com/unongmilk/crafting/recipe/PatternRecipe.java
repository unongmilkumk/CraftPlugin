package com.unongmilk.crafting.recipe;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PatternRecipe {
    public ArrayList<ItemStack> recipe;
    public ItemStack result;
    public String name;

    public PatternRecipe(ArrayList<ItemStack> recipe, ItemStack result, String name) {
        this.recipe = recipe;
        this.result = result;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ItemStack getResult() {
        return result;
    }

    public ArrayList<ItemStack> getRecipe() {
        return recipe;
    }
}
