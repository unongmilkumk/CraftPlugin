package com.unongmilk.crafting.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.*;

public class Crafting implements Listener {
    public static HashMap<ArrayList<ItemStack>, ItemStack> recipe = new HashMap<>();
    public static HashMap<ItemStack, Double> percentage = new HashMap<>();

    public static Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(null, 9, "무기 작업대");
        inv.forEach(s -> {
            s.setType(Material.IRON_AXE);
            s.setDurability((short) 64);
        });
        inv.setItem(1, new ItemStack(Material.AIR));
        inv.setItem(2, new ItemStack(Material.AIR));
        inv.setItem(3, new ItemStack(Material.AIR));
        inv.setItem(7, new ItemStack(Material.AIR));
        return inv;
    }

    @EventHandler
    public void onClickCrafting(InventoryClickEvent event) {
        if (event.getInventory().getTitle().equals(Crafting.getInventory().getTitle())) {

            if (event.getSlot() == 7) {
                if (event.getCurrentItem().getType() != Material.AIR) {
                    percentage.get(event.getCurrentItem());
                }
            } else if (Objects.equals(new int[]{1, 2, 3}, event.getSlot())) {
                recipe.forEach((s, i) -> {
                    int a = 0;
                    if (s.get(0) == event.getInventory().getItem(1)) {
                        a += 1;
                    }
                    if (s.get(1) == event.getInventory().getItem(2)) {
                        a += 1;
                    }
                    if (s.get(2) == event.getInventory().getItem(3)) {
                        a += 1;
                    }
                    if (a == 3) {
                        event.getInventory().setItem(7, i);
                    }
                });
            } else {
                event.setCancelled(true);
            }
        }
    }
}
