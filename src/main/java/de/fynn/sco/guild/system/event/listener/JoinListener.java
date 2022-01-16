package de.fynn.sco.guild.system.event.listener;

import de.fynn.sco.guild.community.guild.GuildManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final GuildManager guildManager = GuildManager.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (guildManager.hasGuild(player.getUniqueId())){
            String guild = guildManager.getPlayerGuildAsString(player.getUniqueId());
            if (!guildManager.isOnlineGuild(guild)){
                guildManager.loadOnlineGuild(guild);
            }
        }else {
            guildManager.addGuildlessPlayer(player);
        }
    }

}
