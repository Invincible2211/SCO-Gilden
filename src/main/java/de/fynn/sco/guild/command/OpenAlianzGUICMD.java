package de.fynn.sco.guild.command;

import de.fynn.sco.guild.community.alianz.AlianzManager;
import de.fynn.sco.guild.community.guild.GuildManager;
import de.fynn.sco.guild.gui.inventory.InventoryManager;
import de.fynn.sco.guild.system.messages.MessageManager;
import de.fynn.sco.guild.system.messages.MessageType;
import de.fynn.sco.guild.system.messages.Prefix;
import de.fynn.sco.guild.system.utils.VariabelManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenAlianzGUICMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length==0){
                if(p.hasPermission(VariabelManager.PERMISSION_OPEN_ALINAZ_GUI)){
                    if(AlianzManager.getInstance().hasALianz(p.getUniqueId())){
                        InventoryManager.getInventory(p, InventoryManager.InventoryType.MY_ALIANZ);
                    }else {
                        if(GuildManager.getInstance().hasGuild(p.getUniqueId())){
                            InventoryManager.getInventory(p, InventoryManager.InventoryType.NO_ALIANZ);
                        }else {
                            p.sendMessage(MessageManager.getMessage(p.getUniqueId(),MessageType.COMMAND.NO_GUILD, Prefix.COMMAND));
                        }
                    }
                }else {
                    p.sendMessage(MessageManager.getMessage(p.getUniqueId(),MessageType.COMMAND.NO_PERMISSION, Prefix.COMMAND));
                }
                return true;
            }else {
                sender.sendMessage(MessageManager.getMessage(p.getUniqueId(),MessageType.COMMAND.COMMAND_NOT_FOUND, Prefix.COMMAND));
                return false;
            }
        }else {
            sender.sendMessage(MessageManager.getMessage(null, MessageType.COMMAND.ONLY_FOR_PLAYERS, Prefix.COMMAND));
            return true;
        }
    }

}
