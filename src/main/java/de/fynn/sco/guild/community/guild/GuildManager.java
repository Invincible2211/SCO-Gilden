package de.fynn.sco.guild.community.guild;

import de.fynn.sco.guild.Guild;
import de.fynn.sco.guild.system.database.DBManager;
import de.fynn.sco.guild.system.utils.VariabelManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class GuildManager {

    private static GuildManager instance;
    private final HashMap<String,OfflineGuild> guilds = new HashMap<>();
    public static final List<Player> guildLessPlayer = new ArrayList<>();
    private final HashMap<UUID,String> playerGuild = new HashMap<>();
    private final HashMap<String,List<UUID>> guildMembers = new HashMap<>();
    private final DBManager dbManager = DBManager.getInstance();

    public GuildManager(){
        instance = this;
        loadGuildFromDB();
        loadPlayerFromDB();
        loadMemberHashMap();
        startSync();
    }

    public void loadOnlineGuild(String name){
        guilds.put(name,guilds.remove(name).getOnlineCommunity());
    }

    public void unloadOnlineGuild(String name){
        guilds.put(name,((de.fynn.sco.guild.community.guild.Guild)guilds.remove(name)).toOfflineCommunity());
    }

    public void addGuild(de.fynn.sco.guild.community.guild.Guild guild){
        guilds.put(guild.getName(),guild);
    }

    public void deleteGuild(String name){
        guilds.remove(name).delete();
    }

    public OfflineGuild getGuild(String name){
        return guilds.get(name);
    }

    public boolean isOnlineGuild(String name){
        return guilds.get(name) instanceof de.fynn.sco.guild.community.guild.Guild;
    }

    private void loadGuildFromDB(){
        List<OfflineGuild> guildList = dbManager.getGuildList();
        for (OfflineGuild guild:
             guildList) {
            guilds.put(guild.getName(),guild);
        }
    }

    private void loadPlayerFromDB(){
        for (OfflineGuild guild:
             guilds.values()) {
            String guildName = guild.getName();
            for (UUID uuid:
                 guild.loadMembers()) {
                playerGuild.put(uuid,guildName);
            }
        }
    }

    private void loadMemberHashMap() {
        for (OfflineGuild guild:
                guilds.values()) {
            guildMembers.put(guild.getName(),guild.getMembers());
        }
    }

    public OfflineGuild getPlayerGuild(UUID uuid){
        return guilds.get(playerGuild.get(uuid));
    }

    public String getPlayerGuildAsString(UUID uuid){
        return guilds.get(playerGuild.get(uuid)).getName();
    }

    public static GuildManager getInstance() {
        return instance;
    }

    public boolean containsRole(String guild,String role){
        return getGuild(guild).getRoleManager().containsRole(role);
    }

    public void addGuildlessPlayer(Player player){
        guildLessPlayer.add(player);
    }

    public void removeGuildlessPlayer(Player player){
        guildLessPlayer.remove(player);
    }

    public boolean hasGuild(UUID uuid){
        return playerGuild.containsKey(uuid);
    }

    public void createGuild(UUID owner, String name){
        addGuild(GuildFactory.createGuild(owner, name));
    }

    public void renameGuild(String guild, String name){
        OfflineGuild g = guilds.remove(guild);
        g.setName(name);
        guilds.put(name,g);
        List<UUID> members = guildMembers.get(guild);
        for (UUID uuid:
             members) {
            playerGuild.replace(uuid,name);
        }
        guildMembers.remove(guild);
        guildMembers.put(name,members);
    }

    private void startSync(){
        Bukkit.getScheduler().runTaskTimerAsynchronously(Guild.getInstance(), new Runnable() {
            @Override
            public void run() {
                for (OfflineGuild g:
                        guilds.values()) {
                    for (UUID uuid:
                         g.syncMembersWithDB()) {
                        guildLessPlayer.remove(Bukkit.getPlayer(uuid));
                    }
                }
            }
        }, 20L, VariabelManager.SYNC_WITH_DB);
    }

}
