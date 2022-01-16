package de.fynn.mystic.mysticguild.gui.item.items;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.ClickAction;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Decline extends GUIItem {

    public Decline(ClickAction action, CustomInventory parent) {
        super(Material.RED_CONCRETE, MessageManager.getMessage(parent.getOwner().getUniqueId(), MessageType.ITEM.GUI_DECLINE), action, parent);
        addClickAction(action);
    }

}
