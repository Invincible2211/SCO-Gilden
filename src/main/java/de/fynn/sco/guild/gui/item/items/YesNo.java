package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import org.bukkit.Material;

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