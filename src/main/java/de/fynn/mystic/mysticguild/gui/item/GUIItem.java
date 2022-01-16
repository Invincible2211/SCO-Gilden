package de.fynn.mystic.mysticguild.gui.item;

import de.fynn.mystic.mysticguild.community.permission.Permission;
import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUIItem extends ItemStack{

    private final ItemStack itemStack;
    private CustomInventory customInventory;
    private final List<ClickAction> actions = new ArrayList<>();
    private Permission[] neededPermissions = null;

    public GUIItem(Material material, CustomInventory inv, Permission... permissions){
        itemStack = new ItemStack(material);
        customInventory = inv;
        neededPermissions = permissions;
    }

    public GUIItem(Material material, String name, CustomInventory inv, Permission... permissions){
        itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        customInventory = inv;
        neededPermissions = permissions;
    }

    public GUIItem(Material material, String name, ClickAction action, CustomInventory inv, Permission... permissions){
        itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        addClickAction(action);
        customInventory = inv;
        neededPermissions = permissions;
    }

    public void addClickAction(ClickAction action){
        actions.add(action);
    }

    public void removeClickAction(ClickAction action){
        actions.remove(action);
    }

    public List<ClickAction> getActions(){
        return actions;
    }

    public ItemStack getItemStack(){
        return itemStack;
    }

    public ItemMeta getItemMeta(){
        return itemStack.getItemMeta();
    }

    public boolean setItemMeta(ItemMeta meta){
        return itemStack.setItemMeta(meta);
    }

    public CustomInventory getCustomInventory() {
        return customInventory;
    }

    public Permission[] getNeededPermissions() {
        return neededPermissions;
    }

    public void removeAllCLickActions(){
        actions.clear();
    }

    public GUIItem addPermissions(Permission... permissions){
        if(neededPermissions!=null){
            List<Permission> perms = Arrays.asList(neededPermissions);
            perms.addAll(Arrays.asList(permissions));
            neededPermissions = perms.toArray(new Permission[0]);
        }else {
            neededPermissions = permissions;
        }
        return this;
    }

}
