package de.fynn.sco.guild.gui.item.items;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class Up extends GUIItem {

    private int value = 0;
    private final int max;
    private Down down;

    public Up(String name, int max, CustomInventory parent) {
        super(Material.ARROW,name, parent);
        addClickAction(player -> {
            increaseValue();
            return false;
        });
        this.max = max;
    }

    public Up(String name, int max, int value, CustomInventory parent) {
        super(Material.ARROW,name, parent);
        addClickAction(player -> {
            increaseValue();
            return false;
        });
        this.value = value;
        this.max = max;
    }

    public int getValue(){
        return value;
    }

    private void increaseValue(){
        if(value<max){
            value++;
            sync();
        }
    }

    private void sync(){
        down.setValue(value);
        ItemMeta meta = getItemMeta();
        String valueAsString = ""+(value-1);
        meta.setDisplayName(meta.getDisplayName().substring(0,meta.getDisplayName().length()-(2+valueAsString.length()))+"("+value+")");
        setItemMeta(meta);
    }

    public void setDown(Down down) {
        this.down = down;
    }

    public void setValue(int value) {
        this.value = value;
        sync();
    }

}