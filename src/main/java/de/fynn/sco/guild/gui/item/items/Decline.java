package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.ClickAction;
import de.fynn.sco.guild.gui.item.GUIItem;
import de.fynn.sco.guild.system.messages.MessageManager;
import de.fynn.sco.guild.system.messages.MessageType;
import org.bukkit.Material;

public class Decline extends GUIItem {

    public Decline(ClickAction action, CustomInventory parent) {
        super(Material.RED_CONCRETE, MessageManager.getMessage(parent.getOwner().getUniqueId(), MessageType.ITEM.GUI_DECLINE), action, parent);
        addClickAction(action);
    }

}
