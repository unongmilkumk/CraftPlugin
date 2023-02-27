package com.unongmilk.crafting.gui;

import com.unongmilk.crafting.recipe.WeaponRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaponAddCrafting implements Listener {
    public Inventory getInventory(String name, int minlevel) {
        Inventory inv = Bukkit.createInventory(null, 54, "무기 작업대 레시피 추가");
        ItemStack air = new ItemStack(Material.IRON_AXE, 1, (short) 64);
        ItemStack airname = new ItemStack(Material.IRON_AXE, 1, (short) 64);
        ItemStack airminl = new ItemStack(Material.IRON_AXE, 1, (short) 64);
        ItemMeta airm = air.getItemMeta();
        airm.setUnbreakable(true);
        airm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        air.setItemMeta(airm);
        ItemMeta airm1 = airm;
        ItemMeta airm2 = airm;
        airm1.setDisplayName(name);
        airm2.setDisplayName(String.valueOf(minlevel));
        airname.setItemMeta(airm1);
        airminl.setItemMeta(airm2);
        for (int i=0; i < 54 ; i++ ) {
            inv.setItem(i, air);
        }
        inv.setItem(1, airname);
        inv.setItem(2, airminl);
        inv.setItem(12, new ItemStack(Material.AIR));
        inv.setItem(13, new ItemStack(Material.AIR));
        inv.setItem(14, new ItemStack(Material.AIR));
        inv.setItem(21, new ItemStack(Material.AIR));
        inv.setItem(22, new ItemStack(Material.AIR));
        inv.setItem(23, new ItemStack(Material.AIR));
        inv.setItem(25, new ItemStack(Material.AIR));
        inv.setItem(30, new ItemStack(Material.AIR));
        inv.setItem(31, new ItemStack(Material.AIR));
        inv.setItem(32, new ItemStack(Material.AIR));
        inv.setItem(40, air);
        return inv;
    }
    @EventHandler
    public void onClickCrafting(InventoryClickEvent event) {
        Inventory inv = event.getClickedInventory();
        int slot = event.getSlot();
        try {
            if (inv.getTitle().equals("무기 작업대 레시피 추가")) {
                if (slot == 40) {
                    event.setCancelled(true);
                    ArrayList<ItemStack> rcp = new ArrayList<>();
                    rcp.add(event.getClickedInventory().getItem(12));
                    rcp.add(event.getClickedInventory().getItem(13));
                    rcp.add(event.getClickedInventory().getItem(14));
                    rcp.add(event.getClickedInventory().getItem(21));
                    rcp.add(event.getClickedInventory().getItem(22));
                    rcp.add(event.getClickedInventory().getItem(23));
                    rcp.add(event.getClickedInventory().getItem(30));
                    rcp.add(event.getClickedInventory().getItem(31));
                    rcp.add(event.getClickedInventory().getItem(32));
                    WeaponCrafting.weaponRecipe.add(new WeaponRecipe(rcp, event.getClickedInventory().getItem(25),
                            event.getClickedInventory().getItem(0).getItemMeta().getDisplayName(), Integer.parseInt(event.getClickedInventory()
                            .getItem(1).getItemMeta().getDisplayName())));
                    }
            }
            if (!new ArrayList<>(Arrays.asList(12, 13, 14, 21, 22, 23, 25, 30, 31, 32, 40)).contains(slot)) {
                event.setCancelled(true);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
