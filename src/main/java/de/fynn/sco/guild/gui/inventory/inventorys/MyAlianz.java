package de.fynn.sco.guild.gui.inventory.inventorys;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import org.bukkit.entity.Player;

public class MyAlianz extends CustomInventory {


    public MyAlianz(Player owner, CustomInventory previousInventory, String title, int size) {
        super(owner, previousInventory, title, size);
    }

    public MyAlianz(Player owner, String title, int size) {
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
