package de.fynn.sco.guild.system.database;

import de.fynn.sco.guild.community.OfflineCommunity;
import de.fynn.sco.guild.community.Status;
import de.fynn.sco.guild.community.role.Role;
import de.fynn.sco.guild.system.file.ConfigHandler;

import java.util.List;
import java.util.UUID;

public abstract class CommunityDBManager {

    public CommunityDBManager(OfflineCommunity parent){
        setup(parent.getUuid());
    }

    public final void setup(UUID uuid){
        DBConnector.getInstance().executeSQL("CREATE TABLE IF NOT EXISTS "+ ConfigHandler.getDBSchema()+"."+uuid.toString()+";");
        DBConnector.getInstance().executeSQL("CREATE TABLE IF NOT EXISTS "+ ConfigHandler.getDBSchema()+"."+uuid.toString()+".banned;");
        DBConnector.getInstance().executeSQL("CREATE TABLE IF NOT EXISTS "+ ConfigHandler.getDBSchema()+"."+uuid.toString()+".invited;");
        DBConnector.getInstance().executeSQL("CREATE TABLE IF NOT EXISTS "+ ConfigHandler.getDBSchema()+"."+uuid.toString()+".joinRequests;");
    }

    public abstract void addMember(UUID uuid, String displayname);

    public abstract void removeMember(UUID uuid);

    public abstract void rename(String name);

    public abstract void setPrefix(String prefix);

    public abstract void setLevel(int level);

    public abstract void setXP(double xp);

    public abstract void setStatus(Status status);

    public abstract String getName();

    public abstract String getDisplayname(UUID uuid);

    public abstract String getPrefix();

    public abstract UUID getOwner();

    public abstract int getLevel();

    public abstract double getXP();

    public abstract List<UUID> getMembers();

    public abstract Status getStatus();

    public abstract void addInvite(UUID uuid, String displayname);

    public abstract boolean isInvited(UUID uuid);

    public abstract void addBan(UUID uuid, String displayname);

    public abstract void addJoinRequest(UUID uuid, String displayname);

    public abstract void removeInvite(UUID uuid);

    public abstract void removeBan(UUID uuid);

    public abstract boolean isBanned(UUID uuid);

    public abstract void removeJoinRequest(UUID uuid);

    public abstract Role getDefaultRole();

    public abstract void delete();

}
