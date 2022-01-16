package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.PageInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import de.fynn.sco.guild.system.messages.MessageManager;
import de.fynn.sco.guild.system.messages.MessageType;
import org.bukkit.Material;

public class Next extends GUIItem {

    public Next(PageInventory parent) {
        super(Material.GREEN_WOOL, MessageManager.getMessage(parent.getOwner().getUniqueId(), MessageType.ITEM.GUI_NEXT), parent);
        addClickAction(player -> {
            parent.nextPage();
            return false;
        });
    }

}