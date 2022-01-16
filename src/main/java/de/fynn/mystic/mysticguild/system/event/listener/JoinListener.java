package de.fynn.mystic.mysticguild.system.event.listener;

import de.fynn.mystic.mysticguild.community.guild.GuildManager;
import de.fynn.mystic.mysticguild.system.data.SignMenuFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

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
