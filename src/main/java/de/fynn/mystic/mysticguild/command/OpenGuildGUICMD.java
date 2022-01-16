package de.fynn.mystic.mysticguild.command;

import de.fynn.mystic.mysticguild.community.guild.GuildManager;
import de.fynn.mystic.mysticguild.gui.inventory.InventoryManager;
import de.fynn.mystic.mysticguild.gui.inventory.inventorys.NoGuild;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import de.fynn.mystic.mysticguild.system.messages.Prefix;
import de.fynn.mystic.mysticguild.system.utils.VariabelManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenGuildGUICMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length==0){
                if(p.hasPermission(VariabelManager.PERMISSION_OPEN_GUILD_GUI)){
                    if(GuildManager.getInstance().hasGuild(p.getUniqueId())){
                        InventoryManager.getInventory(p, InventoryManager.InventoryType.MY_GUILD);
                    }else {
                        InventoryManager.getInventory(p, InventoryManager.InventoryType.NO_GUILD);
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
            sender.sendMessage(MessageManager.getMessage(null,MessageType.COMMAND.ONLY_FOR_PLAYERS, Prefix.COMMAND));
            return true;
        }
    }

}
