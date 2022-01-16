package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import org.bukkit.Material;

public class Close extends GUIItem {

    public Close(CustomInventory parent) {
        super(Material.BARRIER,parent);
        addClickAction(player -> true);
    }

}