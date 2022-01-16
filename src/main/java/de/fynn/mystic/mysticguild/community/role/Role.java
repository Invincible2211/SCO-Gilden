package de.fynn.mystic.mysticguild.community.role;

import de.fynn.mystic.mysticguild.community.permission.GuildPermission;
import de.fynn.mystic.mysticguild.community.permission.Permission;
import de.fynn.mystic.mysticguild.community.permission.PermissionData;
import de.fynn.mystic.mysticguild.community.permission.PermissionDataFactory;

public class Role {

    private String name;
    private int priority;
    private PermissionData data;

    public Role(String name, int priority, PermissionData data){
        this.name = name;
        this.priority = priority;
        this.data = data;
    }

    public boolean hasPermission(Permission permission){
        return data.containsPermission(permission);
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void rename(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PermissionData getData() {
        return data;
    }

    public static PermissionData getGuildSuperRole(){
        return new PermissionDataFactory().createGuildPermissionData().addAll().build();
    }

    public static PermissionData getAlianzSuperRole(){
        return new PermissionDataFactory().createAlianzPermissionData().addAll().build();
    }

    public static PermissionData getGuildDefaultRole(){
        return new PermissionDataFactory().createGuildPermissionData().build();
    }

    public static PermissionData getAlianzDefaultRole(){
        return new PermissionDataFactory().createAlianzPermissionData().build();
    }

}
