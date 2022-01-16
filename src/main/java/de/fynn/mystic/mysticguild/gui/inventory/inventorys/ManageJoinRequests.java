package de.fynn.mystic.mysticguild.gui.inventory.inventorys;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.inventory.InventoryPage;
import de.fynn.mystic.mysticguild.gui.inventory.PageInventory;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.entity.Player;

public class ManageJoinRequests extends PageInventory {


    public ManageJoinRequests(Player owner, CustomInventory previousInventory, String title, int rows, InventoryPage... pages) {
        super(owner, previousInventory, title, rows, pages);
    }

    public ManageJoinRequests(Player owner, String title, int rows, InventoryPage... pages) {
        super(owner, title, rows, pages);
    }

    @Override
    public void buildInventory(Player p) {

    }

    @Override
    public boolean validateItem(GUIItem item) {
        return false;
    }
}
