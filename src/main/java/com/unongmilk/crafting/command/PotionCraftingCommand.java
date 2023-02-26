package com.unongmilk.crafting.command;

import com.unongmilk.crafting.gui.PotionCrafting;
import com.unongmilk.crafting.gui.WeaponCrafting;
import com.unongmilk.crafting.recipe.PotionRecipe;
import com.unongmilk.crafting.recipe.WeaponRecipe;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PotionCraftingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!p.isOp()) return false;
        if (args.length == 0) {
            p.openInventory(PotionCrafting.getInventory());
            return true;
        } else if (args.length == 2) {
            switch (args[0]) {
                case "add" : {
                    ArrayList<ItemStack> rcp = new ArrayList<>();
                    rcp.add(p.getInventory().getItem(0));
                    rcp.add(p.getInventory().getItem(1));
                    rcp.add(p.getInventory().getItem(2));
                    rcp.add(p.getInventory().getItem(3));
                    rcp.add(p.getInventory().getItem(4));
                    rcp.add(p.getInventory().getItem(5));
                    rcp.add(p.getInventory().getItem(6));
                    rcp.add(p.getInventory().getItem(7));
                    rcp.add(p.getInventory().getItem(8));

                    PotionCrafting.potionRecipe.add(new PotionRecipe(rcp, p.getInventory().getItemInOffHand(), args[1]));
                }
                case "remove" : {
                    PotionCrafting.potionRecipe.forEach(s -> {
                        if (s.getName().equals(args[1])) {
                            PotionCrafting.potionRecipe.remove(s);
                        }
                    });
                }
            }
        }
        return true;
    }
}
