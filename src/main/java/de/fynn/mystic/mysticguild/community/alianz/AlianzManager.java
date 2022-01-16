package de.fynn.mystic.mysticguild.community.alianz;

import de.fynn.mystic.mysticguild.MysticGuild;
import de.fynn.mystic.mysticguild.community.guild.OfflineGuild;
import de.fynn.mystic.mysticguild.system.database.DBManager;
import de.fynn.mystic.mysticguild.system.utils.VariabelManager;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class AlianzManager {

    private static AlianzManager instance;
    private final HashMap<String,OfflineAlianz> alianz = new HashMap<>();
    private final HashMap<UUID,String> playerAlianz = new HashMap<>();
    private final HashMap<String,List<UUID>> alianzMembers = new HashMap<>();
    private final DBManager dbManager = DBManager.getInstance();

    public AlianzManager(){
        instance = this;
        loadAlianzFromDB();
        loadPlayerFromDB();
        loadMemberHashMap();
        startSync();
    }

    public void loadOnlineAlianz(String name){
        alianz.put(name,alianz.remove(name).getOnlineCommunity());
    }

    public void unloadOnlineAlianz(String name){
        alianz.put(name, ((Alianz)alianz.remove(name)).toOfflineCommunity());
    }

    public void addAlianz(Alianz a){
        alianz.put(a.getName(),a);
    }

    public void deleteAlianz(String name){
        alianz.remove(name).delete();
    }

    public OfflineAlianz getAlianz(String name){
        return alianz.get(name);
    }

    public boolean isOnlineAlianz(String name){
        return alianz.get(name) instanceof Alianz;
    }

    private void loadAlianzFromDB(){
        List<OfflineAlianz> alianzList = dbManager.getAlianzList();
        for (OfflineAlianz a:
                alianzList) {
            alianz.put(a.getName(),a);
        }
    }

    private void loadPlayerFromDB(){
        for (OfflineAlianz a:
                alianz.values()) {
            String guildName = a.getName();
            for (UUID uuid:
                    a.loadMembers()) {
                playerAlianz.put(uuid,guildName);
            }
        }
    }

    private void loadMemberHashMap() {
        for (OfflineAlianz a:
                alianz.values()) {
            alianzMembers.put(a.getName(),a.getMembers());
        }
    }

    public OfflineAlianz getGuildAlianz(UUID uuid){
        return alianz.get(playerAlianz.get(uuid));
    }

    public static AlianzManager getInstance() {
        return instance;
    }

    public boolean containsRole(String alianz,String role){
        return getAlianz(alianz).getRoleManager().containsRole(role);
    }

    public void createAlianz(UUID owner, String name){
        addAlianz(AlianzFactory.createAlianz(owner, name));
    }

    public void renameAlianz(String alianz1, String name){
        OfflineAlianz alianz2 = alianz.remove(alianz1);
        alianz2.setName(name);
        alianz.put(name,alianz2);
        List<UUID> members = alianzMembers.get(alianz1);
        for (UUID uuid:
                members) {
            playerAlianz.replace(uuid,name);
        }
        alianzMembers.remove(alianz1);
        alianzMembers.put(name,members);
    }

    public String getPlayerAlianzAsString(UUID uuid){
        return playerAlianz.get(uuid);
    }

    public OfflineAlianz getPlayerAlianz(UUID uuid){
        return getAlianz(playerAlianz.get(uuid));
    }

    public boolean hasALianz(UUID uuid){
        return playerAlianz.containsKey(uuid);
    }

    private void startSync(){
        Bukkit.getScheduler().runTaskTimerAsynchronously(MysticGuild.getInstance(), new Runnable() {
            @Override
            public void run() {
                for (OfflineAlianz a:
                        alianz.values()) {
                    for (UUID uuid:
                            a.syncMembersWithDB()) {
                    }
                }
            }
        }, 20L, VariabelManager.SYNC_WITH_DB);
    }

}
