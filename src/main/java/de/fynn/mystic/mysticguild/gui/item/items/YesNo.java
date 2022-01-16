package de.fynn.mystic.mysticguild.gui.item.items;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.ClickAction;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class YesNo extends GUIItem {

    private boolean state = false;

    public YesNo(String name, CustomInventory parent) {
        super(Material.RED_WOOL,name, parent);
        addClickAction(player -> {
            switchState();
            return false;
        });
    }

    public void switchState(){
        state=!state;
        setType(state?Material.GREEN_WOOL:Material.RED_WOOL);
    }

    public boolean getState() {
        return state;
    }
}