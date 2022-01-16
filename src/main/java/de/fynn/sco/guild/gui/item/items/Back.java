package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import de.fynn.sco.guild.system.messages.MessageManager;
import de.fynn.sco.guild.system.messages.MessageType;
import org.bukkit.Material;

public class Back extends GUIItem {

    public Back(CustomInventory parent) {
        super(Material.RED_WOOL, MessageManager.getMessage(parent.getOwner().getUniqueId(), MessageType.ITEM.GUI_BACK), parent);
        addClickAction(player -> {
            parent.openPreviousInventory();
            return false;
        });
    }

}
