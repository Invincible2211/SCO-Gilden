package de.fynn.sco.guild.gui.inventory.inventorys;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.inventory.InventoryPage;
import de.fynn.sco.guild.gui.inventory.PageInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import org.bukkit.entity.Player;

public class SearchAlianz extends PageInventory {


    public SearchAlianz(Player owner, String title, int rows, InventoryPage... pages) {
        super(owner, title, rows, pages);
    }

    public SearchAlianz(Player owner, CustomInventory previousInventory, String title, int rows, InventoryPage... pages) {
        super(owner, previousInventory, title, rows, pages);
    }

    @Override
    public void buildInventory(Player p) {

    }

    @Override
    public boolean validateItem(GUIItem item) {
        return false;
    }

}
