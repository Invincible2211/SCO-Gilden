package de.fynn.sco.guild.community;

import de.fynn.sco.guild.community.permission.Permission;
import de.fynn.sco.guild.community.role.Role;

import java.util.List;
import java.util.UUID;

public interface OnlineCommunity {

    public void addMember(UUID uuid, String displayname);

    public void removeMember(UUID uuid);

    public List<UUID> getMembers();

    public Role getDefaultRole();

    public void setDefaultRole(Role role);

    public Role getMemberRole(UUID uuid);

    public void setRole(UUID uuid, String role);

    public boolean hasPermission(UUID uuid, Permission permission);

    public boolean hasHigherPriority(UUID uuid1, UUID uuid2);

    public void acceptJoinRequest(UUID uuid);

    public void declineJoinRequest(UUID uuid);

    public void banMember(UUID uuid, String displayname);

    public void unbanMember(UUID uuid);

    public void inviteMember(UUID uuid, String displayname);

    public void cancelInvite(UUID uuid);

    public OfflineCommunity toOfflineCommunity();

    public void insertInDB();

    public List<UUID> getOnlineMembers();

    public void addOnlineMeber(UUID uuid);

    public void removeOnlineMember(UUID uuid);

}
