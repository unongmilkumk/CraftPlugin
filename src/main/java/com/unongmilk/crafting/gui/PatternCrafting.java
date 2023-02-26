package com.unongmilk.crafting.gui;

import com.unongmilk.crafting.random.Rd;
import com.unongmilk.crafting.recipe.PatternRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternCrafting implements Listener {
    public static ArrayList<PatternRecipe> patternRecipe = new ArrayList<>();

    public static Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(null, 54, "도안 작업대");
        for (int i=0; i < 54 ; i++ ) {
            inv.setItem(i, new ItemStack(Material.IRON_AXE, 1, (short) 64));
        }
        inv.setItem(12, new ItemStack(Material.AIR));
        inv.setItem(13, new ItemStack(Material.AIR));
        inv.setItem(14, new ItemStack(Material.AIR));
        inv.setItem(21, new ItemStack(Material.AIR));
        inv.setItem(22, new ItemStack(Material.AIR));
        inv.setItem(23, new ItemStack(Material.AIR));
        inv.setItem(30, new ItemStack(Material.AIR));
        inv.setItem(31, new ItemStack(Material.AIR));
        inv.setItem(32, new ItemStack(Material.AIR));
        inv.setItem(40, new ItemStack(Material.IRON_AXE, 1, (short) 64));
        return inv;
    }

    @EventHandler
    public void onClickCrafting(InventoryClickEvent event) {
        Inventory inv = event.getClickedInventory();
        if (inv.getTitle().equals(PatternCrafting.getInventory().getTitle())) {
            if (event.getSlot() == 40) {
                patternRecipe.forEach(i -> i.recipe.forEach(s -> {
                    ArrayList<ItemStack> a = new ArrayList<>();
                    a.add(inv.getItem(12));
                    a.add(inv.getItem(13));
                    a.add(inv.getItem(14));
                    a.add(inv.getItem(21));
                    a.add(inv.getItem(22));
                    a.add(inv.getItem(23));
                    a.add(inv.getItem(30));
                    a.add(inv.getItem(31));
                    a.add(inv.getItem(32));
                    if (s.equals(a)) {
                        inv.setItem(12, new ItemStack(Material.AIR));
                        inv.setItem(13, new ItemStack(Material.AIR));
                        inv.setItem(14, new ItemStack(Material.AIR));
                        inv.setItem(21, new ItemStack(Material.AIR));
                        inv.setItem(22, new ItemStack(Material.AIR));
                        inv.setItem(23, new ItemStack(Material.AIR));
                        inv.setItem(30, new ItemStack(Material.AIR));
                        inv.setItem(31, new ItemStack(Material.AIR));
                        inv.setItem(32, new ItemStack(Material.AIR));
                        if (Rd.roll(1, 2) == 1 ) {
                            event.getWhoClicked().getInventory().addItem(i.result);
                        }
                    }
                }));
                event.setCancelled(true);
            }
            if (!new ArrayList<>(Arrays.asList(12, 13, 14, 21, 22, 23, 30, 31, 32, 40)).contains(event.getSlot())) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if (event.getInventory().getTitle().equals(getInventory().getTitle())) {
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(12));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(13));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(14));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(21));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(22));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(23));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(30));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(31));
            event.getPlayer().getInventory().addItem(event.getInventory().getItem(32));
        }
    }
}
