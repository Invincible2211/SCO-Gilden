package de.fynn.mystic.mysticguild.gui.inventory.inventorys;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.entity.Player;

public class ManageAttributes extends CustomInventory {


    public ManageAttributes(Player owner, CustomInventory previousInventory, String title, int size) {
        super(owner, previousInventory, title, size);
    }

    public ManageAttributes(Player owner, String title, int size) {
        super(owner, title, size);
    }

    @Override
    public void buildInventory(Player p) {

    }

    @Override
    public boolean validateItem(GUIItem item) {
        return false;
    }
}
