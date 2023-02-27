package com.unongmilk.crafting.command;

import com.unongmilk.crafting.gui.PotionAddCrafting;
import com.unongmilk.crafting.gui.PotionCrafting;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PotionCraftingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!p.isOp()) return false;
        if (args.length == 0) {
            p.openInventory(PotionCrafting.getInventory());
            return true;
        } else if (args.length >= 2) {
            switch (args[0]) {
                case "add" : {
                    int ml = 1;
                    if (args.length == 3) ml = Integer.parseInt(args[2]);
                    p.openInventory(new PotionAddCrafting().getInventory(args[1], ml));
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
