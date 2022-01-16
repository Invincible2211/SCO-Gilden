package de.fynn.mystic.mysticguild.gui.inventory.inventorys;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.inventory.InventoryManager;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.gui.item.items.Close;
import de.fynn.mystic.mysticguild.system.event.listener.ChatListener;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class NoGuild extends CustomInventory {

    public NoGuild(Player player){
        super(player, MessageManager.getMessage(player.getUniqueId(), MessageType.INVENTORY.NO_GUILD),9);
    }

    public NoGuild(Player player, CustomInventory customInventory){
        super(player, customInventory, MessageManager.getMessage(player.getUniqueId(), MessageType.INVENTORY.NO_GUILD),9);
    }

    public void buildInventory(Player p){
        setItem(new GUIItem(Material.BOOK, MessageManager.getMessage(ownerUUID, MessageType.ITEM.MY_INVITES), player -> {
            InventoryManager.getInventory(p, InventoryManager.InventoryType.MY_INVITES);
            return false;
        }, this),1);
        setItem(new GUIItem(Material.BOOK,MessageManager.getMessage(ownerUUID, MessageType.ITEM.MY_JOIN_REQUESTS), player -> {
            InventoryManager.getInventory(p, InventoryManager.InventoryType.MY_JOIN_REQUESTS);
            return false;
        }, this),2);
        setItem(new GUIItem(Material.GREEN_WOOL,MessageManager.getMessage(ownerUUID ,MessageType.ITEM.GUILD_CREATE), player -> {
            player.sendMessage(MessageManager.getMessage(p.getUniqueId(), MessageType.QUESTION.GUILD_NAME));
            ChatListener.getInstance().addPlayer(player, ChatListener.ActionType.CREATE_GUILD);
            return true;
        }, this),4);
        setItem(new GUIItem(Material.COMPARATOR, MessageManager.getMessage(ownerUUID, MessageType.ITEM.SEARCH_GUILD), player -> {
            InventoryManager.getInventory(p, InventoryManager.InventoryType.SEARCH_GUILD);
            return false;
        }, this),6);
        setItem(new Close(this),8);
    }

    @Override
    public boolean validateItem(GUIItem item) {
        return true;
    }

}
