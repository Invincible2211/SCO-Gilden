package de.fynn.mystic.mysticguild.community.permission;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PermissionManager {

    private static PermissionManager instance;

    private final HashMap<UUID,HashMap<KEY, List<Permission>>> playerPermissions = new HashMap<>();

    {
        instance = this;
    }

    public void addPermission(UUID uuid, KEY key, Permission... permissions){
        if(playerPermissions.containsKey(uuid)){
            HashMap<KEY,List<Permission>> perm = playerPermissions.get(uuid);
            if(perm.containsKey(key)){
                List<Permission> permissionList = perm.get(key);
                permissionList.addAll(Arrays.asList(permissions));
            }else {
                perm.put(key, Arrays.asList(permissions));
            }
        }else {
            HashMap<KEY,List<Permission>> perm = new HashMap<>();
            perm.put(key, Arrays.asList(permissions));
            playerPermissions.put(uuid,perm);
        }
    }

    public void removePermission(UUID uuid, KEY key, Permission... permissions){
        if (playerPermissions.containsKey(uuid)){
            if (playerPermissions.get(uuid).containsKey(key)){
                playerPermissions.get(uuid).get(key).removeAll(Arrays.asList(permissions));
            }
        }
    }

    public boolean hasPermission(UUID uuid, KEY key, Permission permission){
        if(playerPermissions.containsKey(uuid)){
            if (playerPermissions.get(uuid).containsKey(key)){
                return playerPermissions.get(uuid).get(key).contains(permission);
            }
        }
        return false;
    }

    public boolean hasPermissions(UUID uuid, KEY key, Permission... permissions){
        if(playerPermissions.containsKey(uuid)){
            if (playerPermissions.get(uuid).containsKey(key)){
                List<Permission> permList = playerPermissions.get(uuid).get(key);
                boolean a = true;
                for (Permission perm:
                        permissions) {
                    a = permList.contains(perm);
                    if(!a)return false;
                }
                return true;
            }
        }
        return false;

    }

    public static PermissionManager getInstance() {
        return instance;
    }

    public enum KEY {
        GUILD,ALIANZ;
    }

}
