package de.fynn.mystic.mysticguild.community.permission;

import java.util.Arrays;

public class PermissionDataFactory {

    public GuildPermissionDataFactory createGuildPermissionData(){
        return new GuildPermissionDataFactory();
    }

    public AlianzPermissionDataFactory createAlianzPermissionData(){
        return new AlianzPermissionDataFactory();
    }

    public PermissionData getGuildPermissionData(String data){
        boolean[] permData = new boolean[data.length()];
        for (int i = 0; i < data.length(); i++) {
            if(data.charAt(i)=='1')permData[i]=true;
        }
        return new PermissionData(permData, PermissionData.PermissionType.GUILD);
    }

    public PermissionData getAlianzPermissionData(String data){
        boolean[] permData = new boolean[data.length()];
        for (int i = 0; i < data.length(); i++) {
            if(data.charAt(i)=='1')permData[i]=true;
        }
        return new PermissionData(permData, PermissionData.PermissionType.ALIANZ);
    }

    public static class GuildPermissionDataFactory{

        private final boolean[] permData;

        public GuildPermissionDataFactory(){
            int size =
            GuildPermission.MANAGE_GUILD.values().length +
            GuildPermission.MANAGE_MEMBERS.values().length +
                    2;
            permData = new boolean[size];
        }

        public GuildPermissionDataFactory addPermision(GuildPermission permission){
            permData[permission.getPosition()]=true;
            return this;
        }

        public GuildPermissionDataFactory addAll(){
            Arrays.fill(permData, true);
            return this;
        }

        public PermissionData build(){
            return new PermissionData(permData, PermissionData.PermissionType.GUILD);
        }

    }

    public static class AlianzPermissionDataFactory{

        private final boolean[] permData;

        public AlianzPermissionDataFactory(){
            int size =
            AlianzPermission.MANAGE_ALIANZ.values().length +
            AlianzPermission.MANAGE_MEMBERS.values().length +
                    2;
            permData = new boolean[size];
        }

        public AlianzPermissionDataFactory addPermision(AlianzPermission permission){
            permData[permission.getPosition()]=true;
            return this;
        }

        public AlianzPermissionDataFactory addAll(){
            Arrays.fill(permData, true);
            return this;
        }

        public PermissionData build(){
            return new PermissionData(permData, PermissionData.PermissionType.ALIANZ);
        }
    }

}
