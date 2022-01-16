package de.fynn.mystic.mysticguild.community.permission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermissionData {

    private final PermissionType permissionType;
    private boolean[] data;

    protected PermissionData(boolean[] data, PermissionType type){
        permissionType = type;
        this.data = data;
    }

    public boolean containsPermission(Permission permission){
        switch (permissionType){
            case GUILD:
                return permission instanceof GuildPermission && data[permission.getPosition()];
            case ALIANZ:
                return permission instanceof AlianzPermission && data[permission.getPosition()];
            default:
                return false;
        }
    }

    public void editData(int pos){
        data[pos]=!data[pos];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (boolean b:
             data) {
            builder.append(b?"1":"0");
        }
        return builder.toString();
    }

    public static enum PermissionType{
        GUILD,ALIANZ;
    }

    public Permission[] getPermissions(){
        List<Permission> permissionList = new ArrayList<>();
        switch (permissionType){
            case GUILD:
                List<Permission> guildPermissions = new ArrayList<>();
                guildPermissions.addAll(Arrays.asList(GuildPermission.values()));
                guildPermissions.addAll(Arrays.asList(GuildPermission.MANAGE_GUILD.values()));
                guildPermissions.addAll(Arrays.asList(GuildPermission.MANAGE_MEMBERS.values()));
                for (int i = 0; i < data.length; i++) {
                    if (data[i]){
                        permissionList.add(guildPermissions.get(i));
                    }
                }
                break;
            case ALIANZ:
                List<Permission> alianzPermissions = new ArrayList<>();
                alianzPermissions.addAll(Arrays.asList(AlianzPermission.values()));
                alianzPermissions.addAll(Arrays.asList(AlianzPermission.MANAGE_ALIANZ.values()));
                alianzPermissions.addAll(Arrays.asList(AlianzPermission.MANAGE_MEMBERS.values()));
                for (int i = 0; i < data.length; i++) {
                    if (data[i]){
                        permissionList.add(alianzPermissions.get(i));
                    }
                }
                break;
        }
        return permissionList.toArray(new Permission[0]);
    }

}
