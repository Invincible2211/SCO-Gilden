package de.fynn.mystic.mysticguild.gui.inventory.inventorys;

import de.fynn.mystic.mysticguild.community.permission.AlianzPermission;
import de.fynn.mystic.mysticguild.community.permission.PermissionManager;
import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.ClickAction;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.gui.item.items.Down;
import de.fynn.mystic.mysticguild.gui.item.items.Up;
import de.fynn.mystic.mysticguild.gui.item.items.YesNo;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreateAlianzRole extends CustomInventory {

    public CreateAlianzRole(Player owner) {
        super(owner, MessageManager.getMessage(owner.getUniqueId(), MessageType.INVENTORY.CREATE_ALIANZ_ROLE),27);
    }

    public CreateAlianzRole(Player owner, CustomInventory previous) {
        super(owner, previous, MessageManager.getMessage(owner.getUniqueId(), MessageType.INVENTORY.CREATE_ALIANZ_ROLE),27);
    }

    @Override
    public void buildInventory(Player p) {
        setItem(new YesNo(MessageManager.getMessage(ownerUUID,MessageType.PERMISSION.MANAGE_ALIANZ),this).addPermissions(AlianzPermission.ALIANZ), 0);

        setItem(new YesNo(MessageManager.getMessage(ownerUUID,MessageType.PERMISSION.MANAGE_ALINAZ_MEMBER),this).addPermissions(AlianzPermission.MEMBERS), 9);

        Up up = new Up(MessageManager.getMessage(ownerUUID, MessageType.ITEM.ALIANZ_ROLE_INCREASE_PRIORITY),99,this);
        setItem(up, 17);
        setItem(new Down(up, MessageManager.getMessage(ownerUUID, MessageType.ITEM.ALIANZ_ROLE_DECREASE_PRIORITY),0,this), 26);

        setItem(new GUIItem(Material.GREEN_WOOL, MessageManager.getMessage(ownerUUID,MessageType.ITEM.ALIANZ_ROLE_SAVE), new ClickAction(){

            @Override
            public boolean execute(Player player) {

                return false;
            }
        }, this), 18);
    }

    private void buildSecondPage(Player p){

    }

    @Override
    public boolean validateItem(GUIItem item) {
        if(PermissionManager.getInstance().hasPermissions(ownerUUID, PermissionManager.KEY.ALIANZ,item.getNeededPermissions())){
            return true;
        }
        item.removeAllCLickActions();
        return false;
    }
}
