package de.fynn.mystic.mysticguild.gui.inventory.inventorys;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.entity.Player;

public class ManageRole extends CustomInventory {


    public ManageRole(Player owner, CustomInventory previousInventory, String title, int size) {
        super(owner, previousInventory, title, size);
    }

    public ManageRole(Player owner, String title, int size) {
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
