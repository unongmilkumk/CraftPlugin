package com.unongmilk.crafting.gui;

import com.unongmilk.crafting.random.Rd;
import com.unongmilk.crafting.recipe.WeaponRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class WeaponCrafting implements Listener {
    public static ArrayList<WeaponRecipe> weaponRecipe = new ArrayList<>();

    public static Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(null, 54, "무기 작업대");
        inv.forEach(s -> {
            s.setType(Material.IRON_AXE);
            s.setDurability((short) 64);
        });
        inv.setItem(1, new ItemStack(Material.AIR));
        inv.setItem(2, new ItemStack(Material.AIR));
        inv.setItem(3, new ItemStack(Material.AIR));
        inv.setItem(7, new ItemStack(Material.IRON_AXE, 1, (short) 64));
        return inv;
    }

    @EventHandler
    public void onClickCrafting(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv.getTitle().equals(WeaponCrafting.getInventory().getTitle())) {
            if (event.getSlot() == 7) {
                weaponRecipe.forEach(i -> i.recipe.forEach(s -> {
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
                        if (Rd.roll(1, Math.round(1 / (i.getPercentage() / 100))) == 1 ) {
                            event.getWhoClicked().getInventory().addItem(i.result);
                        }
                    }
                }));
            } else if (event.getSlot() < 54) {
                event.setCancelled(true);
            }
        }
    }
}
