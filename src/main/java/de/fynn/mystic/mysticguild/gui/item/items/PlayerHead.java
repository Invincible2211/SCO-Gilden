package de.fynn.mystic.mysticguild.gui.item.items;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.ClickAction;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class PlayerHead extends GUIItem {

    private UUID uuid;

    public PlayerHead(String displayname, UUID uuid, ClickAction action, CustomInventory parent) {
        super(Material.PLAYER_HEAD, parent);
        this.uuid = uuid;
        if(Bukkit.getPlayer(uuid)!=null){
            SkullMeta skullMeta = (SkullMeta) getItemMeta();
            skullMeta.setOwningPlayer(Bukkit.getPlayer(uuid));
            setItemMeta(skullMeta);
        }
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(displayname);
        addClickAction(action);
    }

    public UUID getUuid() {
        return uuid;
    }

}
