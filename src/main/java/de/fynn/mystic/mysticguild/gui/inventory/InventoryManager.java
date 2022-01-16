package de.fynn.mystic.mysticguild.gui.inventory;

import de.fynn.mystic.mysticguild.gui.inventory.inventorys.*;
import de.fynn.mystic.mysticguild.gui.item.ClickAction;
import org.bukkit.entity.Player;

public class InventoryManager {

    public static  <T> CustomInventory getInventory(Player owner, InventoryType type,T... data){
        switch (type) {
            case NO_GUILD:
                return new NoGuild(owner);
            case MY_GUILD:
                return new MyGuild(owner);
            case ACCEPT_DECLINE:
                return new AcceptDecline(owner, (String) data[0], (ClickAction) data[1], (ClickAction) data[2]);
            case NO_ALIANZ:
                return new NoAlianz(owner);
            case CREATE_ALIANZ_ROLE:
                return new CreateAlianzRole(owner);
            case CREATE_GUILD_ROLE:
                return new CreateGuildRole(owner);
            case DIPLOMATIE:
                return new Diplomatie(owner);
            case GUILD_INFO:
                return new GuildInfo(owner);
            case INVITE_PLAYER:
                return new InvitePlayer(owner);
            case List_ALIANZ_MEMBERS:
                return new ListAlianzMembers(owner);
            case LIST_ALL_ALIANZ:
                return new ListAllAlianz(owner);
            case LIST_GUILD:
                return new ListGuild(owner);
            case MANAGE_ALIANZ_MEMBER:
                return new ManageAlianzMembers(owner);
            case MANAGE_ALIANZ_ROLE:
                return new ManageAlianzRoles(owner);
            case MANAGE_GUILD_ROLES:
                return new ManageGuildRoles(owner);
            case MANAGE_JOIN_REQUESTS:
                return new ManageJoinRequests(owner);
            case MANAGE_PLAYER:
                return new ManageMember(owner);
            case MANAGE_ROLE:
                return new ManageRole(owner);
            case MEMBER_LIST:
                return new ListGuildMembers(owner);
            case MY_ALIANZ:
                return new MyAlianz(owner);
            case MY_INVITES:
                return new MyInvites(owner);
            case MY_JOIN_REQUESTS:
                return new MyJoinRequests(owner);
            case SELECT_ROLE:
                return new SelectRole(owner);
            case SET_STATUS:
                return new SetStatus(owner);
            case WAR_MODE:
                return new WarMode(owner);
            case SEARCH_GUILD:
                return new SearchGuild(owner);
            default:
                return null;
        }
    }

    public enum InventoryType{
        NO_GUILD,MY_GUILD,ACCEPT_DECLINE,NO_ALIANZ,CREATE_ALIANZ_ROLE,CREATE_GUILD_ROLE,DIPLOMATIE,GUILD_INFO,INVITE_PLAYER,
        List_ALIANZ_MEMBERS,LIST_ALL_ALIANZ,LIST_GUILD,MANAGE_ALIANZ_MEMBER,MANAGE_ALIANZ_ROLE,MANAGE_GUILD_ROLES,MANAGE_JOIN_REQUESTS,
        MANAGE_MEMBER,MANAGE_ROLE,MEMBER_LIST,MY_ALIANZ,MY_INVITES,MY_JOIN_REQUESTS,SELECT_ROLE,SET_STATUS,WAR_MODE,SEARCH_GUILD;
    }

}
