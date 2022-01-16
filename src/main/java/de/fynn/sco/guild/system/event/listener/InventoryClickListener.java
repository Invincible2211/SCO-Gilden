package de.fynn.sco.guild.system.event.listener;

import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.ClickAction;
import de.fynn.sco.guild.gui.item.GUIItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getView().getTopInventory().getHolder() instanceof CustomInventory){
            event.setCancelled(true);
            if(event.getWhoClicked() instanceof Player){
                Player player = (Player) event.getWhoClicked();
                ItemStack itemStack = event.getCurrentItem();
                if(itemStack == null || itemStack.getType() == Material.AIR){
                    return;
                }
                CustomInventory customInventory = (CustomInventory) event.getView().getTopInventory().getHolder();
                GUIItem item = customInventory.getItem(event.getRawSlot());
                if(item == null){
                    return;
                }
                boolean closed = false;
                for (ClickAction action:
                        item.getActions()) {
                    closed = action.execute(player);
                }
                if(closed) event.getView().close();
            }
        }
    }

}
