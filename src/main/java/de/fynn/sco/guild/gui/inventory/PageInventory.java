package de.fynn.sco.guild.gui.inventory;

import de.fynn.sco.guild.gui.item.GUIItem;
import de.fynn.sco.guild.gui.item.items.Next;
import de.fynn.sco.guild.gui.item.items.Previous;
import org.bukkit.entity.Player;

public abstract class PageInventory extends CustomInventory {

    private InventoryPage[] pages;
    private int page = 0;

    public PageInventory(Player owner, CustomInventory previousInventory, String title, int rows, InventoryPage... pages) {
        super(owner,previousInventory, title,(rows*9)+9);
        this.pages = pages;
        setItem(new Previous(this),(rows*9));
        setItem(new Next(this),(rows*9)+8);
    }

    public PageInventory(Player owner, String title, int rows, InventoryPage... pages) {
        super(owner, title,(rows*9)+9);
        this.pages = pages;
        setItem(new Previous(this),(rows*9));
        setItem(new Next(this),(rows*9)+8);
    }

    public void nextPage(){
        page++;
        refreshPage();
    }

    public void previousPage(){
        page--;
        refreshPage();
    }

    private void refreshPage() {
        GUIItem[] items = pages[page].getItems();
        for (int i = 0; i < 9; i++) {
            setItem(items[i],i);
        }
        if(!hasPreviousPage())setItem(null,9);
        if(!hasNextPage())setItem(null,17);
    }

    public boolean hasNextPage(){
        return page+1<pages.length;
    }

    public boolean hasPreviousPage(){
        return page>0;
    }

    @Override
    public abstract void buildInventory(Player p);

    @Override
    public abstract boolean validateItem(GUIItem item);
}
