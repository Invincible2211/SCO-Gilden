package de.fynn.mystic.mysticguild.gui.item.items;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Back extends GUIItem {

    public Back(CustomInventory parent) {
        super(Material.RED_WOOL, MessageManager.getMessage(parent.getOwner().getUniqueId(), MessageType.ITEM.GUI_BACK), parent);
        addClickAction(player -> {
            parent.openPreviousInventory();
            return false;
        });
    }

}
