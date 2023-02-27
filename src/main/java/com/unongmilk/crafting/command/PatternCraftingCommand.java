package com.unongmilk.crafting.command;

import com.unongmilk.crafting.gui.PatternAddCrafting;
import com.unongmilk.crafting.gui.PatternCrafting;
import com.unongmilk.crafting.gui.WeaponAddCrafting;
import com.unongmilk.crafting.recipe.PatternRecipe;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PatternCraftingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!p.isOp()) return false;
        if (args.length == 0) {
            p.openInventory(PatternCrafting.getInventory());
            return true;
        } else if (args.length >= 2) {
            switch (args[0]) {
                case "add" : {
                    int ml = 1;
                    if (args.length == 3) ml = Integer.parseInt(args[2]);
                    p.openInventory(new PatternAddCrafting().getInventory(args[1], ml));
                    break;
                }
                case "remove" : {
                    PatternCrafting.patternRecipe.forEach(s -> {
                        if (s.getName().equals(args[1])) {
                            PatternCrafting.patternRecipe.remove(s);
                        }
                    });
                }
            }
        }
        return true;
    }
}
