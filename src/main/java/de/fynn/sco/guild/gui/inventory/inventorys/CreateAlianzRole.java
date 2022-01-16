package de.fynn.sco.guild.gui.inventory.inventorys;

import de.fynn.sco.guild.community.permission.AlianzPermission;
import de.fynn.sco.guild.community.permission.PermissionManager;
import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.ClickAction;
import de.fynn.sco.guild.gui.item.GUIItem;
import de.fynn.sco.guild.gui.item.items.Down;
import de.fynn.sco.guild.gui.item.items.Up;
import de.fynn.sco.guild.gui.item.items.YesNo;
import de.fynn.sco.guild.system.messages.MessageManager;
import de.fynn.sco.guild.system.messages.MessageType;
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
