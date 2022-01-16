package de.fynn.sco.guild.system.database;

import de.fynn.sco.guild.community.OfflineCommunity;
import de.fynn.sco.guild.community.role.Role;
import de.fynn.sco.guild.system.file.ConfigHandler;

import java.util.List;
import java.util.UUID;

public abstract class CommunityRoleDBManager {

    public CommunityRoleDBManager(OfflineCommunity parent){
        setup(parent.getUuid());
    }

    public final void setup(UUID uuid){
        DBConnector.getInstance().executeSQL("CREATE TABLE IF NOT EXISTS "+ ConfigHandler.getDBSchema()+"."+uuid.toString()+".role");
    }

    public abstract Role getDefaultRole();

    public abstract void setDefaultRole(String role);

    public abstract void addRole(Role role);

    public abstract void removeRole(String role);

    public abstract void setRole(UUID uuid, String role);

    public abstract String getMemberRole(UUID uuid);

    public abstract Role getRole(String role);

    public abstract List<String> getRoleList();

    public abstract void updateRole(String roleName, Role role);

}
