package de.fynn.sco.guild.gui.inventory.inventorys;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.inventory.InventoryPage;
import de.fynn.sco.guild.gui.inventory.PageInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
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
