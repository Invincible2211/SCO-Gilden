package de.fynn.mystic.mysticguild.gui.item.items;

import de.fynn.mystic.mysticguild.gui.inventory.PageInventory;
import de.fynn.mystic.mysticguild.gui.item.ClickAction;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Previous extends GUIItem {

    public Previous(PageInventory parent) {
        super(Material.ORANGE_WOOL, MessageManager.getMessage(parent.getOwner().getUniqueId(), MessageType.ITEM.GUI_PREVIOUS), parent);
        addClickAction(player -> {
            parent.previousPage();
            return false;
        });
    }

}