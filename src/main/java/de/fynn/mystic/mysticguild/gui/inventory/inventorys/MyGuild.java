package de.fynn.mystic.mysticguild.gui.inventory.inventorys;

import de.fynn.mystic.mysticguild.community.permission.GuildPermission;
import de.fynn.mystic.mysticguild.community.permission.PermissionManager;
import de.fynn.mystic.mysticguild.gui.inventory.CustomInventory;
import de.fynn.mystic.mysticguild.gui.item.GUIItem;
import de.fynn.mystic.mysticguild.system.messages.MessageManager;
import de.fynn.mystic.mysticguild.system.messages.MessageType;
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
