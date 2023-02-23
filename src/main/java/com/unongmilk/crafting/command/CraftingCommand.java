package com.unongmilk.crafting.command;

import com.unongmilk.crafting.gui.Crafting;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.openInventory(Crafting.getInventory());
        return true;
    }
}
