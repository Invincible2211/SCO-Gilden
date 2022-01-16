package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.PageInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import de.fynn.sco.guild.system.messages.MessageManager;
import de.fynn.sco.guild.system.messages.MessageType;
import org.bukkit.Material;

public class Previous extends GUIItem {

    public Previous(PageInventory parent) {
        super(Material.ORANGE_WOOL, MessageManager.getMessage(parent.getOwner().getUniqueId(), MessageType.ITEM.GUI_PREVIOUS), parent);
        addClickAction(player -> {
            parent.previousPage();
            return false;
        });
    }

}