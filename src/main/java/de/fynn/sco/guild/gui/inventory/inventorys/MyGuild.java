package de.fynn.sco.guild.gui.inventory.inventorys;

import de.fynn.sco.guild.community.permission.GuildPermission;
import de.fynn.sco.guild.community.permission.PermissionManager;
import de.fynn.sco.guild.gui.inventory.CustomInventory;
import de.fynn.sco.guild.gui.item.GUIItem;
import de.fynn.sco.guild.system.messages.MessageManager;
import de.fynn.sco.guild.system.messages.MessageType;
import org.bukkit.entity.Player;

public class MyGuild extends CustomInventory {

    private static final PermissionManager permissionManager = PermissionManager.getInstance();

    public MyGuild(Player player) {
        super(player, MessageManager.getMessage(player.getUniqueId(), MessageType.INVENTORY.MY_GUILD), 9 +
                (permissionManager.hasPermissions(player.getUniqueId(), PermissionManager.KEY.GUILD, GuildPermission.GUILD) ? 9 : 0) +
                (permissionManager.hasPermission(player.getUniqueId(), PermissionManager.KEY.GUILD, GuildPermission.MEMBERS) ? 9 : 0)
        );
    }

    public MyGuild(Player player, CustomInventory customInventory) {
        super(player, customInventory, MessageManager.getMessage(player.getUniqueId(), MessageType.INVENTORY.MY_GUILD), 9 +
                (permissionManager.hasPermissions(player.getUniqueId(), PermissionManager.KEY.GUILD, GuildPermission.GUILD) ? 9 : 0) +
                (permissionManager.hasPermission(player.getUniqueId(), PermissionManager.KEY.GUILD, GuildPermission.MEMBERS) ? 9 : 0)
        );
    }

    @Override
    public void buildInventory(Player p) {

    }

    @Override
    public boolean validateItem(GUIItem item) {
        return permissionManager.hasPermissions(getOwner().getUniqueId(), PermissionManager.KEY.GUILD, item.getNeededPermissions());
    }

}
