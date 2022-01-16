package de.fynn.sco.guild.gui.inventory;

import com.sun.istack.internal.NotNull;
import de.fynn.sco.guild.gui.item.GUIItem;

public class InventoryPage{

    private final GUIItem[] guiItems;

    public InventoryPage(@NotNull GUIItem... items) {
        guiItems = items;
    }

    public GUIItem[] getItems(){
        return guiItems;
    }

}
