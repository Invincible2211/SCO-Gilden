package de.fynn.mystic.mysticguild.gui.inventory.inventorys;

import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.ClickAction;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.gui.item.items.Accept;
import de.fynn.mystic.mysticguild.gui.item.items.Decline;
import org.bukkit.entity.Player;

public class AcceptDecline extends CustomInventory {

    private ClickAction accept;
    private ClickAction decline;

    public AcceptDecline(Player owner, String title, ClickAction accept, ClickAction decline) {
        super(owner, title, 9);
        this.accept = accept;
        this.decline =decline;
    }

    public AcceptDecline(Player owner, CustomInventory previous, String title, ClickAction accept, ClickAction decline) {
        super(owner, previous, title, 9);
        this.accept = accept;
        this.decline =decline;
    }

    @Override
    public void buildInventory(Player p) {
        setItem(new Accept(accept, this), 2);
        setItem(new Decline(decline, this), 6);
    }

    @Override
    public boolean validateItem(GUIItem item) {
        return true;
    }

}
