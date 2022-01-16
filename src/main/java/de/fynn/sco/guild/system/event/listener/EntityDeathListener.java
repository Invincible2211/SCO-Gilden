package de.fynn.sco.guild.system.event.listener;

import de.fynn.sco.guild.community.alianz.AlianzManager;
import de.fynn.sco.guild.community.alianz.OfflineAlianz;
import de.fynn.sco.guild.community.guild.GuildManager;
import de.fynn.sco.guild.community.guild.OfflineGuild;
import de.fynn.sco.guild.system.utils.VariabelManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener {

    private final GuildManager guildManager = GuildManager.getInstance();
    private final AlianzManager alianzManager = AlianzManager.getInstance();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        Player p = event.getEntity().getKiller();
        if(p!=null){
            if(guildManager.hasGuild(p.getUniqueId())){
                OfflineGuild guild = guildManager.getPlayerGuild(p.getUniqueId());
                double xp = guild.getXp();
                xp += event.getDroppedExp()* VariabelManager.GUILD_XP_FROM_KILL;
                if(xp>=VariabelManager.GUILD_XP_PER_LEVEL*Math.pow(VariabelManager.GUILD_LEVEL_MODIFIER_PER_LEVEL, guild.getLevel())){
                    guild.setXp(xp%VariabelManager.GUILD_XP_PER_LEVEL*Math.pow(VariabelManager.GUILD_LEVEL_MODIFIER_PER_LEVEL, guild.getLevel()));
                    guild.addLevel();
                }
            }
            if(alianzManager.hasALianz(p.getUniqueId())){
                OfflineAlianz alianz = alianzManager.getPlayerAlianz(p.getUniqueId());
                double xp = alianz.getXp();
                xp += event.getDroppedExp()*VariabelManager.ALIANZ_XP_FROM_KILL;
                if(xp>=VariabelManager.ALIANZ_XP_PER_LEVEL*Math.pow(VariabelManager.ALIANZ_LEVEL_MODIFIER_PER_LEVEL, alianz.getLevel())){
                    alianz.setXp(xp%VariabelManager.ALIANZ_XP_PER_LEVEL*Math.pow(VariabelManager.ALIANZ_LEVEL_MODIFIER_PER_LEVEL, alianz.getLevel()));
                    alianz.addLevel();
                }
            }
        }
    }

}
