package de.fynn.mystic.mysticguild.gui.inventory;

import com.sun.istack.internal.NotNull;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;

public class InventoryPage{

    private final GUIItem[] guiItems;

    public InventoryPage(@NotNull GUIItem... items) {
        guiItems = items;
    }

    public GUIItem[] getItems(){
        return guiItems;
    }

}
