package de.fynn.mystic.mysticguild.community.alianz;

import de.fynn.mystic.mysticguild.community.OnlineCommunity;
import de.fynn.mystic.mysticguild.community.permission.Permission;
import de.fynn.mystic.mysticguild.community.role.Role;
import de.fynn.mystic.mysticguild.system.database.DBManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Alianz extends OfflineAlianz implements OnlineCommunity {

    private final HashMap<UUID,String> members = new HashMap<>();
    private final List<UUID> onlineMembers = new ArrayList<>();

    private final HashMap<UUID,String> bannedMembers = new HashMap<>();
    private final HashMap<UUID,String> invitedMembers = new HashMap<>();
    private final HashMap<UUID,String> joinRequest = new HashMap<>();

    private Role defaultRole;

    public Alianz(UUID uuid){
        super(uuid);
        defaultRole = dbManager.getDefaultRole();
    }

    public Alianz(UUID alianz, UUID owner, String name){
        super(alianz,owner,name);
        defaultRole = dbManager.getDefaultRole();
    }


    @Override
    public void addMember(UUID uuid, String displayname) {
        members.put(uuid, displayname);
        dbManager.addMember(uuid, displayname);
    }

    @Override
    public void removeMember(UUID uuid) {
        members.remove(uuid);
        dbManager.removeMember(uuid);
    }


    @Override
    public Role getDefaultRole() {
        return defaultRole;
    }

    @Override
    public void setDefaultRole(Role role) {
        defaultRole = role;
    }

    @Override
    public Role getMemberRole(UUID uuid) {
        return getRoleManager().getRole(uuid);
    }

    @Override
    public void setRole(UUID uuid, String role) {
        getRoleManager().setRole(uuid,role);
    }

    @Override
    public boolean hasPermission(UUID uuid, Permission permission) {
        return getRoleManager().getRole(uuid).hasPermission(permission);
    }

    @Override
    public boolean hasHigherPriority(UUID uuid1, UUID uuid2) {
        return getRoleManager().getRole(uuid1).getPriority() > getRoleManager().getRole(uuid1).getPriority();
    }

    @Override
    public void acceptJoinRequest(UUID uuid) {
        addMember(uuid,joinRequest.remove(uuid));
        dbManager.removeJoinRequest(uuid);
    }

    @Override
    public void declineJoinRequest(UUID uuid) {
        joinRequest.remove(uuid);
        dbManager.removeJoinRequest(uuid);
    }

    @Override
    public void banMember(UUID uuid, String displayname) {
        bannedMembers.put(uuid,displayname);
        dbManager.addBan(uuid,displayname);
    }

    @Override
    public void unbanMember(UUID uuid) {
        bannedMembers.remove(uuid);
        dbManager.removeBan(uuid);
    }

    @Override
    public void inviteMember(UUID uuid, String displayname) {
        invitedMembers.put(uuid, displayname);
        dbManager.addInvite(uuid, displayname);
    }

    @Override
    public void cancelInvite(UUID uuid) {
        invitedMembers.remove(uuid);
        dbManager.removeInvite(uuid);
    }

    @Override
    public OfflineAlianz toOfflineCommunity() {
        return new OfflineAlianz(getUuid());
    }

    @Override
    public void insertInDB() {
        DBManager.getInstance().addAlianz(this);
    }

    @Override
    public List<UUID> getOnlineMembers() {
        return onlineMembers;
    }

    @Override
    public void addOnlineMeber(UUID uuid) {
        onlineMembers.add(uuid);
    }

    @Override
    public void removeOnlineMember(UUID uuid) {
        onlineMembers.remove(uuid);
    }

}
