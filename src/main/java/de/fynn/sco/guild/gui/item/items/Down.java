package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class Down extends GUIItem {

    private int value;
    private final int min;
    private Up up;

    public Down(Up upItem, String name, int min, CustomInventory parent) {
        super(Material.ARROW,name, parent);
        up.setDown(this);
        value = upItem.getValue();
        addClickAction(player -> {
            lowerValue();
            return false;
        });
        this.min = min;
    }

    private void sync(){
        up.setValue(value);
        ItemMeta meta = getItemMeta();
        String valueAsString = ""+(value+1);
        meta.setDisplayName(meta.getDisplayName().substring(0,meta.getDisplayName().length()-(2+valueAsString.length()))+"("+value+")");
        setItemMeta(meta);
    }

    private void lowerValue(){
        if(value>min){
            value--;
            sync();
        }
    }

    public void setValue(int value) {
        this.value = value;
        sync();
    }

}