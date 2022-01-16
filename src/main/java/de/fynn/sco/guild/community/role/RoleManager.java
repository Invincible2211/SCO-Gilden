package de.fynn.sco.guild.community.role;

import de.fynn.sco.guild.community.OfflineCommunity;
import de.fynn.sco.guild.community.alianz.OfflineAlianz;
import de.fynn.sco.guild.community.guild.OfflineGuild;
import de.fynn.sco.guild.community.permission.PermissionManager;
import de.fynn.sco.guild.system.database.CommunityRoleDBManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RoleManager {

    private static final PermissionManager permissionManager = PermissionManager.getInstance();

    private final OfflineCommunity parent;
    private final CommunityRoleDBManager dbManager;
    private final HashMap<UUID, String> memberRoles = new HashMap<>();
    private final HashMap<String, List<UUID>> rolePlayerMap = new HashMap<>();
    private final HashMap<String, Role> roles = new HashMap<>();
    private Role defaultRole;

    public RoleManager(OfflineCommunity parent, CommunityRoleDBManager dbManager){
        this.parent = parent;
        this.dbManager = dbManager;
        init();
    }

    private void init(){
        defaultRole = dbManager.getDefaultRole();
        List<String> roleList = dbManager.getRoleList();
        for (String s:
             roleList) {
            roles.put(s, dbManager.getRole(s));
        }
        for (UUID uuid:
                parent.getMembers()) {
            String roleAsString = dbManager.getMemberRole(uuid);
            memberRoles.put(uuid, roleAsString);
            if (rolePlayerMap.containsKey(roleAsString)){
                rolePlayerMap.get(roleAsString).add(uuid);
            }else {
                List<UUID> list = new ArrayList<>();
                list.add(uuid);
                rolePlayerMap.put(roleAsString,list);
            }
        }
        insertInPermissionManager();
    }

    public void addPlayer(UUID uuid){
        memberRoles.put(uuid, defaultRole.getName());
    }

    public void removePlayer(UUID uuid){
        memberRoles.remove(uuid);
    }

    public void setRole(UUID uuid, String role){
        memberRoles.replace(uuid, role);
        dbManager.setRole(uuid, role);
    }

    public Role getRole(UUID uuid){
        return roles.get(memberRoles.get(uuid));
    }

    public Role getDefaultRole(){
        return defaultRole;
    }

    public void setDefaultRole(Role role){
        defaultRole = role;
        dbManager.setDefaultRole(role.getName());
    }

    public Role getRoleFromString(String role){
        return roles.get(role);
    }

    public boolean containsRole(String role){
        return roles.containsKey(role);
    }

    public void addRole(Role role){
        roles.put(role.getName(),role);
        dbManager.addRole(role);
    }

    public void renameRole(String role, String name){
        Role role1 = roles.remove(role);
        role1.rename(name);
        roles.put(name,role1);
        List<UUID> members = rolePlayerMap.get(role);
        for (UUID uuid:
             members) {
            memberRoles.replace(uuid,name);
        }
    }

    private void insertInPermissionManager(){
        PermissionManager.KEY key = parent instanceof OfflineGuild ? PermissionManager.KEY.GUILD :
                parent instanceof OfflineAlianz ? PermissionManager.KEY.ALIANZ :
                        null;
        for (UUID uuid:
                memberRoles.keySet()) {
            permissionManager.addPermission(uuid, key, getRole(uuid).getData().getPermissions());
        }
    }

}
