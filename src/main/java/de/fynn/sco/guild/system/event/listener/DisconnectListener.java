package de.fynn.sco.guild.system.event.listener;

import de.fynn.sco.guild.community.guild.Guild;
import de.fynn.sco.guild.community.guild.GuildManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class DisconnectListener implements Listener {

    private final GuildManager guildManager = GuildManager.getInstance();

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        playerLeaveServer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event){
        playerLeaveServer(event.getPlayer());
    }

    private void playerLeaveServer(Player player){
        if(guildManager.hasGuild(player.getUniqueId())){
            Guild guild = (Guild)guildManager.getPlayerGuild(player.getUniqueId());
            guild.removeOnlineMember(player.getUniqueId());
            if (guild.getOnlineMembers().size()==0){
                guildManager.unloadOnlineGuild(guild.getName());
            }
        }else {
            guildManager.removeGuildlessPlayer(player);
        }
    }

}
