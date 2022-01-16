package de.fynn.mystic.mysticguild.gui.inventory;

import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.gui.item.items.Back;
import de.fynn.mystic.mysticguild.gui.item.items.Close;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.UUID;

public abstract class CustomInventory implements InventoryHolder {

    private GUIItem[] items;

    private final int size;
    private final String title;
    private final Player owner;
    private final CustomInventory previousInv;
    public final UUID ownerUUID;

    public CustomInventory(Player owner, CustomInventory previousInventory, String title,int size){
        this.size = size+9;
        this.title = title;
        items = new GUIItem[size];
        this.owner = owner;
        ownerUUID = owner.getUniqueId();
        previousInv = previousInventory;
        buildInventory(owner);
        openInventory();
    }

    public CustomInventory(Player owner, String title,int size){
        this.size = size+9;
        this.title = title;
        items = new GUIItem[size];
        this.owner = owner;
        ownerUUID = owner.getUniqueId();
        previousInv = null;
        buildInventory(owner);
        openInventory();
    }

    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, size, title);
        fill();
        for (int i = 0; i < size; i++) {
            if(items[i]!=null){
                if(validateItem(items[i])){
                    inventory.setItem(i,items[i].getItemStack());
                }
            }
        }
        if(previousInv!=null){
            setItem(new Back(this), 29);
            setItem(new Close(this), 33);
        }else {
            setItem(new Close(this), 31);
        }
        return inventory;
    }

    private void openInventory(){
        owner.openInventory(getInventory());
    }

    public void setItem(GUIItem item, int pos){
        items[pos] = item;
    }

    public GUIItem getItem(int pos){
        return items[pos];
    }

    private void fill(){
        for (int i = 0; i < size; i++) {
            items[i] = new GUIItem(Material.BLACK_STAINED_GLASS_PANE," ",this);
        }
    }

    public Player getOwner(){
        return owner;
    }

    public CustomInventory getPreviousInv() {
        return previousInv;
    }

    public void openPreviousInventory(){
        if(previousInv!=null){
            previousInv.openInventory();
        }
    }

    public abstract void buildInventory(Player p);

    public abstract boolean validateItem(GUIItem item);

}
